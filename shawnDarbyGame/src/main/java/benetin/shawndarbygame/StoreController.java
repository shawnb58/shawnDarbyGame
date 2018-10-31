/*
 * Made By: Shawn Benedict
 * Date: Oct 31, 2018
 * Made to
 */
package benetin.shawndarbygame;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author shawnb58
 */
public class StoreController implements Initializable {
@FXML
private Label lblCredits;
@FXML
private Label lblMultiplier;
@FXML
private ImageView imgMultiply;
 @FXML
    private void goHome(ActionEvent e) {
        Parent parentHome;
        try {
            parentHome = FXMLLoader.load(getClass().getResource("/fxml/home.fxml")); //where FXMLPage2 is the name of the scene

            Scene sceneHome = new Scene(parentHome);
//get reference to the stage 
            Stage stage = (Stage) ((Node) lblCredits).getScene().getWindow();

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
private void multiplierClick(MouseEvent m){
    if (MainApp.credits>10000){
        MainApp.credits-=10000;
        MainApp.multiplier++;
        lblCredits.setText(""+MainApp.credits);
        lblMultiplier.setText(""+MainApp.multiplier);
        if (MainApp.multiplier==10){
            imgMultiply.setDisable(true);
        }
    }
}
    
    

    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      lblCredits.setText("$"+MainApp.credits);
      
    }    
    
}
