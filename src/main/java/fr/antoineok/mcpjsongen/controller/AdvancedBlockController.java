package fr.antoineok.mcpjsongen.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Ref;

import fr.antoineok.mcpjsongen.Main;
import fr.antoineok.mcpjsongen.ref.FXMLFiles;
import fr.antoineok.mcpjsongen.ref.Reference;

public class AdvancedBlockController
{

    @FXML private MenuBar menu_bar;

    @FXML private void handleCloseButtonAction(ActionEvent event){
        Platform.exit();
    }

    @FXML private void handleAboutButtonAction(ActionEvent event){
        Reference.aboutAlert.showAndWait();
    }

    @FXML private void handleMenuButtonAction(ActionEvent event) {
        Reference.setRoot(FXMLFiles.FXML_MAIN);
    }

    @FXML private void handleOrientedButtonAction(ActionEvent event) throws IOException {
        Main.getMainStage().getScene().setRoot(FXMLFiles.FXML_ADVANCEDBLOCKS_ORIENTED);
    }

    @FXML private void handleFenceButtonAction(ActionEvent event) throws IOException {
        Main.getMainStage().getScene().setRoot(FXMLFiles.FXML_ADVANCEDBLOCKS_FENCE);
    }

    @FXML private void handlePressurePlateButtonAction(ActionEvent event) throws IOException {
        Main.getMainStage().getScene().setRoot(FXMLFiles.FXML_ADVANCEDBLOCKS_PRESSUREPLATE);
    }

    @FXML private void handleSlabButtonAction(ActionEvent event) throws IOException {
        Main.getMainStage().getScene().setRoot(FXMLFiles.FXML_ADVANCEDBLOCKS_SLAB);
    }

}
