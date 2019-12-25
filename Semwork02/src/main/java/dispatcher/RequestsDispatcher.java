package dispatcher;

import model.Changes;
import protocol.Request;
import protocol.Response;
import server.ClientHandler;

public class RequestsDispatcher {
    private ClientHandler clientHandler;

    public void handleRequest(String jsonRequest) {
        System.out.println(jsonRequest);
        Request request = new Request(jsonRequest);
        String command = request.getCommand();
        switch (command) {
            case "get changes": {
                Changes changes = new Changes(request.getParameter("choice"),
                        request.getParameter("button"));
                clientHandler.sendMessageAllClient(Response.build(changes));
            }
            break;
        }
    }

    public void setClientHandler(ClientHandler clientHandler) {
        this.clientHandler = clientHandler;
    }
}
