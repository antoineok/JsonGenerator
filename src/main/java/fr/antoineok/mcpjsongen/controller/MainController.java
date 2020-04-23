package fr.antoineok.mcpjsongen.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;

import java.io.IOException;

import fr.antoineok.mcpjsongen.ref.FXMLFiles;
import fr.antoineok.mcpjsongen.ref.Reference;

public class MainController
{
    @FXML private MenuBar menu_bar;

    @FXML private void handleCloseButtonAction(ActionEvent event){
        Platform.exit();
    }

    @FXML private void handleAboutButtonAction(ActionEvent event){
        Reference.aboutAlert.showAndWait();
    }

    @FXML private void handleBlockButtonAction(ActionEvent event) throws IOException {
        Reference.setRoot(FXMLFiles.FXML_BLOCKS);
    }

    @FXML private void handleItemButtonAction(ActionEvent event) throws IOException {
        Reference.setRoot(FXMLFiles.FXML_ITEMS);
    }
    
    @FXML private void handleRecipeButtonAction(ActionEvent event) throws IOException {
        Reference.setRoot(FXMLFiles.FXML_RECIPES);
    }
}
