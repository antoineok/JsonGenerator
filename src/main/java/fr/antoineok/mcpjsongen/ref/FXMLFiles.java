package fr.antoineok.mcpjsongen.ref;

import javafx.scene.Parent;

import java.io.IOException;

import fr.antoineok.mcpjsongen.Main;

import static fr.antoineok.mcpjsongen.Main.LOADER_INSTANCE;

public class FXMLFiles
{
    public static Parent FXML_MAIN;
    public static Parent FXML_BLOCKS;
    public static Parent FXML_ITEMS;

    @SuppressWarnings("static-access")
    public static void initFXML() {
        try {
            FXML_MAIN = LOADER_INSTANCE.load(Main.INSTANCE.getClass().getResource("/fxml/main.fxml"));
            FXML_BLOCKS = LOADER_INSTANCE.load(Main.INSTANCE.getClass().getResource("/fxml/blocks.fxml"));
            FXML_ITEMS = LOADER_INSTANCE.load(Main.INSTANCE.getClass().getResource("/fxml/items.fxml"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
