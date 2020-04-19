package fr.antoineok.mcpjsongen.generation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;

import fr.antoineok.mcpjsongen.ref.Reference;

import java.io.*;

public class GenItem
{
    public static void genItem(String itemName, String textureName, String path){

        File fileDir = new File(path + "\\models\\item\\");
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }

        try {

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + itemName + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();
            jw.name("comment").value(Reference.signature);
            jw.name("parent").value("item/generated");
            jw.name("textures");
            jw.beginObject();
            jw.name("layer0").value("items/" + textureName);
            jw.endObject();
            jw.endObject();

            writer.close();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void genTool(String itemName, String textureName, String path){

        File fileDir = new File(path + "\\models\\item\\");
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }

        try {

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + itemName + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();
            jw.name("comment").value("généré avec le générateur de json d'antoineok");
            jw.name("parent").value("item/handheld");
            jw.name("textures");
            jw.beginObject();
            jw.name("layer0").value("items/" + textureName);
            jw.endObject();
            jw.endObject();

            writer.close();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
