package fr.antoineok.mcpjsongen.ref;

import fr.antoineok.mcpjsongen.Main;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Reference
{
    public static String author = "antoineok";
    public static String version = "1.0.0";
    public static String gameVersion = "1.9.4+";
    public static String iconURL = "http://miningmark48.xyz/img/projects/mcjsongen/icon.png";
    public static String styleSheetResource = Main.INSTANCE.getClass().getResource("/bootstrap2.css").toString();
    public static String signature = "généré avec le générateur de json d'antoineok";

    public static Alert aboutAlert = new Alert(Alert.AlertType.INFORMATION);
    public static Alert generatedAlert = new Alert(Alert.AlertType.INFORMATION);


    public static void init() {
        aboutAlert.setTitle("About");
        aboutAlert.setHeaderText("About Minecraft JSON Generator");
        aboutAlert.setContentText("Minecraft JSON Generator v" + Reference.version + " par " + author);
        Stage aboutStage = (Stage) aboutAlert.getDialogPane().getScene().getWindow();
        aboutStage.getIcons().add(new Image(Reference.iconURL));

        generatedAlert.setTitle("Generation");
        generatedAlert.setHeaderText("Generation Complete");
        generatedAlert.setContentText("le Json a été correctement généré.");
        Stage generatedStage = (Stage) generatedAlert.getDialogPane().getScene().getWindow();
        generatedStage.getIcons().add(new Image(Reference.iconURL));
    }

    public static Scene getDefaultScene(Parent root) {
        Scene scene = new Scene(root, 800, 400);
        scene.getStylesheets().add(styleSheetResource);
        return scene;
    }

    public static Scene getMainScene() {
        return getDefaultScene(FXMLFiles.FXML_MAIN);
    }

    public static Stage getDefaultStage() {
        Scene scene = getMainScene();
        Stage stage = new Stage();
        stage.setTitle("Générateur de Json v" + Reference.gameVersion);
        stage.setScene(scene);
        stage.getIcons().add(new Image(Reference.iconURL));

        Text textVersion = (Text) scene.lookup("#textInfo");
        if (textVersion != null) {
            textVersion.setText("v" + Reference.version);
        }

        return stage;
    }

    public static void setRoot(Parent root) {
        Main.getMainStage().getScene().setRoot(root);
    }
}
