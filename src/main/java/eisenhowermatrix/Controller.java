package eisenhowermatrix;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="addGoalButton"
    private Button addGoalButton; // Value injected by FXMLLoader

    @FXML // fx:id="checkBoxImportant"
    private CheckBox checkBoxImportant; // Value injected by FXMLLoader

    @FXML // fx:id="checkBoxUrgently"
    private CheckBox checkBoxUrgently; // Value injected by FXMLLoader

    @FXML // fx:id="goalName"
    private TextField goalName; // Value injected by FXMLLoader

    @FXML // fx:id="importantUrgently"
    private Label importantUrgently; // Value injected by FXMLLoader

    @FXML // fx:id="unImportantUrgently"
    private Label unImportantUrgently; // Value injected by FXMLLoader

    @FXML // fx:id="unImportantUnUrgently"
    private Label unImportantUnUrgently; // Value injected by FXMLLoader

    @FXML // fx:id="importantUnUrgently"
    private Label importantUnUrgently; // Value injected by FXMLLoader

    void fileAlert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("File reading error");
        alert.setHeaderText(null);
        alert.setContentText("Could not read from file");
        alert.showAndWait();
        System.exit(0);
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        File file = new File("goals.txt");
        try {
            Scanner readFile = new Scanner(file);
            while (readFile.hasNextLine()){
                String goal = readFile.nextLine();
                String[] words = goal.split("&");
                String gName = words[0];
                boolean important = words[1].equals("true");
                boolean urgently = words[2].equals("true");
                if(important && urgently){
                    String g = importantUrgently.getText() + "\n" + gName;
                    importantUrgently.setText(g);
                }else if (important && !urgently){
                    String g = importantUnUrgently.getText() + "\n" + gName;
                    importantUnUrgently.setText(g);
                }else if (!important && urgently){
                    String g = unImportantUrgently.getText() + "\n" + gName;
                    unImportantUrgently.setText(g);
                }else {
                    String g = unImportantUnUrgently.getText() + "\n" + gName;
                    unImportantUnUrgently.setText(g);
                }
            }
        } catch (FileNotFoundException e) {
            fileAlert();
        }
        try {
            FileWriter writeFile = new FileWriter(file, true);
            addGoalButton.setOnAction(actionEvent -> {
                if(checkBoxImportant.isSelected() && checkBoxUrgently.isSelected()){
                    String goal = importantUrgently.getText() + "\n" + goalName.getText();
                    importantUrgently.setText(goal);
                }else if (checkBoxImportant.isSelected() && !checkBoxUrgently.isSelected()){
                    String goal = importantUnUrgently.getText() + "\n" + goalName.getText();
                    importantUnUrgently.setText(goal);
                }else if (!checkBoxImportant.isSelected() && checkBoxUrgently.isSelected()){
                    String goal = unImportantUrgently.getText() + "\n" + goalName.getText();
                    unImportantUrgently.setText(goal);
                }else {
                    String goal = unImportantUnUrgently.getText() + "\n" + goalName.getText();
                    unImportantUnUrgently.setText(goal);
                }
                try {
                    writeFile.write(goalName.getText() + "&" + checkBoxImportant.isSelected() + "&" + checkBoxUrgently.isSelected() + "\n");
                    writeFile.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        } catch (IOException e) {
            fileAlert();
        }

    }
}
