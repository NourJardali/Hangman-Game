/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author JIHAD-SALEH
 */
public class GameController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    //images instances
    @FXML
    ImageView img;
    Image image1 = new Image(getClass().getResourceAsStream("assets/hangman1.png"));
    Image image2 = new Image(getClass().getResourceAsStream("assets/hangman2.png"));
    Image image3 = new Image(getClass().getResourceAsStream("assets/hangman3.png"));
    Image image4 = new Image(getClass().getResourceAsStream("assets/hangman4.png"));
    Image image5 = new Image(getClass().getResourceAsStream("assets/hangman5.png"));
    Image image6 = new Image(getClass().getResourceAsStream("assets/hangman6.png"));
    Image image7 = new Image(getClass().getResourceAsStream("assets/hangman7.png"));

    @FXML
    TextField nameText; //text field for the player's name
    @FXML
    TextField scoreText; //text field for the score
    @FXML
    TextField wordText; //text field for the chosen word for the game
    
    //keyboard buttons
    @FXML
    Button aBut;
    @FXML
    Button bBut;
    @FXML
    Button cBut;
    @FXML
    Button dBut;
    @FXML
    Button eBut;
    @FXML
    Button fBut;
    @FXML
    Button gBut;
    @FXML
    Button hBut;
    @FXML
    Button iBut;
    @FXML
    Button jBut;
    @FXML
    Button kBut;
    @FXML
    Button lBut;
    @FXML
    Button nBut;
    @FXML
    Button mBut;
    @FXML
    Button oBut;
    @FXML
    Button pBut;
    @FXML
    Button qBut;
    @FXML
    Button rBut;
    @FXML
    Button sBut;
    @FXML
    Button tBut;
    @FXML
    Button uBut;
    @FXML
    Button vBut;
    @FXML
    Button wBut;
    @FXML
    Button xBut;
    @FXML
    Button yBut;
    @FXML
    Button zBut;
    
    String name; //player's name
    int score; //player's score
    String temp; //temp string to hold chosen word with "*"
    boolean started = false;

    //list of words for the game to choose from randomly
    String[] data = {
            "ironman",
            "hulk",
            "deadpool",
            "spiderman",
            "captain america",
            "captain marvel",
            "thor",
            "black widow",
            "vision",
            "wanda",
            "doctor strange",
    };

    int random = new Random().nextInt(data.length); //random number to choose a word from above list
    String word = data[random]; //word at index "random"

    public void startGame(){
        started = true;
        //This function will start/restart the game
        System.out.println(word);
        //check if user has entered his/her name
        if(nameText.getText() != null && !nameText.getText().trim().isEmpty()){
            //if yes, store his name and initialize score
            name = nameText.getText();
            score = 0;
            life = 6;
            scoreText.setText(score + "");
            temp = "";
            for(int i = 0; i < word.length(); i++){
                //replace eacj char with *
                temp += "*";
            }
            wordText.setText(temp); //display word after replacing with *
            //enable each button (this is for when in case user is restarting)
            aBut.setDisable(false);
            bBut.setDisable(false);
            cBut.setDisable(false);
            dBut.setDisable(false);
            eBut.setDisable(false);
            fBut.setDisable(false);
            gBut.setDisable(false);
            hBut.setDisable(false);
            iBut.setDisable(false);
            jBut.setDisable(false);
            kBut.setDisable(false);
            lBut.setDisable(false);
            nBut.setDisable(false);
            mBut.setDisable(false);
            oBut.setDisable(false);
            pBut.setDisable(false);
            qBut.setDisable(false);
            rBut.setDisable(false);
            sBut.setDisable(false);
            tBut.setDisable(false);
            uBut.setDisable(false);
            vBut.setDisable(false);
            wBut.setDisable(false);
            xBut.setDisable(false);
            yBut.setDisable(false);
            zBut.setDisable(false);
            
            //display first image (which is an empty hanger)
            img.setImage(image1);
        }
        else{
            //if user didn't enter his/her name, prompt for name
            Alert fail= new Alert(AlertType.INFORMATION);
            fail.setHeaderText("REQUIRED");
            fail.setContentText("Enter your name first:");
            fail.showAndWait();
        }
    }
    
    public void keyboardAction(ActionEvent e){
        if(started == false){
            Alert fail= new Alert(AlertType.INFORMATION);
            fail.setHeaderText("REQUIRED");
            fail.setContentText("Enter your name first and start the game");
            fail.showAndWait();
        }
        else{
            //every time a letter is typed
            //disable button clicked
            Button clicked = (Button) e.getSource();
            clicked.setDisable(true);
            String letter = clicked.getText();
            char c1 = Character.toLowerCase(letter.charAt(0));
            char c2 = Character.toUpperCase(letter.charAt(0));
            //check if the word contains this letter or not
            //if yes, replace the symbol by the chosen letter and increase the score by 1
            //if not display a new image and decrease life by 1
            if(word.contains(Character.toString(c1)) || word.contains(Character.toString(c2))){
                int index = 0;
                for(int i = 0; i < word.length(); i++){
                    char c = word.charAt(i);
                    if(c == c1 || c == c2){
                        setLetter(index, c);
                    }
                    index++;
                }
                score++;
                scoreText.setText(score + "");
                if(!temp.contains("*")){
                    //if user guessed all letters, increase score by 5
                    //and display a message that notifies the user and then start another round
                    score += 5;
                    scoreText.setText(score + "");
                    Alert success = new Alert(AlertType.CONFIRMATION);
                    success.setHeaderText("HURRAY!!");
                    success.setContentText("You won! Proceed to the next word!");
                    success.showAndWait();
                    random = new Random().nextInt(data.length);
                    word = data [random];
                    temp = "";
                    for(int i = 0; i < word.length(); i++){
                        temp += "*";
                    }
                    wordText.setText(temp);
                    aBut.setDisable(false);
                    bBut.setDisable(false);
                    cBut.setDisable(false);
                    dBut.setDisable(false);
                    eBut.setDisable(false);
                    fBut.setDisable(false);
                    gBut.setDisable(false);
                    hBut.setDisable(false);
                    iBut.setDisable(false);
                    jBut.setDisable(false);
                    kBut.setDisable(false);
                    lBut.setDisable(false);
                    nBut.setDisable(false);
                    mBut.setDisable(false);
                    oBut.setDisable(false);
                    pBut.setDisable(false);
                    qBut.setDisable(false);
                    rBut.setDisable(false);
                    sBut.setDisable(false);
                    tBut.setDisable(false);
                    uBut.setDisable(false);
                    vBut.setDisable(false);
                    wBut.setDisable(false);
                    xBut.setDisable(false);
                    yBut.setDisable(false);
                    zBut.setDisable(false);
                }
            }
            else{
                setImage();
            }
        }
    }

    public void setLetter(int index,char c){
        //replace the symbol * with the chosen letter
        temp = temp.substring(0, index) + c + temp.substring(index+1);
        wordText.setText(temp);
    }

    int life=6;
    public void setImage(){
        //if a wrong letter was pressed
        //decrease life by 1 and display a new part of the body
        if(life==6)
            img.setImage(image2);
        else if(life==5)
            img.setImage(image3);
        else if(life==4)
            img.setImage(image4);
        else if(life==3)
            img.setImage(image5);
        else if(life==2)
            img.setImage(image6);    
        else{
            //if more than 6 body parts have been displayed
            //the game is over
            //and the user should start again
            img.setImage(image7);
            Alert fail= new Alert(AlertType.WARNING);
            fail.setHeaderText("GAME OVER");
            fail.setContentText("Try again!");
            fail.showAndWait();
            aBut.setDisable(true);
                bBut.setDisable(true);
                cBut.setDisable(true);
                dBut.setDisable(true);
                eBut.setDisable(true);
                fBut.setDisable(true);
                gBut.setDisable(true);
                hBut.setDisable(true);
                iBut.setDisable(true);
                jBut.setDisable(true);
                kBut.setDisable(true);
                lBut.setDisable(true);
                nBut.setDisable(true);
                mBut.setDisable(true);
                oBut.setDisable(true);
                pBut.setDisable(true);
                qBut.setDisable(true);
                rBut.setDisable(true);
                sBut.setDisable(true);
                tBut.setDisable(true);
                uBut.setDisable(true);
                vBut.setDisable(true);
                wBut.setDisable(true);
                xBut.setDisable(true);
                yBut.setDisable(true);
                zBut.setDisable(true);
        }
        life--;
    }
}
