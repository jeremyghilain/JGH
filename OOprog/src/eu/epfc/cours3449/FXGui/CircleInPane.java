
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
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class CircleInPane extends Application {
    
        public static void main(String[] args) {
        Application.launch(args);
        
    }

    @Override
    public void start(Stage stage) {
        Circle c=new Circle();
        c.setRadius(80);
        c.setCenterX(150);
        c.setCenterY(150);
        c.setStroke(Color.BLUE);
        c.setStrokeWidth(7);
        c.setFill(Color.YELLOW);
        Pane p=new Pane();
        p.getChildren().add(c);
        Scene sc = new Scene(p,300,300);
        Stage st = new Stage ();
        st.setX(500);
        st.setY(400);
        st.setScene(sc);
        st.setTitle("Circle in pane");
        st.show();
        
        
    }
}
