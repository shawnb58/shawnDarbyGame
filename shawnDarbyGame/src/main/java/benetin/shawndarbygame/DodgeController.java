/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package benetin.shawndarbygame;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author darbym26
 */
public class DodgeController implements Initializable {

    @FXML
    private Rectangle rec00;
    @FXML
    private Rectangle rec01;
    @FXML
    private Rectangle rec02;
    @FXML
    private Rectangle rec03;
    @FXML
    private Rectangle rec04;
    @FXML
    private Rectangle rec10;
    @FXML
    private Rectangle rec11;
    @FXML
    private Rectangle rec12;
    @FXML
    private Rectangle rec13;
    @FXML
    private Rectangle rec14;
    @FXML
    private Rectangle rec20;
    @FXML
    private Rectangle rec21;
    @FXML
    private Rectangle rec22;
    @FXML
    private Rectangle rec23;
    @FXML
    private Rectangle rec24;
    @FXML
    private Rectangle rec30;
    @FXML
    private Rectangle rec31;
    @FXML
    private Rectangle rec32;
    @FXML
    private Rectangle rec33;
    @FXML
    private Rectangle rec34;
    @FXML
    private Rectangle rec40;
    @FXML
    private Rectangle rec41;
    @FXML
    private Rectangle rec42;
    @FXML
    private Rectangle rec43;
    @FXML
    private Rectangle rec44;

    @FXML
    private Label lblT0;
    @FXML
    private Label lblT1;
    @FXML
    private Label lblT2;
    @FXML
    private Label lblT3;
    @FXML
    private Label lblT4;
    @FXML
    private Label lblR0;
    @FXML
    private Label lblR1;
    @FXML
    private Label lblR2;
    @FXML
    private Label lblR3;
    @FXML
    private Label lblR4;
    @FXML
    private Label lblB0;
    @FXML
    private Label lblB1;
    @FXML
    private Label lblB2;
    @FXML
    private Label lblB3;
    @FXML
    private Label lblB4;
    @FXML
    private Label lblL0;
    @FXML
    private Label lblL1;
    @FXML
    private Label lblL2;
    @FXML
    private Label lblL3;
    @FXML
    private Label lblL4;
    @FXML
    private Label lblScore;
    Image man = new Image(getClass().getResource("/stickman.png").toString()); //guy
    Image rMan = new Image(getClass().getResource("/stickmanRed.png").toString()); //guy after death

    Rectangle r[][] = new Rectangle[5][5];
    int UD[] = new int[5]; //array of the vertical random spaces
    int LR[] = new int[5]; //array of the horizontal random spaces
    ImagePattern m = new ImagePattern(man); //guy
    ImagePattern red = new ImagePattern(rMan); //guy after death

    Label topBottom[][] = new Label[5][2]; //array of labels on the top and bottom
    Label sides[][] = new Label[5][2]; //array of labels on left and right
    int score = 0; //score
    int rNumUD; //3     number of vericle lines
    int rNumLR; //3     number of horizontal lines

