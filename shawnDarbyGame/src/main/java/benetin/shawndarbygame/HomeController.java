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
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

/**
 * FXML Controller class
 *
 * @author shawnb58
 */
public class HomeController implements Initializable {

    @FXML
    private Label lblMoney;//show money
    @FXML
    private Rectangle recCheat;//when clicked it gives a bunch of money
    @FXML
    private Rectangle recFlash;//rec that can flash
    Image cheat = new Image("/okCursor.png");//cursor for when hovering over cheat image
    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), ae -> flashHome()));//flashing background

    private void flashHome() { //flashing background
        if (recFlash.isVisible()) {
            recFlash.setVisible(false);
        } else {
            recFlash.setVisible(true);
        }
    }

    @FXML
    private void cheat() {
        MainApp.credits = 999999;
        lblMoney.setText("$" + MainApp.credits);
    }

    @FXML
    private void open2048(MouseEvent m) {//open 2048 game
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
    private void openDodge(MouseEvent m) {//open dodge game
        Parent dodgeParent;
        try {
            dodgeParent = FXMLLoader.load(getClass().getResource("/fxml/dodge.fxml")); //where FXMLPage2 is the name of the scene

            Scene dodgeScene = new Scene(dodgeParent);
//get reference to the stage 
            Stage stage = (Stage) ((Node) m.getSource()).getScene().getWindow();

            stage.hide(); //optional
            stage.setScene(dodgeScene); //puts the new scence in the stage

//stage.setTitle("Page 2"); //changes the title
            stage.show(); //shows the new page
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void storeClick(ActionEvent e) {//open store
        Parent storeParent;
        try {
            storeParent = FXMLLoader.load(getClass().getResource("/fxml/store.fxml")); //where FXMLPage2 is the name of the scene

            Scene storeScene = new Scene(storeParent);
//get reference to the stage 
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

            stage.hide(); //optional
            stage.setScene(storeScene); //puts the new scence in the stage

//stage.setTitle("Page 2"); //changes the title
            stage.show(); //shows the new page
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    private void openWoodBlock(MouseEvent m) {//open wood game
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
        lblMoney.setText("$" + MainApp.credits);

        recCheat.setCursor(new ImageCursor(cheat));//for hovering over cheat rec
        MainApp.playing = MainApp.player.getStatus().equals(MediaPlayer.Status.PLAYING);
        if (!MainApp.playing) {//checks if there's music playing and if not then play music
            MainApp.player.stop();
            if (MainApp.song.equals("elevator")) {

                MainApp.player = new MediaPlayer((new Media(getClass().getResource("/Elevator-music.mp3").toString())));
            } else {
                MainApp.player = new MediaPlayer((new Media(getClass().getResource("/uke.mp3").toString())));
            }

            MainApp.player.setCycleCount(MediaPlayer.INDEFINITE);
            MainApp.player.play();
        }
        if (MainApp.homeFlash) {//flashy graphics timeline
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
            timeline.play();
        }
    }
}
