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

    private ImageView lastClickedImage;
    private int pairsFound;
    private int totalPairs;

    @FXML
    private void ocultarImagen1(MouseEvent event) {
        ocultarImagen(imageView1);
    }

    @FXML
    private void ocultarImagen2(MouseEvent event) {
        ocultarImagen(imageView2);
    }

    @FXML
    private void ocultarImagen3(MouseEvent event) {
        ocultarImagen(imageView3);
    }

    @FXML
    private void ocultarImagen4(MouseEvent event) {
        ocultarImagen(imageView4);
    }

    @FXML
    private void ocultarImagen5(MouseEvent event) {
        ocultarImagen(imageView5);
    }

    @FXML
    private void ocultarImagen6(MouseEvent event) {
        ocultarImagen(imageView6);
    }

    @FXML
    private void ocultarImagen7(MouseEvent event) {
        ocultarImagen(imageView7);
    }

    @FXML
    private void ocultarImagen8(MouseEvent event) {
        ocultarImagen(imageView8);
    }

    private void ocultarImagen(ImageView imageView) {
        if (lastClickedImage == null) {
            // Primera imagen clicada
            lastClickedImage = imageView;
        } else {
            // Segunda imagen clicada
            if (sonPareja(lastClickedImage, imageView)) {
                // Las imágenes forman un par
                lastClickedImage.setVisible(true);
                imageView.setVisible(true);
                pairsFound++;

                if (pairsFound == totalPairs) {
                    // El juego ha sido completado
                    // Realizar alguna acción, como mostrar un mensaje de éxito
                    System.out.println("¡Has completado el juego!");
                }
            } else {
                // Las imágenes no forman un par
                lastClickedImage.setVisible(false);
                imageView.setVisible(false);
            }
            lastClickedImage = null;
        }
    }

    private boolean sonPareja(ImageView image1, ImageView image2) {
        String id1 = image1.getId();
        String id2 = image2.getId();

        // Comparar los identificadores de las imágenes
        return id1.equals(id2);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO: Implementar la inicialización del controlador
        totalPairs = 4;
    }

    @FXML
    private void volverNiveles(ActionEvent event) {
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
        }
    }

}
