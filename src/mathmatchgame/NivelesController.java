package mathmatchgame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NivelesController implements Initializable {

    @FXML
    private Button Button1;
    @FXML
    private Button Button2;
    @FXML
    private Button Button3;
    @FXML
    private Button Button4;
    @FXML
    private Button Button5;
    @FXML
    private Button Button6;
    @FXML
    private Button Button7;
    @FXML
    private Button Button8;
    @FXML
    private Button Button9;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO: Implementar la inicialización del controlador
    }

    @FXML
    private void IngresoNivel1(ActionEvent event){
        Stage currentStage = (Stage) Button1.getScene().getWindow();
        currentStage.close();

        try {
            Stage newStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Nivel1.fxml"));
            Scene scene = new Scene(root);
            newStage.setScene(scene);
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        };
    }
    @FXML
    private void salirLogin(ActionEvent event){
        Stage currentStage = (Stage) Button1.getScene().getWindow();
        currentStage.close();

        try {
            Stage newStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Ventana.fxml"));
            Scene scene = new Scene(root);
            newStage.setScene(scene);
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        };
    }
    @FXML
    private void onMouseEntered(MouseEvent event) {
        Button1.setStyle("-fx-background-color: #1f7c8a;");
    }

    @FXML
    private void onMouseExited(MouseEvent event) {
        Button1.setStyle("-fx-background-color: #39d0f1;");
    }

    @FXML
    private void onMousePressed(MouseEvent event) {
        DropShadow dropShadow = new DropShadow(4.0, 0, 0, javafx.scene.paint.Color.WHITE);
        Button1.setStyle("-fx-background-color: #0d3c44;");
        Button1.setEffect(dropShadow);
    }

    @FXML
    private void onMouseReleased(MouseEvent event) {
        Button1.setStyle("-fx-background-color: #1f7c8a;");
        Button1.setEffect(null);
    }
}