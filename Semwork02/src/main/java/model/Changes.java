package model;

public class Changes {
    private String choice;
    private String button;

    public Changes(String choice, String button) {
        this.choice = choice;
        this.button = button;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }
}
