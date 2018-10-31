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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
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
private ImageView imgMusic;
@FXML
private ImageView imgQ;
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
    if (MainApp.credits>10000 && !imgMultiply.isDisabled()){
        MainApp.credits-=10000;
        MainApp.multiplier++;
        lblCredits.setText(""+MainApp.credits);
        lblMultiplier.setText(""+MainApp.multiplier);
        if (MainApp.multiplier==10){
            imgMultiply.setDisable(true);
        }
    }
}
@FXML
private void qClick(MouseEvent m){
    if (MainApp.credits>100000){
        MainApp.credits-=10000;
        lblCredits.setText(""+MainApp.credits);
         MainApp.homeFlash=true;
         imgQ.setDisable(true);
    }
    
    
    
   
}
@FXML
private void musicClick(MouseEvent m){
    if (MainApp.credits>1000){
        MainApp.credits-=1000;
        
        lblCredits.setText(""+MainApp.credits);
        MainApp.song="cool";//sets cooler song
    
        
            imgMusic.setDisable(true);
             MainApp.player.stop();
      if (MainApp.song.equals("cool")){
          imgMusic.setDisable(true);
      }
            if (MainApp.song.equals("elevator")) {

            MainApp.player = new MediaPlayer((new Media(getClass().getResource("/Elevator-music.mp3").toString())));
        } else {
            MainApp.player = new MediaPlayer((new Media(getClass().getResource("/uke.mp3").toString())));
        }
       
        MainApp.player.setCycleCount(MediaPlayer.INDEFINITE);
        MainApp.player.play();
        
    }
}
    
    

    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      lblCredits.setText("$"+MainApp.credits);
      lblMultiplier.setText(""+MainApp.multiplier);
      if (MainApp.multiplier==10){
          imgMultiply.setDisable(true);
      }
       if (MainApp.homeFlash){
           imgQ.setDisable(true);
       }
      
      if (MainApp.song.equals("cool")){
          imgMusic.setDisable(true);
      }
       MainApp.playing= MainApp.player.getStatus().equals(Status.PLAYING);
       if (!MainApp.playing){
               MainApp.player.stop();
            if (MainApp.song.equals("elevator")) {

            MainApp.player = new MediaPlayer((new Media(getClass().getResource("/Elevator-music.mp3").toString())));
        } else {
            MainApp.player = new MediaPlayer((new Media(getClass().getResource("/uke.mp3").toString())));
        }
       
        MainApp.player.setCycleCount(MediaPlayer.INDEFINITE);
        MainApp.player.play();}
    }    
    
}
