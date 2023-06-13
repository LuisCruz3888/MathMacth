/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mathmatchgame;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MathMatchGame extends Application {
    private List<Button> buttons;
    private int score;
    private int totalMatches;
    private int selectedCardIndex;

    @Override
    public void start(Stage primaryStage) {
        buttons = new ArrayList<>();
        score = 0;
        totalMatches = 0;

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Create buttons and add them to the grid pane
        for (int i = 0; i < 6; i++) {
            Button button = new Button();
            button.setPrefSize(100, 50);
            buttons.add(button);
            gridPane.add(button, i % 2, i / 2);

            button.setOnAction(event -> handleCardClick(button));
        }

        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setTitle("Math Match Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleCardClick(Button button) {
        int cardIndex = buttons.indexOf(button);

        if (!button.isDisable()) {
            if (selectedCardIndex == -1) {
                // First flipped card
                selectedCardIndex = cardIndex;
                button.setDisable(true);
            } else {
                // Second flipped card
                Button selectedCard = buttons.get(selectedCardIndex);

                if (button.getText().equals(selectedCard.getText())) {
                    // Both cards are the same (a match is found)
                    button.setDisable(true);
                    selectedCard.setDisable(true);
                    totalMatches++;
                    score += 10;
                } else {
                    // Both cards are different (no match)
                    button.setDisable(false);
                    selectedCard.setDisable(false);
                    score -= 2;
                }

                selectedCardIndex = -1;
            }

            System.out.println("Current score: " + score);
            System.out.println();

            if (totalMatches == 3) {
                System.out.println("Congratulations! You have found all the pairs.");
                System.out.println("Your final score is: " + score);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
