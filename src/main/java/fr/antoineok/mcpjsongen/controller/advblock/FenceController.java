package fr.antoineok.mcpjsongen.controller.advblock;

import fr.antoineok.mcpjsongen.generation.advblock.GenerateBlockFence;
import fr.antoineok.mcpjsongen.ref.FXMLFiles;
import fr.antoineok.mcpjsongen.ref.Reference;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

public class FenceController
{
    @FXML private MenuBar menu_bar;
    @FXML private TextField fieldBlockName;
    @FXML private TextField fieldTextureName;
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
        GenerateBlockFence.genBlock(fieldBlockName.getText(), fieldTextureName.getText(), fieldExportPath.getText());

        fieldBlockName.clear();
        fieldTextureName.clear();
        Reference.generatedAlert.showAndWait();
    }

}
