/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package benetin.shawndarbygame;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author darbym26
 */
public class Twenty48Controller implements Initializable {

    @FXML
    private Label lbl00;
    @FXML
    private Label lbl01;
    @FXML
    private Label lbl02;
    @FXML
    private Label lbl03;
    @FXML
    private Label lbl10;
    @FXML
    private Label lbl11;
    @FXML
    private Label lbl12;
    @FXML
    private Label lbl13;
    @FXML
    private Label lbl20;
    @FXML
    private Label lbl21;
    @FXML
    private Label lbl22;
    @FXML
    private Label lbl23;
    @FXML
    private Label lbl30;
    @FXML
    private Label lbl31;
    @FXML
    private Label lbl32;
    @FXML
    private Label lbl33;
    Label l[][] = new Label[4][4];
    int in[][] = new int[4][4];
    int randX;
    int randY;
    int numPick;
    int count;
    int dir;
    boolean upGo = false;
    boolean downGo = false;
    boolean leftGo = false;
    boolean rightGo = false;

    String merge1;

    @FXML
    private void pressed(KeyEvent e) {
        System.out.println("pressed");
//1
        if (e.getCode() == KeyCode.UP) {
            dir = 1;
            move();
        }

//2
        if (e.getCode() == KeyCode.RIGHT) {
            dir = 2;
            move();
        }

//3
        if (e.getCode() == KeyCode.DOWN) {
            dir = 3;
            move();
        }

//4
        if (e.getCode() == KeyCode.LEFT) {
            dir = 4;
            move();
        }
    }

