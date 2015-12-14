/*
 page 537
 */

package eu.epfc.cours3449;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Testguishort extends Application {
    
    public static void main(String[] args) {
        Application.launch(args);
        
    }

    @Override
    public void start(Stage stage) {
        for (int i=0;i<5;i++) {
            Stage s = new Stage ();
            Scene t = new Scene (new Button("Button "+i+1), 150, 100);
            s.setScene(t);
            s.setTitle("Stage "+i+1);
            s.setX(i*165+100);
            s.setY(i*125+100);
            s.show();
        }
    }
    
    

    
}
