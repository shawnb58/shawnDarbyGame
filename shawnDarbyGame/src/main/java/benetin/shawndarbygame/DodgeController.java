/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package benetin.shawndarbygame;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
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

    Image man = new Image(getClass().getResource("/stickman.png").toString());
    Rectangle r[][] = new Rectangle[5][5];
    int UD[] = new int[5];
    int LR[] = new int[5];
    ImagePattern m = new ImagePattern(man);
    Label topBottom[][] = new Label[5][2];
    Label sides[][] = new Label[5][2];
int score=0;
    int rNumUD; //4
    int rNumLR; //4

    int rAmount; //5
    int rSide;  //2 
    int rotation = 1;
    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), ae -> timer()));
    int ii;
    int jj;

    @FXML
    private void key(KeyEvent ke) {

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
                    lose();
                } else {
                    r[ii - 1][jj].setFill(m);
                    r[ii][jj].setFill(Color.TRANSPARENT);
                }
            } catch (Exception e) {
            }
        }
    }

    private void randomPick() {

        rNumUD = ThreadLocalRandom.current().nextInt(3);
        for (int i = 0; i <= rNumUD; i++) {
            pickUD(i);

        }

        rNumLR = ThreadLocalRandom.current().nextInt(3);
        for (int i = 0; i <= rNumLR; i++) {
            pickLR(i);

        }
        System.out.println("n of vert" + rNumUD);
        System.out.println("n of hor" + rNumLR);
    }

    private void pickUD(int i) {
        UD[i] = ThreadLocalRandom.current().nextInt(5);
        rePickUD(i);
    }

    private void rePickUD(int i) {

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
            return;
        }

    }

    private void pickLR(int i) {
        LR[i] = ThreadLocalRandom.current().nextInt(5);
        rePickLR(i);
    }

    private void rePickLR(int i) {

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

        for (int i = 0; i <= rNumUD; i++) {
            for (int j = 0; j <= 4; j++) {
                if (r[UD[i]][j].getFill().equals(m)) {
                    lose();
                    return;
                } else {
                    r[UD[i]][j].setFill(Color.RED);

                }
            }
        }
        for (int j = 0; j <= rNumLR; j++) {
            for (int i = 0; i <= 4; i++) {
                if (r[i][LR[j]].getFill().equals(m)) {
                    lose();
                    return;
                } else {
                    r[i][LR[j]].setFill(Color.RED);
                }
            }
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
            score+=100;
        }

    }

    private void lose() {
        System.out.println("lose");
        timeline.stop();
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

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

}
