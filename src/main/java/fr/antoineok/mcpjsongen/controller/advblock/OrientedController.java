package fr.antoineok.mcpjsongen.controller.advblock;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

import fr.antoineok.mcpjsongen.generation.advblock.GenerateBlockOriented;
import fr.antoineok.mcpjsongen.ref.FXMLFiles;
import fr.antoineok.mcpjsongen.ref.Reference;

public class OrientedController {

    @FXML private MenuBar menu_bar;
    @FXML private TextField fieldBlockName;
    @FXML private TextField fieldTopTexture;
    @FXML private TextField fieldBottomTexture;
    @FXML private TextField fieldFrontTexture;
    @FXML private TextField fieldSideTexture;
    @FXML private TextField fieldExportPath;

    @FXML private void handleCloseButtonAction(ActionEvent event){
        Platform.exit();
    }

    @FXML private void handleAboutButtonAction(ActionEvent event){
        Reference.aboutAlert.showAndWait();
    }

    @FXML private void handleMenuButtonAction(ActionEvent event) {
        Reference.setRoot(FXMLFiles.FXML_ADVANCEDBLOCKS);
    }

    @FXML private void handlePathButtonAction(ActionEvent event) {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Choose resource directory");
        chooser.setInitialDirectory(new File(System.getProperty("user.home"), "Desktop"));
        File selectedDirectory = chooser.showDialog(new Stage());
        if (selectedDirectory != null) fieldExportPath.setText(selectedDirectory.getPath());
    }

    @FXML private void handleGenerateButtonAction(ActionEvent event) {
        GenerateBlockOriented.genBlock(fieldBlockName.getText(), fieldTopTexture.getText(), fieldBottomTexture.getText(), fieldFrontTexture.getText(), fieldSideTexture.getText(), fieldExportPath.getText());

        fieldBlockName.clear();
        fieldTopTexture.clear();
        fieldBottomTexture.clear();
        fieldFrontTexture.clear();
        fieldSideTexture.clear();
        Reference.generatedAlert.showAndWait();
    }

}
