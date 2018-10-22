package benetin.shawndarbygame;

/*
 * Made By: Shawn Benedict
 * Date: Oct 19, 2018
*home screen for the game
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author shawnb58
 */
public class HomeController implements Initializable {

    @FXML
    private void open2048(MouseEvent m) {//maybe merge all opening stuff into one method with if statements?
        Parent parent2048;
        try {
            parent2048 = FXMLLoader.load(getClass().getResource("/fxml/twenty48.fxml")); //where FXMLPage2 is the name of the scene

            Scene scene2048 = new Scene(parent2048);
//get reference to the stage 
            Stage stage = (Stage) ((Node) m.getSource()).getScene().getWindow();

            stage.hide(); //optional
            stage.setScene(scene2048); //puts the new scence in the stage

//stage.setTitle("Page 2"); //changes the title
            stage.show(); //shows the new page
            scene2048.getRoot().requestFocus();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void openWoodBlock(MouseEvent m) {
        Parent woodBlockParent;
        try {
            woodBlockParent = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml")); //where FXMLPage2 is the name of the scene

            Scene woodBlockScene = new Scene(woodBlockParent);
//get reference to the stage 
            Stage stage = (Stage) ((Node) m.getSource()).getScene().getWindow();

            stage.hide(); //optional
            stage.setScene(woodBlockScene); //puts the new scence in the stage

//stage.setTitle("Page 2"); //changes the title
            stage.show(); //shows the new page
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
