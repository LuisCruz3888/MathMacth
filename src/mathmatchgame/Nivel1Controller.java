package mathmatchgame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Nivel1Controller implements Initializable {

    @FXML
    private Button atras;
    @FXML
    private ImageView imageView1;
    @FXML
    private ImageView imageView2;
    @FXML
    private ImageView imageView3;
    @FXML
    private ImageView imageView4;
    @FXML
    private ImageView imageView5;
    @FXML
    private ImageView imageView6;
    @FXML
    private ImageView imageView7;
    @FXML
    private ImageView imageView8;

    @FXML
    private void ocultarImagen1(MouseEvent event) {
        imageView1.setVisible(false);
    }

    @FXML
    private void ocultarImagen2(MouseEvent event) {
        imageView2.setVisible(false);
    }
    @FXML
    private void ocultarImagen3(MouseEvent event) {
        imageView3.setVisible(false);
    }
    @FXML
    private void ocultarImagen4(MouseEvent event) {
        imageView4.setVisible(false);
    }
    @FXML
    private void ocultarImagen5(MouseEvent event) {
        imageView5.setVisible(false);
    }
    @FXML
    private void ocultarImagen6(MouseEvent event) {
        imageView6.setVisible(false);
    }
    @FXML
    private void ocultarImagen7(MouseEvent event) {
        imageView7.setVisible(false);
    }
    @FXML
    private void ocultarImagen8(MouseEvent event) {
        imageView8.setVisible(false);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO: Implementar la inicialización del controlador
    }

    @FXML
    private void volverNiveles(ActionEvent event){
        Stage currentStage = (Stage) atras.getScene().getWindow();
        currentStage.close();

        try {
            Stage newStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Niveles.fxml"));
            Scene scene = new Scene(root);
            newStage.setScene(scene);
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        };
    }


}