    int rSide;  //2 random decides if the warning will show on the botto or top and left or right
    int rotation = 1; //what stage the timer is in
    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), ae -> timer())); //runs the 
        Timeline pause = new Timeline(new KeyFrame(Duration.millis(1000), ae -> death()));

    int ii;
    int jj;
    boolean UDZero = true;
    boolean LRZero = true;
            boolean lost;

    Alert alert = new Alert(AlertType.INFORMATION);

    @FXML
    private void key(KeyEvent ke) {
        //keeps the key press from working after you lose
if (!lost){
    //makes global variables for place with the guy
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                if (r[i][j].getFill().equals(m)) {
                    ii = i;
                    jj = j;
                }
            }
        }
        if (ke.getCode() == KeyCode.UP) {
            try {
                if (r[ii][jj + 1].getFill().equals(Color.RED)) {
                    r[ii][jj + 1].setFill(red);
                    r[ii][jj].setFill(Color.TRANSPARENT);
                    lost=true;
                    lose();

                } else {
                    r[ii][jj + 1].setFill(m);
                    r[ii][jj].setFill(Color.TRANSPARENT);
                }
            } catch (Exception e) {
            }
        }
        if (ke.getCode() == KeyCode.RIGHT) {
            try {
                if (r[ii + 1][jj].getFill().equals(Color.RED)) {
                    r[ii][jj + 1].setFill(red);
                    r[ii][jj].setFill(Color.TRANSPARENT);
                    lost=true;
                    lose();
                } else {
                    r[ii + 1][jj].setFill(m);
                    r[ii][jj].setFill(Color.TRANSPARENT);
                }
            } catch (Exception e) {
            }
        }
        if (ke.getCode() == KeyCode.DOWN) {
            try {
                if (r[ii][jj - 1].getFill().equals(Color.RED)) {
                    r[ii][jj + 1].setFill(red);
                    r[ii][jj].setFill(Color.TRANSPARENT);
                    lose();
                } else {
                    r[ii][jj - 1].setFill(m);
                    r[ii][jj].setFill(Color.TRANSPARENT);
                }
            } catch (Exception e) {
            }
        }
        if (ke.getCode() == KeyCode.LEFT) {
            try {

                if (r[ii - 1][jj].getFill().equals(Color.RED)) {
                    r[ii][jj + 1].setFill(red);
                    r[ii][jj].setFill(Color.TRANSPARENT);
                    lost=true;
                    lose();
                } else {
                    r[ii - 1][jj].setFill(m);
                    r[ii][jj].setFill(Color.TRANSPARENT);
                }
            } catch (Exception e) {
            }
        }
    }
    }
    private void randomPick() {
        UDZero = false;
        rNumUD = ThreadLocalRandom.current().nextInt(3);
        for (int i = 0; i <= rNumUD; i++) {
            pickUD(i);

        }
        LRZero = false;
        rNumLR = ThreadLocalRandom.current().nextInt(3);
        for (int i = 0; i <= rNumLR; i++) {
            pickLR(i);

        }
        
    }

    private void pickUD(int i) {
        UD[i] = ThreadLocalRandom.current().nextInt(5);
        System.out.println(UD[i]);
        rePickUD(i);
    }

    private void rePickUD(int i) {

        if (UD[i] == 0) {
            if (!UDZero) {
                UDZero = true;
            } else {
                pickUD(i);
            }
        } else {
            if (i != 0 && UD[i] == UD[0]) {
                pickUD(i);
                return;
            }
            if (i != 1 && UD[i] == UD[1]) {
                pickUD(i);
                return;
            }
            if (i != 2 && UD[i] == UD[2]) {
                pickUD(i);
                return;
            }
            if (i != 3 && UD[i] == UD[3]) {
                pickUD(i);
                return;
            }
            if (i != 4 && UD[i] == UD[4]) {
                pickUD(i);
            }
        }
    }

    private void pickLR(int i) {
        LR[i] = ThreadLocalRandom.current().nextInt(5);
        rePickLR(i);
    }

    private void rePickLR(int i) {
        if (LR[i] == 0) {
            if (!LRZero) {
                LRZero = true;
            } else {
                pickLR(i);
            }
        } else {
            if (i != 0 && LR[i] == LR[0]) {
                pickLR(i);
                return;
            }
            if (i != 1 && LR[i] == LR[1]) {
                pickLR(i);
                return;
            }
            if (i != 2 && LR[i] == LR[2]) {
                pickLR(i);
                return;
            }
            if (i != 3 && LR[i] == LR[3]) {
                pickLR(i);
                return;

            }
            if (i != 4 && LR[i] == LR[4]) {
                pickLR(i);

            }
        }
    }

    private void warning() {
        for (int i = 0; i <= rNumUD; i++) {
            rSide = ThreadLocalRandom.current().nextInt(2);
            topBottom[UD[i]][rSide].setText("!");
        }
        for (int i = 0; i <= rNumLR; i++) {
            rSide = ThreadLocalRandom.current().nextInt(2);
            sides[LR[i]][rSide].setText("!");
        }

    }

    private void execute() {
         lost = false;
         //hardest code;;
        for (int i = 0; i <= rNumUD; i++) {
            for (int j = 0; j <= 4; j++) {
                if (r[UD[i]][j].getFill().equals(m)) {
                    r[UD[i]][j].setFill(red);

                    lost = true;
                } else {
                    r[UD[i]][j].setFill(Color.RED);

                }
            }
        }
// to here
        for (int j = 0; j <= rNumLR; j++) {
            for (int i = 0; i <= 4; i++) {
                if (r[i][LR[j]].getFill().equals(m)) {
                    r[i][LR[j]].setFill(red);
                    lost = true;
                } else {
                    r[i][LR[j]].setFill(Color.RED);
                }
            }
        }
        if (lost) {
            lose();
            return;
        }
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 1; j++) {
                topBottom[i][j].setText("");
                sides[i][j].setText("");
            }
        }
    }

    private void timer() {

        if (rotation == 1) {
            for (int i = 0; i <= 4; i++) {
                for (int j = 0; j <= 4; j++) {
                    if (r[i][j].getFill().equals(m)) {
                        ii = i;
                        jj = j;
                    }
                }
            }
            for (int i = 0; i <= 4; i++) {
                for (int j = 0; j <= 4; j++) {
                    r[i][j].setFill(Color.TRANSPARENT);
                }
            }
            r[ii][jj].setFill(m);

            randomPick();
            rotation = 2;
            return;
        }

        if (rotation == 2) {

            warning();
            rotation = 3;
            return;
        }

        if (rotation == 3) {

            execute();
            rotation = 1;
            if (!lost) {
            score += 100;
            lblScore.setText("score: " + score);
            }
        }

    }
   private void death(){
                 // parent48 = FXMLLoader.load(getClass().getResource("/fxml/dodge.fxml")); //where FXMLPage2 is the name of the scene
            MainApp.pLastScene ="/fxml/dodge.fxml";

        //} catch (IOException ex) {
            //ex.printStackTrace();
       // }
        MainApp.initialize = true;

        Parent parentLose;
        try {
            parentLose = FXMLLoader.load(getClass().getResource("/fxml/winLose.fxml")); //where FXMLPage2 is the name of the scene

            Scene sceneLose = new Scene(parentLose);
//get reference to the stage 
            Stage stage = (Stage) ((Node) lblT2).getScene().getWindow();

            stage.hide(); //optional
            stage.setScene(sceneLose); //puts the new scence in the stage

//stage.setTitle("Page 2"); //changes the title
            stage.show(); //shows the new page
            sceneLose.getRoot().requestFocus();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void lose() {
        timeline.stop();
        MainApp.credits+=score*MainApp.multiplier;
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException ex) {
//            ex.printStackTrace();
//        }
        System.out.println("yeet");
        MainApp.pWin = false;
        MainApp.pMessage = "You now have $" + MainApp.credits;
        //Parent parent48;
        MainApp.initialize = false;
        //try {
pause.play();
  
    }

    @FXML
    private void about(ActionEvent e) {
        showInstructions();
    }

    @FXML
    private void showInstructions() {
        alert.setTitle("Instructions");
        alert.setHeaderText(null);
        alert.setContentText("1. Move your guy around the board with arrow keys "
                + "\n 2. Watchout for warnings"
                + "\n 3. Dont get caught in the red"
                + "\n 4. You lose if you are in the red");
        alert.showAndWait();
    }

    @FXML
    private void goHome(ActionEvent e) {
        Parent parentHome;
        try {
            parentHome = FXMLLoader.load(getClass().getResource("/fxml/home.fxml")); //where FXMLPage2 is the name of the scene

            Scene sceneHome = new Scene(parentHome);
//get reference to the stage 
            Stage stage = (Stage) ((Node) lblB0).getScene().getWindow();

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
    private void replay(ActionEvent e) {
        reset();
    }

    private void reset() {
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                r[i][j].setFill(Color.TRANSPARENT);
            }
        }
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 1; j++) {
                topBottom[i][j].setText("");
                sides[i][j].setText("");
            }
        }
        r[2][2].setFill(m);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        score = 0;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        r[0][0] = rec00;

        r[0][1] = rec01;

        r[0][2] = rec02;

        r[0][3] = rec03;

        r[0][4] = rec04;

        r[1][0] = rec10;

        r[1][1] = rec11;

        r[1][2] = rec12;

        r[1][3] = rec13;

        r[1][4] = rec14;

        r[2][0] = rec20;

        r[2][1] = rec21;

        r[2][2] = rec22;

        r[2][3] = rec23;

        r[2][4] = rec24;

        r[3][0] = rec30;

        r[3][1] = rec31;

        r[3][2] = rec32;

        r[3][3] = rec33;

        r[3][4] = rec34;

        r[4][0] = rec40;

        r[4][1] = rec41;

        r[4][2] = rec42;

        r[4][3] = rec43;

        r[4][4] = rec44;

        topBottom[0][1] = lblT0;

        topBottom[1][1] = lblT1;

        topBottom[2][1] = lblT2;

        topBottom[3][1] = lblT3;

        topBottom[4][1] = lblT4;

        topBottom[0][0] = lblB0;

        topBottom[1][0] = lblB1;

        topBottom[2][0] = lblB2;

        topBottom[3][0] = lblB3;

        topBottom[4][0] = lblB4;

        sides[0][1] = lblR0;

        sides[1][1] = lblR1;

        sides[2][1] = lblR2;

        sides[3][1] = lblR3;

        sides[4][1] = lblR4;

        sides[0][0] = lblL0;

        sides[1][0] = lblL1;

        sides[2][0] = lblL2;

        sides[3][0] = lblL3;

        sides[4][0] = lblL4;
        r[2][2].setFill(m);
        if (MainApp.initialize) {
            showInstructions();
            reset();
            
            
        }
    }

}
