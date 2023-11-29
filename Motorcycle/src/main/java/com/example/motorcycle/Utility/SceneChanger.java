package com.example.motorcycle.Utility;

import com.example.motorcycle.Controllers.MotorcycleDetailsViewController;
import com.example.motorcycle.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {

    public static void changeScene(ActionEvent event, String fxmlFileName, String viewTitle, String selectedMake, String selectedModel) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFileName));
        Scene scene = new Scene(fxmlLoader.load());

        if(!selectedMake.equals("-1")){
            MotorcycleDetailsViewController controller =fxmlLoader.getController();
            controller.displayMotorcycleData(selectedMake,selectedModel);
        }

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle(viewTitle);
        stage.setScene(scene);
        stage.show();
    }
}
