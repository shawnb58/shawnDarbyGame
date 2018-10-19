//Wood Block Game
package benetin.shawndarbygame;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class FXMLController implements Initializable {//left to do= gridHover//gridClick//setPieces//reset method                         

    Rectangle r[][] = new Rectangle[10][10];//2d array of the rectangles on the grid
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
    private Rectangle rec05;
    @FXML
    private Rectangle rec06;
    @FXML
    private Rectangle rec07;
    @FXML
    private Rectangle rec08;
    @FXML
    private Rectangle rec09;
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
    private Rectangle rec15;
    @FXML
    private Rectangle rec16;
    @FXML
    private Rectangle rec17;
    @FXML
    private Rectangle rec18;
    @FXML
    private Rectangle rec19;
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
    private Rectangle rec25;
    @FXML
    private Rectangle rec26;
    @FXML
    private Rectangle rec27;
    @FXML
    private Rectangle rec28;
    @FXML
    private Rectangle rec29;
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
    private Rectangle rec35;
    @FXML
    private Rectangle rec36;
    @FXML
    private Rectangle rec37;
    @FXML
    private Rectangle rec38;
    @FXML
    private Rectangle rec39;
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
    private Rectangle rec45;
    @FXML
    private Rectangle rec46;
    @FXML
    private Rectangle rec47;
    @FXML
    private Rectangle rec48;
    @FXML
    private Rectangle rec49;
    @FXML
    private Rectangle rec50;
    @FXML
    private Rectangle rec51;
    @FXML
    private Rectangle rec52;
    @FXML
    private Rectangle rec53;
    @FXML
    private Rectangle rec54;
    @FXML
    private Rectangle rec55;
    @FXML
    private Rectangle rec56;
    @FXML
    private Rectangle rec57;
    @FXML
    private Rectangle rec58;
    @FXML
    private Rectangle rec59;
    @FXML
    private Rectangle rec60;
    @FXML
    private Rectangle rec61;
    @FXML
    private Rectangle rec62;
    @FXML
    private Rectangle rec63;
    @FXML
    private Rectangle rec64;
    @FXML
    private Rectangle rec65;
    @FXML
    private Rectangle rec66;
    @FXML
    private Rectangle rec67;
    @FXML
    private Rectangle rec68;
    @FXML
    private Rectangle rec69;
    @FXML
    private Rectangle rec70;
    @FXML
    private Rectangle rec71;
    @FXML
    private Rectangle rec72;
    @FXML
    private Rectangle rec73;
    @FXML
    private Rectangle rec74;
    @FXML
    private Rectangle rec75;
    @FXML
    private Rectangle rec76;
    @FXML
    private Rectangle rec77;
    @FXML
    private Rectangle rec78;
    @FXML
    private Rectangle rec79;
    @FXML
    private Rectangle rec80;
    @FXML
    private Rectangle rec81;
    @FXML
    private Rectangle rec82;
    @FXML
    private Rectangle rec83;
    @FXML
    private Rectangle rec84;
    @FXML
    private Rectangle rec85;
    @FXML
    private Rectangle rec86;
    @FXML
    private Rectangle rec87;
    @FXML
    private Rectangle rec88;
    @FXML
    private Rectangle rec89;
    @FXML
    private Rectangle rec90;
    @FXML
    private Rectangle rec91;
    @FXML
    private Rectangle rec92;
    @FXML
    private Rectangle rec93;
    @FXML
    private Rectangle rec94;
    @FXML
    private Rectangle rec95;
    @FXML
    private Rectangle rec96;
    @FXML
    private Rectangle rec97;
    @FXML
    private Rectangle rec98;
    @FXML
    private Rectangle rec99;
    @FXML
    private Label lblCredits;
    @FXML
    private ImageView imgS1;//first imageView of selections
    @FXML
    private ImageView imgS2;//second imageView of selections
    @FXML
    private ImageView imgS3;//third imageView of selections
    ImageView iS;// imageView currently selected
    int piecePick;//piece that is selected//set the imageViews with the pieces they are in the .getId
    //list what int corresponds to what image
    //1 = 2 by 2 square
    //2 = 1 by 3 vertical line
    //3 = 2 by 2 L
    Color hoverColour = Color.RED;//hovering colour for grid spaces
    Color placeColour = Color.MAROON;//setting colour for grid spaces
    boolean clearCol[] = new boolean[10]; //to keep track of which columns will be cleared and how many points awarded
    boolean clearRow[] = new boolean[10];//to keep track of which rows will be cleared and how many points awarded

    @FXML
    private void gridHover(MouseEvent e) {//when mouse hover over grid
        if (MainApp.gameOver) {
            return;
        }
        Rectangle sP = (Rectangle) e.getSource();//starting point
//
    }

    @FXML
    private void gridClick(ActionEvent e) {//method for spaces on grid
        if (MainApp.gameOver) {
            return;
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; i < 10; i++) {
                if (r[i][j].getFill().equals(hoverColour)) {
                    r[i][j].setFill(placeColour);
                }

            }
        }
        checkForLines();

    }

    private void checkForLines() {

    }

    @FXML
    private void pieceClick(MouseEvent e) { //method for which piece to place//mouseEvent is in case we use imageViews for pieces
        imgS1.setStyle("-fx-background-color: BROWN");//default colour
        imgS2.setStyle("-fx-background-color: BROWN");//default colour
        imgS3.setStyle("-fx-background-color: BROWN");//default colour
        iS = (ImageView) e.getSource();//imageview selected
        piecePick = Integer.parseInt(iS.getId()); //piece that the user picked//use id property on the imageview
        iS.setStyle("-fx-background-color: BLUE");//shows selection if images are transparent
        if ((imgS1.isDisabled()) && (imgS1.isDisabled()) && (imgS1.isDisabled())) {
            //new pieces method
            setPieces();
        }
    }

    @FXML
    private void setPieces() {//method that sets new pieces in the imageViews
        imgS1.setDisable(false);
        imgS2.setDisable(false);
        imgS3.setDisable(false);
        //set the 3 images to new random pieces and change their id

    }

    @FXML
    private void reset() {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MainApp.gameOver = false; //starts in a game
        lblCredits.setText("$" + MainApp.credits);
        r[0][0] = rec00;
        r[0][1] = rec01;
        r[0][2] = rec02;
        r[0][3] = rec03;
        r[0][4] = rec04;
        r[0][5] = rec05;
        r[0][6] = rec06;
        r[0][7] = rec07;
        r[0][8] = rec08;
        r[0][9] = rec09;
        r[1][0] = rec10;
        r[1][1] = rec11;
        r[1][2] = rec12;
        r[1][3] = rec13;
        r[1][4] = rec14;
        r[1][5] = rec15;
        r[1][6] = rec16;
        r[1][7] = rec17;
        r[1][8] = rec18;
        r[1][9] = rec19;
        r[2][0] = rec20;
        r[2][1] = rec21;
        r[2][2] = rec22;
        r[2][3] = rec23;
        r[2][4] = rec24;
        r[2][5] = rec25;
        r[2][6] = rec26;
        r[2][7] = rec27;
        r[2][8] = rec28;
        r[2][9] = rec29;
        r[3][0] = rec30;
        r[3][1] = rec31;
        r[3][2] = rec32;
        r[3][3] = rec33;
        r[3][4] = rec34;
        r[3][5] = rec35;
        r[3][6] = rec36;
        r[3][7] = rec37;
        r[3][8] = rec38;
        r[3][9] = rec39;
        r[4][0] = rec40;
        r[4][1] = rec41;
        r[4][2] = rec42;
        r[4][3] = rec43;
        r[4][4] = rec44;
        r[4][5] = rec45;
        r[4][6] = rec46;
        r[4][7] = rec47;
        r[4][8] = rec48;
        r[4][9] = rec49;
        r[5][0] = rec50;
        r[5][1] = rec51;
        r[5][2] = rec52;
        r[5][3] = rec53;
        r[5][4] = rec54;
        r[5][5] = rec55;
        r[5][6] = rec56;
        r[5][7] = rec57;
        r[5][8] = rec58;
        r[5][9] = rec59;
        r[6][0] = rec60;
        r[6][1] = rec61;
        r[6][2] = rec62;
        r[6][3] = rec63;
        r[6][4] = rec64;
        r[6][5] = rec65;
        r[6][6] = rec66;
        r[6][7] = rec67;
        r[6][8] = rec68;
        r[6][9] = rec69;
        r[7][0] = rec70;
        r[7][1] = rec71;
        r[7][2] = rec72;
        r[7][3] = rec73;
        r[7][4] = rec74;
        r[7][5] = rec75;
        r[7][6] = rec76;
        r[7][7] = rec77;
        r[7][8] = rec78;
        r[7][9] = rec79;
        r[8][0] = rec80;
        r[8][1] = rec81;
        r[8][2] = rec82;
        r[8][3] = rec83;
        r[8][4] = rec84;
        r[8][5] = rec85;
        r[8][6] = rec86;
        r[8][7] = rec87;
        r[8][8] = rec88;
        r[8][9] = rec89;
        r[9][0] = rec90;
        r[9][1] = rec91;
        r[9][2] = rec92;
        r[9][3] = rec93;
        r[9][4] = rec94;
        r[9][5] = rec95;
        r[9][6] = rec96;
        r[9][7] = rec97;
        r[9][8] = rec98;
        r[9][9] = rec99;
        setPieces();
    }
}
