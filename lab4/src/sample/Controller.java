package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;

public class Controller {
    @FXML
    Button executeBtn, editBtn;
    @FXML
    TextField batchFileTxt, inputTxt, outputTxt;

    public boolean checkInput(){
        if(batchFileTxt.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Batch file path needed!");

            alert.showAndWait();
            return false;
        }

        return true;
    }

    public void execute() {
        if (checkInput()) {
            ProcessBuilder builder = new ProcessBuilder(batchFileTxt.getText(), inputTxt.getText());
            //builder.redirectInput(new File());
            builder.redirectOutput(new File(outputTxt.getText()));

            try {
                builder.start();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void edit() {
        if (checkInput()) {
            ProcessBuilder builder = new ProcessBuilder("notepad.exe", batchFileTxt.getText());
            builder.redirectInput(new File(batchFileTxt.getText()));

            try {
                builder.start();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
