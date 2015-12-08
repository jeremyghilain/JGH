/*
 page 537
 */

package eu.epfc.cours3449;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Testgui extends Application {
    // "extends" permet de référencer la classe de Application
    // message : Testgui is not abstract and does not overwride abstract method start in Application
    // il faut donc implémenter la méthode Start (help with alt+enter)
    
    public static void main(String[] args) {
        Application.launch(args);
        
    }

    /*
    Framework:
        Stage -> Scene (-> Pane) -> Parent=Button
    */
    @Override // annotation au niveau de la compilation
    public void start(Stage stage) {
        // we remove the "throws Exception" to avoid the prog to fail
        Button b = new Button("Click here");
        Scene s = new Scene(b);
        stage.setScene(s);
        stage.setTitle("Test for JavaFx GUI");
        stage.show();
    }
    
}
