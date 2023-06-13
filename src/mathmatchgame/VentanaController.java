package mathmatchgame;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class VentanaController implements Initializable {
    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    private List<Button> buttons;
    private int score;
    private int totalMatches;
    private int selectedCardIndex;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inicializar la lista de botones
        buttons = new ArrayList<>();

        // Inicializar el puntaje y el contador de pares encontrados
        score = 0;
        totalMatches = 0;

        // Establecer el índice de la carta seleccionada a -1 (ninguna carta seleccionada)
        selectedCardIndex = -1;

        // Agregar los botones a la lista de botones
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);
        buttons.add(button5);
        buttons.add(button6);

        // Inicializar el juego
        initializeGame();
    }

    private void initializeGame() {
        // Lista de operaciones
        List<String> operations = new ArrayList<>();
        operations.add("2 + 3");
        operations.add("4 * 5");
        operations.add("8 / 2");
        operations.add("6 - 1");
        operations.add("7 * 3");
        operations.add("10 / 2");

        // Duplicar las operaciones para formar pares
        List<String> allOperations = new ArrayList<>(operations);
        allOperations.addAll(operations);

        // Mezclar las operaciones
        Collections.shuffle(allOperations);

        // Asignar cada operación a un botón
        for (int i = 0; i < buttons.size(); i++) {
            Button button = buttons.get(i);
            button.setText(allOperations.get(i));
            button.setOnAction(event -> handleCardClick(button));
        }
    }

    private void handleCardClick(Button button) {
        // Obtener el índice de la carta seleccionada
        int cardIndex = buttons.indexOf(button);

        // Verificar si el botón está habilitado
        if (!button.isDisable()) {
            if (selectedCardIndex == -1) {
                // Primera carta volteada
                selectedCardIndex = cardIndex;
                button.setDisable(true);
            } else {
                // Segunda carta volteada
                Button selectedCard = buttons.get(selectedCardIndex);

                if (button.getText().equals(selectedCard.getText())) {
                    // Ambas cartas son iguales (se encontró una pareja)
                    button.setDisable(true);
                    selectedCard.setDisable(true);
                    totalMatches++;
                    score += 10;
                } else {
                    // Ambas cartas son diferentes (no hay pareja)
                    button.setDisable(false);
                    selectedCard.setDisable(false);
                    score -= 2;
                }

                // Restablecer el índice de la carta seleccionada
                selectedCardIndex = -1;
            }

            System.out.println("Puntuación actual: " + score);
            System.out.println();

            if (totalMatches == 3) {
                System.out.println("¡Felicitaciones! Has encontrado todos los pares.");
                System.out.println("Tu puntuación final es: " + score);
            }
        }
    }
}
