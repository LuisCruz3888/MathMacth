/*
 * Haz clic en nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para cambiar esta licencia
 * Haz clic en nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java para editar esta plantilla
 */
package mathmatchgame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MathMatchGame extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Ventana.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setTitle("Math Match Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }



}
