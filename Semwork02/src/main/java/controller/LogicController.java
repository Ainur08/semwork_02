package controller;

public class LogicController {
    private int[][] matrix;
    private String role;
    private int flag;

    public LogicController(String role) {
        this.role = role;
        matrix = new int[6][6];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    // 1 - O, 2 - X
    public void draw(String choice, String button) {
        if (button.substring(13, 15).contains(",")) {
            String[] str = button.substring(13, 15).split(",");
            matrix[(Integer.valueOf(str[0])-1) % 6][Integer.valueOf(str[0]) / 6] = Integer.valueOf(choice);
        } else {
            matrix[(Integer.valueOf(button.substring(13, 15)) -1)% 6][Integer.valueOf(button.substring(13, 15)) / 6] = Integer.valueOf(choice);
        }

    }

    // 0 - default, 1-order, 2 - chaos
    private int checkWin() {
        return 0;
    }

    public int[][] getMatrix() {
        return matrix;
    }
}


















