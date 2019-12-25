package server;

import dispatcher.RequestsDispatcher;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

public class MultiClientServer {
    private List<ClientHandler> clients;
    private RequestsDispatcher requestsDispatcher;


    public MultiClientServer() {
        clients = new ArrayList<ClientHandler>();
        requestsDispatcher = new RequestsDispatcher();
    }

    public void start(int port) {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        for (; ; ) {
            try {
                new ClientHandler(serverSocket.accept(), this).start();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public List<ClientHandler> getClients() {
        return clients;
    }

    public RequestsDispatcher getRequestsDispatcher() {
        return requestsDispatcher;
    }
}
