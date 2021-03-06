package benetin.shawndarbygame;

/*
 * Made By: Shawn Benedict
 * Date: Oct 29, 2018
 * Made to
 */
import benetin.shawndarbygame.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author shawnb58
 */
public class WinLoseController implements Initializable {

    @FXML
    private Label lblWinLose;//shows if won or lost
    @FXML
    private Label lblMessage;//shows how much money they currently have
    @FXML
    private Button btnHome;//go to homescreen
    @FXML
    private Button btnReset;//play last game again

    @FXML
    private void goHome() {//go home
        Parent parentHome;
        try {
            parentHome = FXMLLoader.load(getClass().getResource("/fxml/home.fxml")); //where FXMLPage2 is the name of the scene

            Scene sceneHome = new Scene(parentHome);
//get reference to the stage 
            Stage stage = (Stage) ((Node) lblWinLose).getScene().getWindow();

            stage.hide(); //optional
            stage.setScene(sceneHome); //puts the new scence in the stage

//stage.setTitle("Page 2"); //changes the title
            stage.show(); //shows the new page
            sceneHome.getRoot().requestFocus();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
 @FXML
    private void playAgain() {//play last game again
Parent parentLast;
        try {
            parentLast = FXMLLoader.load(getClass().getResource(MainApp.pLastScene)); //where FXMLPage2 is the name of the scene

            Scene sceneLast = new Scene(parentLast);
//get reference to the stage 
            Stage stage = (Stage) ((Node) lblWinLose).getScene().getWindow();

            stage.hide(); //optional
            stage.setScene(sceneLast); //puts the new scence in the stage

//stage.setTitle("Page 2"); //changes the title
            stage.show(); //shows the new page
            sceneLast.getRoot().requestFocus();
        } catch (IOException ex) {
            ex.printStackTrace();
        }        
        
        
        MainApp.initialize=true;
        
//        Stage stage = (Stage) ((Node) lblWinLose).getScene().getWindow();
//        stage.setScene(scene);
//        MainApp.pLastScene.getRoot().requestFocus();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //show corresponding messages
        if (MainApp.pWin) {
            lblWinLose.setText("YOU WIN");
            lblMessage.setText(MainApp.pMessage);
        } else if (!MainApp.pWin) {
            lblWinLose.setText("YOU LOST");
            lblMessage.setText(MainApp.pMessage);
        }

    }
}
