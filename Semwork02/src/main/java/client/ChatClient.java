package client;

import com.fasterxml.jackson.databind.ObjectMapper;
import controller.MainController;
import model.Payload;
import model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class ChatClient {
    private ChatClient chatClient;
    private Socket clientSocket;
    private static PrintWriter writer; // поток чтения в сокет
    private BufferedReader reader; // поток чтения из сокета
    private MainController mainController;

    public void startConnection(String ip, int port) {
        try {
            chatClient = this;
            clientSocket = new Socket(ip, port);
            writer = new PrintWriter(clientSocket.getOutputStream(), true);
            reader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            new ReadMessage().start();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private class ReadMessage extends Thread {
        @Override
        public void run() {
            try {
                String message;
                while (true) {
                    message = reader.readLine();
                    System.out.println(message);
                    if (message != null) {
                        if (message.contains("changes")) {
                            ObjectMapper objectMapper = new ObjectMapper();
                            try {
                                Payload payload = objectMapper.readValue(message, Payload.class);
                                HashMap<String, String> map = (HashMap<String, String>) payload.getPayload();
                                mainController.click(Integer.valueOf(map.get("choice")), map.get("button"));
                            } catch (Exception e) {
                                throw new IllegalStateException(e);
                            }
                        }
                    }
                }
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public static void sendMessage(String message) {
        writer.println(message);
    }

    public MainController getMainController() {
        return mainController;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
