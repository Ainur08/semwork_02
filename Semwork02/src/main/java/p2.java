import client.ChatClient;
import controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.User;

public class p2 extends Application{
    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        User user = new User();
        ChatClient client = new ChatClient();
        MainController mainController = new MainController(stage);
        client.setMainController(mainController);
        client.startConnection("127.0.0.1", 7000);
        user.setRole("chaos");
        mainController.start();
    }
}
