package controller;

import client.ChatClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Payload;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class MainController {
    private int choice = 0;
    private Stage stage;
    private ArrayList arrBtn;

    public MainController(Stage stage) {
        this.stage = stage;
    }

    public void start() throws IOException {
        // отображение
        Parent root = FXMLLoader.load(getClass().getResource("/main.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Order_and_Chaos");
        stage.setWidth(750);
        stage.setHeight(600);
        stage.show();

        // массив кнопок
        arrBtn = getArr(root);

        // механика крестика и нолика
        Button btnO = (Button) root.lookup("#btnO");
        Button btnX = (Button) root.lookup("#btnX");
        btnO.setOnMouseClicked(event -> {
            choice = 1;
        });
        btnX.setOnMouseClicked(event -> {
            choice = 2;
        });

        // механика остальных кнопок
        for (int i = 0; i < arrBtn.size(); i++) {
            Button button = (Button) arrBtn.get(i);
            button.setOnMouseClicked(event -> {
                ObjectMapper objectMapper = new ObjectMapper();
                Payload payload = new Payload();
                payload.setHeader("Command");
                LinkedHashMap<String, String> commandPayload = new LinkedHashMap<>();
                commandPayload.put("command", "get changes");
                commandPayload.put("choice", String.valueOf(choice));

                if (choice == 1) {
                    button.setText("O");
                    commandPayload.put("button", String.valueOf(button));
                } else if (choice == 2) {
                    button.setText("X");
                    commandPayload.put("button", String.valueOf(button));
                }

                payload.setPayload(commandPayload);
                try {
                    String jsonProduct = objectMapper.writeValueAsString(payload);
                    ChatClient.sendMessage(jsonProduct);
                } catch (JsonProcessingException e) {
                    throw new IllegalStateException(e);
                }
            });
        }
    }

    public ArrayList getArr(Parent root) {
        ArrayList<Button> arrayList = new ArrayList();
        arrayList.add((Button) root.lookup("#btn1"));
        arrayList.add((Button) root.lookup("#btn2"));
        arrayList.add((Button) root.lookup("#btn3"));
        arrayList.add((Button) root.lookup("#btn4"));
        arrayList.add((Button) root.lookup("#btn5"));
        arrayList.add((Button) root.lookup("#btn6"));
        arrayList.add((Button) root.lookup("#btn7"));
        arrayList.add((Button) root.lookup("#btn8"));
        arrayList.add((Button) root.lookup("#btn9"));
        arrayList.add((Button) root.lookup("#btn10"));
        arrayList.add((Button) root.lookup("#btn11"));
        arrayList.add((Button) root.lookup("#btn12"));
        arrayList.add((Button) root.lookup("#btn13"));
        arrayList.add((Button) root.lookup("#btn14"));
        arrayList.add((Button) root.lookup("#btn15"));
        arrayList.add((Button) root.lookup("#btn16"));
        arrayList.add((Button) root.lookup("#btn17"));
        arrayList.add((Button) root.lookup("#btn18"));
        arrayList.add((Button) root.lookup("#btn19"));
        arrayList.add((Button) root.lookup("#btn20"));
        arrayList.add((Button) root.lookup("#btn21"));
        arrayList.add((Button) root.lookup("#btn22"));
        arrayList.add((Button) root.lookup("#btn23"));
        arrayList.add((Button) root.lookup("#btn24"));
        arrayList.add((Button) root.lookup("#btn25"));
        arrayList.add((Button) root.lookup("#btn26"));
        arrayList.add((Button) root.lookup("#btn27"));
        arrayList.add((Button) root.lookup("#btn28"));
        arrayList.add((Button) root.lookup("#btn29"));
        arrayList.add((Button) root.lookup("#btn30"));
        arrayList.add((Button) root.lookup("#btn31"));
        arrayList.add((Button) root.lookup("#btn32"));
        arrayList.add((Button) root.lookup("#btn33"));
        arrayList.add((Button) root.lookup("#btn34"));
        arrayList.add((Button) root.lookup("#btn35"));
        arrayList.add((Button) root.lookup("#btn36"));
        return arrayList;
    }

    public void click(Integer choice, String button) {
        for (int i = 0; i < arrBtn.size(); i++) {
            Button btn = (Button) arrBtn.get(i);
            if (choice == 1 & button.substring(0, 34).equals(String.valueOf(btn).substring(0, 34))) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        btn.setText("O");
                    }
                });
            } else if (choice == 2 & button.substring(0, 34).equals(String.valueOf(btn).substring(0, 34))) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        btn.setText("X");
                    }
                });
            }
        }
    }
}
