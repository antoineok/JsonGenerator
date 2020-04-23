package fr.antoineok.mcpjsongen.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

import fr.antoineok.mcpjsongen.Main;
import fr.antoineok.mcpjsongen.generation.GenItem;
import fr.antoineok.mcpjsongen.ref.FXMLFiles;
import fr.antoineok.mcpjsongen.ref.Reference;

public class ItemController
{
    @FXML private MenuBar menu_bar;
    @FXML private TextField fieldBlockName;
    @FXML private TextField fieldTextureName;
    @FXML private TextField fieldExportPath;
    @FXML private CheckBox checkBoxTool;
    @FXML private CheckBox checkBox18;
    
    @FXML private void handleCloseButtonAction(ActionEvent event){
        Platform.exit();
    }

    @FXML private void handleAboutButtonAction(ActionEvent event){
        Reference.aboutAlert.showAndWait();
    }

    @FXML private void handleMenuButtonAction(ActionEvent event) {
        Main.getMainStage().getScene().setRoot(FXMLFiles.FXML_MAIN);
    }

    @FXML private void handlePathButtonAction(ActionEvent event) {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Choisissez le dossier de destination");
        chooser.setInitialDirectory(new File(System.getProperty("user.home"), "Desktop"));
        File selectedDirectory = chooser.showDialog(new Stage());
        if (selectedDirectory != null) fieldExportPath.setText(selectedDirectory.getPath());
    }

    @FXML private void handleGenerateButtonAction(ActionEvent event) {
        if (checkBoxTool.isSelected()) {
            GenItem.genTool(fieldBlockName.getText(), fieldTextureName.getText(), fieldExportPath.getText(), checkBox18.isSelected());
            checkBoxTool.setSelected(false);
        } else {
            GenItem.genItem(fieldBlockName.getText(), fieldTextureName.getText(), fieldExportPath.getText(), checkBox18.isSelected());
        }

        fieldBlockName.clear();
        fieldTextureName.clear();
        Reference.generatedAlert.showAndWait();
    }


}
