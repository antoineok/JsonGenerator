package fr.antoineok.mcpjsongen.controller;

import fr.antoineok.mcpjsongen.generation.GenBlock;
import fr.antoineok.mcpjsongen.ref.FXMLFiles;
import fr.antoineok.mcpjsongen.ref.Reference;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class BlockController
{
    @FXML private MenuBar menu_bar;
    @FXML private TextField fieldBlockName;
    @FXML private TextField fieldTextureName;
    @FXML private TextField fieldExportPath;
    @FXML private CheckBox checkBox18;

    @FXML private void handleCloseButtonAction(ActionEvent event){
        Platform.exit();
    }

    @FXML private void handleAboutButtonAction(ActionEvent event){
        Reference.aboutAlert.showAndWait();
    }

    @FXML private void handleMenuButtonAction(ActionEvent event) {
        Reference.setRoot(FXMLFiles.FXML_MAIN);
    }

    @FXML private void handlePathButtonAction(ActionEvent event) {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Choose resource directory");
        chooser.setInitialDirectory(new File(System.getProperty("user.home"), "Desktop"));
        File selectedDirectory = chooser.showDialog(new Stage());
        if (selectedDirectory != null) fieldExportPath.setText(selectedDirectory.getPath());
    }

    @FXML private void handleGenerateButtonAction(ActionEvent event) {
        GenBlock.genBlock(fieldBlockName.getText(), fieldTextureName.getText(), fieldExportPath.getText(), checkBox18.isSelected());

        fieldBlockName.clear();
        fieldTextureName.clear();
        Reference.generatedAlert.showAndWait();
    }
    
    @FXML private void handleAdvancedButtonAction(ActionEvent event) throws IOException {
        Reference.setRoot(FXMLFiles.FXML_ADVANCEDBLOCKS);
    }

}
