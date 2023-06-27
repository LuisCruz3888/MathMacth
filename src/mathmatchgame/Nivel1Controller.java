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
import java.util.HashMap;
import java.util.Map;

public class Nivel1Controller implements Initializable {

    // Declaración de los elementos del FXML
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
    private ImageView resultado1;
    @FXML
    private ImageView resultado2;
    @FXML
    private ImageView resultado3;
    @FXML
    private ImageView resultado4;
    @FXML
    private ImageView resultado5;
    @FXML
    private ImageView resultado6;
    @FXML
    private ImageView resultado7;
    @FXML
    private ImageView resultado8;

    // Variables de control
    private ImageView lastClickedImage;
    private int pairsFound;
    private int totalPairs;

    // Evento para ocultar la imagen 1 al hacer clic
    @FXML
    private void ocultarImagen1(MouseEvent event) {
        ocultarImagen(imageView1);
        imageView1.setVisible(false);
    }

    // Evento para ocultar la imagen 2 al hacer clic
    @FXML
    private void ocultarImagen2(MouseEvent event) {
        ocultarImagen(imageView2);
        imageView2.setVisible(false);
    }

    // Evento para ocultar la imagen 3 al hacer clic
    @FXML
    private void ocultarImagen3(MouseEvent event) {
        ocultarImagen(imageView3);
        imageView3.setVisible(false);
    }

    // Evento para ocultar la imagen 4 al hacer clic
    @FXML
    private void ocultarImagen4(MouseEvent event) {
        ocultarImagen(imageView4);
        imageView4.setVisible(false);
    }

    // Evento para ocultar la imagen 5 al hacer clic
    @FXML
    private void ocultarImagen5(MouseEvent event) {
        ocultarImagen(imageView5);
        imageView5.setVisible(false);
    }

    // Evento para ocultar la imagen 6 al hacer clic
    @FXML
    private void ocultarImagen6(MouseEvent event) {
        ocultarImagen(imageView6);
        imageView6.setVisible(false);
    }

    // Evento para ocultar la imagen 7 al hacer clic
    @FXML
    private void ocultarImagen7(MouseEvent event) {
        ocultarImagen(imageView7);
        imageView7.setVisible(false);
    }

    // Evento para ocultar la imagen 8 al hacer clic
    @FXML
    private void ocultarImagen8(MouseEvent event) {
        ocultarImagen(imageView8);
        imageView8.setVisible(false);
    }

    // Mapa que almacena las parejas de imágenes
    private Map<ImageView, ImageView> imagePairs;

    // Método para ocultar una imagen y verificar si forma una pareja
    private void ocultarImagen(ImageView imageView) {
        if (lastClickedImage == null) {
            // Primera imagen clicada
            lastClickedImage = imageView;

            // Mostrar todas las imágenes (excepto la primera) si están ocultas
            for (ImageView image : imagePairs.keySet()) {
                if (image != imageView && !image.isVisible()) {
                    image.setVisible(true);
                }
            }
        } else {
            // Segunda imagen clicada
            if (sonPareja(lastClickedImage, imageView)) {
                // Las imágenes forman un par
                if (lastClickedImage == imageView1 || imageView == imageView1){
                    resultado1.setVisible(true);
                    resultado4.setVisible(true);
                }

                if (lastClickedImage == imageView2 || imageView == imageView2){
                    resultado2.setVisible(true);
                    resultado7.setVisible(true);
                }

                if (lastClickedImage == imageView3 || imageView == imageView3){
                    resultado3.setVisible(true);
                    resultado5.setVisible(true);
                }

                if (lastClickedImage == imageView6 || imageView == imageView6){
                    resultado6.setVisible(true);
                    resultado8.setVisible(true);
                }

                lastClickedImage.setVisible(false);
                imageView.setVisible(false);
                lastClickedImage = null;
                pairsFound++;

                if (pairsFound == imagePairs.size()/2) {
                    // El juego ha sido completado
                    // Realizar alguna acción, como mostrar un mensaje de éxito
                    System.out.println("¡Has completado el juego!");
                }
            } else {
                // Las imágenes no forman un par
                lastClickedImage.setVisible(true);
                imageView.setVisible(true);
            }
            lastClickedImage = null;
        }
    }

    // Método para verificar si dos imágenes forman una pareja
    private boolean sonPareja(ImageView image1, ImageView image2) {
        return imagePairs.containsKey(image1) && imagePairs.get(image1) == image2;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inicialización del controlador

        // Cantidad total de parejas en el juego
        totalPairs = 4;

        // Ocultar los resultados
        resultado1.setVisible(false);
        resultado2.setVisible(false);
        resultado3.setVisible(false);
        resultado4.setVisible(false);
        resultado5.setVisible(false);
        resultado6.setVisible(false);
        resultado7.setVisible(false);
        resultado8.setVisible(false);

        // Inicializar las parejas de imágenes
        imagePairs = new HashMap<>();
        imagePairs.put(imageView1, imageView4);
        imagePairs.put(imageView2, imageView7);
        imagePairs.put(imageView3, imageView5);
        imagePairs.put(imageView6, imageView8);
        imagePairs.put(imageView4, imageView1);
        imagePairs.put(imageView7, imageView2);
        imagePairs.put(imageView5, imageView3);
        imagePairs.put(imageView8, imageView6);
    }

    // Evento para volver a la pantalla de selección de niveles
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
