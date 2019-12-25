import client.ChatClient;
import controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChatClientMain extends Application{
    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        ChatClient client = new ChatClient();
        MainController mainController = new MainController(stage);
        client.setMainController(mainController);
        client.startConnection("127.0.0.1", 7000);
        mainController.start();
    }
}
