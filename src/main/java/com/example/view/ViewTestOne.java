package com.example.view;

import com.example.viev_model.api_requests.OpenExchangeRatesApi;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Map;
import java.util.Set;

public class ViewTestOne extends Application {
    private Map<String, Double> rates = new OpenExchangeRatesApi().sendRequest().getRates();

    @Override
    public void start(Stage stage) throws Exception {
        Text text = new Text();
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        Set<String> nameRateSet = rates.keySet();
        for (String nameRate : nameRateSet) {
            choiceBox.getItems().add(nameRate);
        }
        choiceBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String choiceBoxValue = choiceBox.getValue();
                text.setText(rates.get(choiceBoxValue).toString());
            }
        });

        HBox hBox1 = new HBox();
        hBox1.setSpacing(20);
        HBox hBox2 = new HBox();
        hBox2.setSpacing(20);
        hBox1.getChildren().add(text);
        hBox2.getChildren().add(choiceBox);
        VBox vBox= new VBox();
        vBox.getChildren().addAll(hBox1, hBox2);
        Scene scene = new Scene(vBox, 400, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
