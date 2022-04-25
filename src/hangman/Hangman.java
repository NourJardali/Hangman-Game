/*
 * Hangman game
 */
package hangman;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 *
 * @author JIHAD-SALEH
 */
public class Hangman extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("hangman.fxml"));
            primaryStage.setTitle("Hangman Game - Marvel Theme");
            primaryStage.setScene(new Scene(root, 800, 650));
            primaryStage.show();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
	}
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
