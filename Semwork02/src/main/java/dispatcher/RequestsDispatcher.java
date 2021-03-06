package dispatcher;

import controller.LogicController;
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
                LogicController logicController = new LogicController(request.getParameter("role"));
                logicController.draw(request.getParameter("choice"), request.getParameter("button")); //проверка на выигравшего
///
                int[][]arr = logicController.getMatrix();
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr.length; j++) {
                        System.out.print(arr[i][j]);
                    }
                    System.out.println();
                }
                ////
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
