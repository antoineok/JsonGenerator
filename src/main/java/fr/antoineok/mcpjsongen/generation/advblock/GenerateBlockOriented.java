package fr.antoineok.mcpjsongen.generation.advblock;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;

import fr.antoineok.mcpjsongen.ref.Reference;

import java.io.*;

public class GenerateBlockOriented
{
    public static void genBlock(String blockName, String topTextureName, String bottomTextureName, String frontTextureName, String sidesTextureName, String path){

        File fileDir = new File(path + File.separator + "blockstates" + File.separator);
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }

        try {

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + File.separator + blockName + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();
            jw.name("comment").value(Reference.signature);
            jw.name("variants");
            jw.beginObject();

            jw.name("facing=north");
            jw.beginObject();
            jw.name("model").value(blockName);
            jw.endObject();

            jw.name("facing=south");
            jw.beginObject();
            jw.name("model").value(blockName);
            jw.name("y").value(180);
            jw.endObject();

            jw.name("facing=west");
            jw.beginObject();
            jw.name("model").value(blockName);
            jw.name("y").value(270);
            jw.endObject();

            jw.name("facing=east");
            jw.beginObject();
            jw.name("model").value(blockName);
            jw.name("y").value(90);
            jw.endObject();

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

        genBlockModel(blockName, topTextureName, bottomTextureName, frontTextureName, sidesTextureName, path);
        genBlockItemModel(blockName, path);

    }

    private static void genBlockModel(String blockName, String topTextureName, String bottomTextureName, String frontTextureName, String sidesTextureName, String path){

        File fileDir = new File(path + File.separator + "models" + File.separator + "block" + File.separator);
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }

        try {

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + File.separator + blockName + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();
            jw.name("comment").value(Reference.signature);
            jw.name("parent").value("block/orientable");
            jw.name("textures");
            jw.beginObject();
            jw.name("top").value("blocks/" + topTextureName);
            jw.name("front").value("blocks/" + frontTextureName);
            jw.name("side").value("blocks/" + sidesTextureName);
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

    private static void genBlockItemModel(String blockName, String path){

        File fileDir = new File(path + File.separator + "models" + File.separator + "item" + File.separator);
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }

        try {

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + File.separator + blockName + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();

            jw.name("comment").value(Reference.signature);
            jw.name("parent").value("block/" + blockName);

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
