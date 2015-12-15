
package eu.epfc.cours3449.FXGui;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ButtonInPane extends Application {
    
    public static void main(String[] args) {
        Application.launch(args);
        
    }

    @Override
    public void start(Stage stage) {
        Button b1 = new Button("1st child");
        Button b2 = new Button("2nd child");
        Button b3 = new Button("3nd child");
        Button b4 = new Button("4nd child");
        Button b5 = new Button("5nd child");
        Button b6 = new Button("6nd child");
        //StackPane p=new StackPane();
        FlowPane p=new FlowPane();
        p.getChildren().add(b1);
        p.getChildren().add(b2);
        p.getChildren().add(b3);
        p.getChildren().add(b4);
        p.getChildren().add(b5);
        p.getChildren().add(b6);
        Scene s = new Scene(p,140,200);
        stage.setScene(s);
        stage.setTitle("ButtonInPane");
        stage.show();
    }
    
}
