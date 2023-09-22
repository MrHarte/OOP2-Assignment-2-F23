package com.champlain.oop2assignment2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DeckApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DeckApplication.class.getResource("deck-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Main method to display and test the Deck class.
     * It creates a deck of cards, shuffles it, and prints each card as confirmation.
     * Then, it launches the JavaFX application.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        for (Card card : deck) {
            System.out.println("Confirmation: " + card.toString());
        }
        launch();
    }
}