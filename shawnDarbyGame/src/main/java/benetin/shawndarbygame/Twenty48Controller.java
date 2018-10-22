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
    int randX = ThreadLocalRandom.current().nextInt(4);
    int randY = ThreadLocalRandom.current().nextInt(4);
    int numPick = ThreadLocalRandom.current().nextInt(2);
    int count;
    int dir;

    @FXML
    private void pressed(KeyEvent e) {
//1
        if (e.getCode() == KeyCode.UP) {
            dir = 1;
            move();
        }

//2
        if (e.getCode() == KeyCode.RIGHT) {

        }

//3
        if (e.getCode() == KeyCode.DOWN) {

        }

//4
        if (e.getCode() == KeyCode.LEFT) {

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
            //up

            //merge
            for (int i = 0; i <= 3; i++) {
                //for (int j = 0; j <= 3; j++) {
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

                    //}
                }

            }
            //move to top
            for (int n = 0; n <= 2; n++) {
                for (int i = 0; i <= 3; i++) {
                    //for (int j = 0; j <= 3; j++) {
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

                        // }
                    }

                }
            }
            //this doesnt work 
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

        if (count != 16) {
            if (numPick == 0) {
                l[randX][randY].setText("2");
            } else if (numPick == 1) {
                l[randX][randY].setText("4");
            }
        } else {
            //game over              add this later
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
        l[3][3] = lbl03;
        place();
    }

}
