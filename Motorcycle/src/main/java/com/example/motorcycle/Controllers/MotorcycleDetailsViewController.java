package com.example.motorcycle.Controllers;

import com.example.motorcycle.Models.Motorcycle;
import com.example.motorcycle.Models.MotorcycleDetails;
import com.example.motorcycle.Utility.ApiUtility;
import com.example.motorcycle.Utility.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MotorcycleDetailsViewController {

    @FXML
    private BorderPane anchorPaneStatistics;

    @FXML
    private Label displacementLabel;

    @FXML
    private Label engineLabel;

    @FXML
    private Label fuelCapacityLabel;

    @FXML
    private Label fuelSystemLabel;

    @FXML
    private Label gearboxLabel;

    @FXML
    private ImageView imageView;

    @FXML
    private Label powerLabel;

    @FXML
    private Label torqueLabel;

    @FXML
    private Label totalWeightLabel;


    @FXML
    void goBackButton_onClick(ActionEvent event) throws IOException {

//        SceneChanger.changeScene(event, "search-view.fxml", "Motorcycle Search", "-1", "-1");

    }

    public void displayMotorcycleData(String selectedMake, String selectedModel){
        System.out.println(selectedMake);
        System.out.println(selectedModel);

        // create user objects from API response
        MotorcycleDetails[] motorcycles = ApiUtility.getMotorcycleDetailsFromAPIQuickList(selectedMake, selectedModel);

//      Selecting the data from the API object and displaying it in the view

        try {
            displacementLabel.setText(motorcycles[0].getDisplacement());
            engineLabel.setText(motorcycles[0].getEngine());
            fuelCapacityLabel.setText(motorcycles[0].getFuel_capacity());
            fuelSystemLabel.setText(motorcycles[0].getFuel_system());
            gearboxLabel.setText(motorcycles[0].getGearbox());
            powerLabel.setText(motorcycles[0].getPower());
            torqueLabel.setText(motorcycles[0].getTorque());
            totalWeightLabel.setText(motorcycles[0].getTotal_weight());
        }catch (Exception e){
            displacementLabel.setText("No Information Found");
            engineLabel.setText("No Information Found");
            fuelCapacityLabel.setText("No Information Found");
            fuelSystemLabel.setText("No Information Found");
            gearboxLabel.setText("No Information Found");
            powerLabel.setText("No Information Found");
            torqueLabel.setText("No Information Found");
            totalWeightLabel.setText("No Information Found");
        }


        System.out.println(motorcycles);

        imageView.setImage(new Image("https://www.motoo.com.br/fotos/2022/9/960_720/honda-motos-eletricas-2_13092022_50542_960_720.jpg"));
    }
}