    private void move() {

        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                try {
                    in[i][j] = Integer.parseInt(l[i][j].getText());
                } catch (NumberFormatException numberFormatException) {
                    in[i][j] = 0;
                }

            }
        }
        if (dir == 1) {
            if (upGo) {
                moveUp();
                mergeUp();
                moveUp();

                setSpaces();
                //up
            }
        }
        if (dir == 2) {
            if (rightGo) {
                moveRight();
                mergeRight();
                moveRight();

                setSpaces();
                //right
            }
        }
        if (dir == 3) {
            if (downGo) {
                moveDown();
                mergeDown();
                moveDown();

                setSpaces();
                //down
            }
        }
        if (dir == 4) {
            if (leftGo) {
                moveLeft();
                mergeLeft();
                moveLeft();

                setSpaces();
                //up
            }
        }
    }

    private void mergeUp() {
        //merge
        for (int i = 0; i <= 3; i++) {

            int j = 0;
            if (in[i][j + 3] == in[i][j + 2]) {
                in[i][j + 3] *= 2;
                in[i][j + 2] = 0;

            }
            if (in[i][j + 2] == in[i][j + 1]) {
                in[i][j + 2] *= 2;
                in[i][j + 1] = 0;

            }
            if (in[i][j + 1] == in[i][j]) {
                in[i][j + 1] *= 2;
                in[i][j] = 0;

            }

        }
    }
    //move to top

    private void moveUp() {
        for (int n = 0; n <= 2; n++) {
            for (int i = 0; i <= 3; i++) {

                int j = 0;
                if (in[i][j + 3] == 0) {
                    in[i][j + 3] = in[i][j + 2];
                    in[i][j + 2] = 0;

                }
                if (in[i][j + 2] == 0) {
                    in[i][j + 2] = in[i][j + 1];
                    in[i][j + 1] = 0;

                }
                if (in[i][j + 1] == 0) {
                    in[i][j + 1] = in[i][j];
                    in[i][j] = 0;

                }

            }
        }
    }

    private void mergeDown() {
        //merge
        for (int i = 0; i <= 3; i++) {

            int j = 0;
            if (in[i][j] == in[i][j + 1]) {
                in[i][j] *= 2;
                in[i][j + 1] = 0;

            }
            if (in[i][j + 1] == in[i][j + 2]) {
                in[i][j + 1] *= 2;
                in[i][j + 2] = 0;

            }
            if (in[i][j + 2] == in[i][j + 3]) {
                in[i][j + 2] *= 2;
                in[i][j + 3] = 0;

            }

        }
    }
    //move to bottom

    private void moveDown() {
        for (int n = 0; n <= 2; n++) {
            for (int i = 0; i <= 3; i++) {

                int j = 0;
                if (in[i][j] == 0) {
                    in[i][j] = in[i][j + 1];
                    in[i][j + 1] = 0;

                }
                if (in[i][j + 1] == 0) {
                    in[i][j + 1] = in[i][j + 2];
                    in[i][j + 2] = 0;

                }
                if (in[i][j + 2] == 0) {
                    in[i][j + 2] = in[i][j + 3];
                    in[i][j + 3] = 0;

                }

            }
        }
    }

    private void mergeRight() {
        //merge
        for (int j = 0; j <= 3; j++) {

            int i = 0;
            if (in[i + 3][j] == in[i + 2][j]) {
                in[i + 3][j] *= 2;
                in[i + 2][j] = 0;

            }
            if (in[i + 2][j] == in[i + 1][j]) {
                in[i + 2][j] *= 2;
                in[i + 1][j] = 0;

            }
            if (in[i + 1][j] == in[i][j]) {
                in[i + 1][j] *= 2;
                in[i][j] = 0;

            }

        }
    }
    //move to right

    private void moveRight() {
        for (int n = 0; n <= 2; n++) {
            for (int j = 0; j <= 3; j++) {

                int i = 0;
                if (in[i + 3][j] == 0) {
                    in[i + 3][j] = in[i + 2][j];
                    in[i + 2][j] = 0;

                }
                if (in[i + 2][j] == 0) {
                    in[i + 2][j] = in[i + 1][j];
                    in[i + 1][j] = 0;

                }
                if (in[i + 1][j] == 0) {
                    in[i + 1][j] = in[i][j];
                    in[i][j] = 0;

                }

            }
        }
    }

     private void mergeLeft() {
        //merge
        for (int j = 0; j <= 3; j++) {

            int i = 0;
            if (in[i][j] == in[i+1][j]) {
                in[i][j] *= 2;
                in[i+1][j] = 0;

            }
            if (in[i+1][j ] == in[i+2][j ]) {
                in[i+1][j ] *= 2;
                in[i+2][j ] = 0;

            }
            if (in[i+2][j] == in[i+3][j]) {
                in[i+2][j] *= 2;
                in[i+3][j] = 0;

            }

        }
    }
    //move to bottom

    private void moveLeft() {
        for (int n = 0; n <= 2; n++) {
            for (int j = 0; j <= 3; j++) {

                int i = 0;
                if (in[i][j] == 0) {
                    in[i][j] = in[i+1][j];
                    in[i+1][j] = 0;

                }
                if (in[i+1][j ] == 0) {
                    in[i+1][j] = in[i+2][j];
                    in[i+2][j ] = 0;

                }
                if (in[i+2][j] == 0) {
                    in[i+2][j] = in[i+3][j];
                    in[i+3][j] = 0;

                }

            }
        }
    }

    
    
    
    
    private void setSpaces() {
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                l[i][j].setText("" + in[i][j]);
                if (l[i][j].getText().equals("0")) {
                    l[i][j].setText("");

                }
            }
        }
        place();
    }

    private void place() {
        count = 0;
        //check how many spaces are full
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                if (!l[i][j].getText().equals("")) {
                    count++;
                }
            }
        }
        randX = ThreadLocalRandom.current().nextInt(4);
        randY = ThreadLocalRandom.current().nextInt(4);
        numPick = ThreadLocalRandom.current().nextInt(2);
        if (count != 16) {
            if (l[randX][randY].getText().equals("")) {
                if (numPick == 0) {
                    l[randX][randY].setText("2");
                } else if (numPick == 1) {
                    l[randX][randY].setText("4");
                }
            } else {
                place();
            }
        } else {
            //game over              add this later
        }
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                try {
                    in[i][j] = Integer.parseInt(l[i][j].getText());
                } catch (NumberFormatException numberFormatException) {
                    in[i][j] = 0;
                }

            }
        }
        upGo = false;
        downGo = false;
        rightGo = false;
        leftGo = false;
       
        moveUpC();
        moveUpC();
        mergeRightC();
        moveRightC();
        mergeDownC();
        moveDownC();
        mergeLeftC();
        moveLeftC();
    }

    private void mergeUpC() {
        //merge
        for (int i = 0; i <= 3; i++) {

            int j = 0;
            if (in[i][j + 3] == in[i][j + 2] && in[i][j + 3] != 0) {
                //
                upGo = true;
            }
            if (in[i][j + 2] == in[i][j + 1] && in[i][j + 2] != 0) {
                //
                upGo = true;
            }
            if (in[i][j + 1] == in[i][j] && in[i][j + 1] != 0) {
                //
                upGo = true;

            }

        }
    }
    //move to top

    private void moveUpC() {
        for (int n = 0; n <= 2; n++) {
            for (int i = 0; i <= 3; i++) {

                int j = 0;
                if (in[i][j + 3] == 0 && in[i][j + 2] != 0) {
                    //
                    upGo = true;
                }
                if (in[i][j + 2] == 0 && in[i][j + 1] != 0) {
                    //
                    upGo = true;
                }
                if (in[i][j + 1] == 0 && in[i][j] != 0) {
                    //
                    upGo = true;

                }

            }
        }
    }
