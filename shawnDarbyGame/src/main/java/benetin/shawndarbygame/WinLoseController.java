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
    private Label lblWinLose;
    @FXML
    private Label lblMessage;
    @FXML
    private Button btnHome;
    @FXML
    private Button btnReset;

    @FXML
    private void goHome() {
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
    private void playAgain() {
        Stage stage = (Stage) ((Node) lblWinLose).getScene().getWindow();
        stage.setScene(MainApp.pLastScene);
        MainApp.pLastScene.getRoot().requestFocus();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (MainApp.pWin) {
            lblWinLose.setText("YOU WIN");
            lblMessage.setText(MainApp.pMessage);
        } else if (!MainApp.pWin) {
            lblWinLose.setText("YOU LOST");
            lblMessage.setText(MainApp.pMessage);
        }

    }
}
