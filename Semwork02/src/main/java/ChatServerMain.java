import server.MultiClientServer;

public class ChatServerMain {
    public static void main(String[] args) {
        MultiClientServer multiClientServer = new MultiClientServer();
        multiClientServer.start(7000);
    }
}
