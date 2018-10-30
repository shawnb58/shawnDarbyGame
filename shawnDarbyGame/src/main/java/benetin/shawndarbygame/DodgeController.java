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
import javafx.scene.shape.Rectangle;

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
Rectangle r[][]=new Rectangle[5][5];
int UD[]=new int[4];
int LR[]=new int[4];


int rNumUD; //4
int rNumLR; //4

  
int rAmount; //5
int rSide;  //2 

        


         private void randomPick(){
             
           rNumUD   = ThreadLocalRandom.current().nextInt(4);
           for (int i = 0; i <= rNumUD; i++) {
              
               UD[i]   = ThreadLocalRandom.current().nextInt(4);
            
            }
           
           
           
           
                      rNumLR   = ThreadLocalRandom.current().nextInt(4);

         }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

 r[0][0]= rec00;

 r[0][1]= rec01;

 r[0][2]= rec02;

 r[0][3]= rec03;

 r[0][4]= rec04;

 r[1][0]= rec10;

 r[1][1]= rec11;

 r[1][2]= rec12;

 r[1][3]= rec13;

 r[1][4]= rec14;

 r[2][0]= rec20;

 r[2][1]= rec21;

 r[2][2]= rec22;

 r[2][3]= rec23;

 r[2][4]= rec24;

 r[3][0]= rec30;

 r[3][1]= rec31;

 r[3][2]= rec32;

 r[3][3]= rec33;

 r[3][4]= rec34;

 r[4][0]= rec40;

 r[4][1]= rec41;

 r[4][2]= rec42;

 r[4][3]= rec43;

 r[4][4]= rec44;
    }    
    
}
