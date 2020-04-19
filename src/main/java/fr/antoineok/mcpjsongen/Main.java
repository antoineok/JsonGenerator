package fr.antoineok.mcpjsongen;

import fr.antoineok.mcpjsongen.ref.FXMLFiles;
import fr.antoineok.mcpjsongen.ref.Reference;
import fr.antoineok.mcpjsongen.util.ClassL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class Main extends Application
{
    public static Main INSTANCE = new Main();
    
    public static FXMLLoader LOADER_INSTANCE = new FXMLLoader();

    public static Stage mainStage;
    
    public static ClassLoader cachingClassLoader = new ClassL(FXMLLoader.getDefaultClassLoader());

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        LOADER_INSTANCE.setClassLoader(cachingClassLoader);
        FXMLFiles.initFXML();
        Reference.init();

        primaryStage = Reference.getDefaultStage();
        primaryStage.show();

        mainStage = primaryStage;

    }
    public static Stage getMainStage() {
        return mainStage;
    }
    public static void main(String[] args)
    {
        launch(args);

    }

}
