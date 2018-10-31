//Made by Shawn Benedict and Darby Martin
//Made on 10/15/18
//made to allow users to choose from 3 different games and have a store
package benetin.shawndarbygame;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MainApp extends Application {

    public static int credits = 0;
    public static boolean gameOver;
    public static boolean pWin = false;//p=public
    public static String pMessage;
    public static Scene pLastScene;
    public static boolean initialize = true; //if false it wont initialize in the games
    public static int multiplier = 1;
    public static String song = "elevator";
    public static MediaPlayer player;
   public static boolean playing=false;
   public static boolean homeFlash = false;//flashing background

   
   


    @Override
    public void start(Stage stage) throws Exception {
        MainApp.player = new MediaPlayer((new Media(getClass().getResource("/Elevator-music.mp3").toString())));
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/home.fxml"));

        Scene scene = new Scene(root);
        //scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle("Mini Programs");
        stage.setScene(scene);
        stage.show();
       
        
        stage.setOnCloseRequest(e -> System.exit(0));
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }

}