private void mergeRightC() {
        //merge
        for (int j = 0; j <= 3; j++) {

            int i = 0;
            if (in[i + 3][j] == in[i + 2][j]&& in[i+3][j] != 0) {
                rightGo=true;

            }
            if (in[i + 2][j] == in[i + 1][j]&& in[i+2][j] != 0) {
                rightGo=true;

            }
            if (in[i + 1][j] == in[i][j]&& in[i+1][j] != 0) {
                rightGo=true;

            }

        }
    }
    //move to right

    private void moveRightC() {
        for (int n = 0; n <= 2; n++) {
            for (int j = 0; j <= 3; j++) {

                int i = 0;
                if (in[i + 3][j] == 0&& in[i+2][j] != 0) {
                  rightGo=true;
                }
                if (in[i + 2][j] == 0&& in[i+1][j] != 0) {
                   rightGo=true;

                }
                if (in[i + 1][j] == 0&& in[i][j] != 0) {
                   rightGo=true;

                }

            }
        }
    }

    private void mergeDownC() {
        //merge
        for (int i = 0; i <= 3; i++) {

            int j = 0;
            if (in[i][j] == in[i][j + 1] && in[i][j] != 0) {
                //
                downGo = true;

            }
            if (in[i][j + 1] == in[i][j + 2] && in[i][j + 1] != 0) {
                //
                downGo = true;

            }
            if (in[i][j + 2] == in[i][j + 3] && in[i][j + 2] != 0) {
                //
                downGo = true;

            }

        }
    }
    //move to bottom

    private void moveDownC() {
        for (int n = 0; n <= 2; n++) {
            for (int i = 0; i <= 3; i++) {

                int j = 0;
                if (in[i][j] == 0 && in[i][j + 1] != 0) {
                    downGo = true;
                }
                if (in[i][j + 1] == 0 && in[i][j + 2] != 0) {
                    downGo = true;
                }
                if (in[i][j + 2] == 0 && in[i][j + 3] != 0) {
                    downGo = true;

                }

            }
        }
    }
    private void mergeLeftC() {
        //merge
        for (int j = 0; j <= 3; j++) {

            int i = 0;
            if (in[i][j] == in[i+1][j]&& in[i][j] != 0) {
                leftGo=true;

            }
            if (in[i+1][j ] == in[i+2][j ]&& in[i+1][j] != 0) {
               leftGo=true;

            }
            if (in[i+2][j] == in[i+3][j]&& in[i+2][j] != 0) {
               leftGo=true;

            }

        }
    }
    //move to bottom

    private void moveLeftC() {
        for (int n = 0; n <= 2; n++) {
            for (int j = 0; j <= 3; j++) {

                int i = 0;
                if (in[i][j] == 0&& in[i+1][j] != 0) {
                    leftGo=true;

                }
                if (in[i+1][j ] == 0&& in[i+2][j] != 0) {
                    leftGo=true;
                }
                if (in[i+2][j] == 0&& in[i+3][j] != 0) {
                     leftGo=true;

                }

            }
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        l[0][0] = lbl00;
        l[0][1] = lbl01;
        l[0][2] = lbl02;
        l[0][3] = lbl03;
        l[1][0] = lbl10;
        l[1][1] = lbl11;
        l[1][2] = lbl12;
        l[1][3] = lbl13;
        l[2][0] = lbl20;
        l[2][1] = lbl21;
        l[2][2] = lbl22;
        l[2][3] = lbl23;
        l[3][0] = lbl30;
        l[3][1] = lbl31;
        l[3][2] = lbl32;
        l[3][3] = lbl33;
        place();
    }

}
