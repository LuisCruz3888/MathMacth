package mathmatchgame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VentanaController implements Initializable {

    @FXML
    private Button loginButton;

    @FXML
    private TextField textField;

    @FXML
    private PasswordField passwordField;

    private List<User> userList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inicializar la lista de usuarios
        userList = new ArrayList<>();
        userList.add(new User("luis", "123"));
        userList.add(new User("alejandro", "456"));
    }

    @FXML
    private void handleLoginButtonClick(ActionEvent event) {

        String username = textField.getText();
        String password = passwordField.getText();


        if (verifyCredentials(username, password)) {

        Stage currentStage = (Stage) loginButton.getScene().getWindow();
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

        } else {
            // Las credenciales son incorrectas, mostrar una alerta
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de inicio de sesión");
            alert.setHeaderText(null);
            alert.setContentText("Credenciales incorrectas. Por favor, intente nuevamente.");
            alert.showAndWait();
            // Credenciales inválidas, mostrar un mensaje de error
            System.out.println("Credenciales inválidas. Inténtalo de nuevo.");
        }
    }
    private boolean verifyCredentials(String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true; // Las credenciales son válidas
            }
        }
        return false; // Las credenciales son inválidas
    }
}
