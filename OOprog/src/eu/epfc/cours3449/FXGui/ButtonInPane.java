
package eu.epfc.cours3449.FXGui;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ButtonInPane extends Application {
    
    public static void main(String[] args) {
        Application.launch(args);
        
    }

    @Override
    public void start(Stage stage) {
        //StackPane p=new StackPane();
        Pane p=new Pane();
        for (int i=0;i<5;i++) {
            Button b1 = new Button("Button "+(i+1));
            b1.setLayoutX(60*i);
            b1.setLayoutY(27*i);
            p.getChildren().add(b1);
        }
        
        Scene s1 = new Scene(p,350,200);
        stage.setScene(s1);
        stage.setTitle("DecreasingButtonInPane");
        stage.show();
        
        /*
        Pane p2=new Pane();
        for (int i=0;i<5;i++) {
            Button b2 = new Button("Button "+(i+1));
            b2.setLayoutX(350-60*i);
            b2.setLayoutY(200-27*i);
            p2.getChildren().add(b2);
        }
        
        Scene s2 = new Scene(p2,350,200);
        stage.setScene(s2);
        stage.setTitle("IncreasingButtonInPane");
        stage.show();*/
    }
    
}
