package com.example.motorcycle.Controllers;

import com.example.motorcycle.Models.Motorcycle;
import com.example.motorcycle.Utility.ApiUtility;
import com.example.motorcycle.Utility.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class SearchController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button submitButton;

    @FXML
    private ImageView imageView;

    @FXML
    private Label errorLabel;

    @FXML
    private Button getSpecificationsButton;

    @FXML
    private Label yearLabel;

    @FXML
    private Label makeLabel;

    @FXML
    private Label modelLabel;

    @FXML
    private ListView<Motorcycle> listView;

    @FXML
    private TextField searchMakeTextField;

    @FXML
    private TextField searchModelTextField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        imageView.setImage(new Image("https://www.motoo.com.br/fotos/2022/9/960_720/honda-motos-eletricas-2_13092022_50542_960_720.jpg"));

        // Lambada Function checking what object is selected from the list view
        listView.getSelectionModel().selectedItemProperty().addListener(
                ((observableValue, oldMotorcycle, newMotorcycle) -> {
                    yearLabel.setText(newMotorcycle.getYear());
                    modelLabel.setText(newMotorcycle.getModel());
                    makeLabel.setText(newMotorcycle.getMake());
                })
        );
    }


    @FXML
    void showMotorcycles(ActionEvent event) {
        listView.getItems().clear(); // Clear all the items from the list view
        errorLabel.setVisible(false); // Clear the error label
        String searchMakeString = searchMakeTextField.getText();
        String searchModelString = searchModelTextField.getText();

        // create user objects from API response
        Motorcycle[] motorcycles = ApiUtility.getDataFromAPIQuickList(searchMakeString, searchModelString);

        // add user objects to listView
        if (motorcycles.length == 0){
            errorLabel.setVisible(true);
            errorLabel.setText("No Information Found");
        }else{
            errorLabel.setVisible(false);
            listView.getItems().addAll((motorcycles));
        }

//        ArrayList <Motorcycle> motorcycleArrayList = (ArrayList<Motorcycle>) Arrays.asList(motorcycles);
//        yearLabel.setText(String.valueOf(motorcycles[0]));
        System.out.println(motorcycles[0]);
    }

    @FXML
    void getSpecificationsButton_onClick(ActionEvent event) throws IOException {

        if (listView.getSelectionModel().getSelectedItem() == null){
            errorLabel.setVisible(true);
            errorLabel.setText("Please search and select a motorcycle first");
        }else {
            String selectedMake = listView.getSelectionModel().getSelectedItem().getMake();
            String selectedModel = listView.getSelectionModel().getSelectedItem().getModel();

            SceneChanger.changeScene(event, "Motorcycle-details-view.fxml", "Motorcycle Statistics",selectedMake,selectedModel);

            System.out.println(selectedMake);
            System.out.println(selectedModel);
        }




    }




}

