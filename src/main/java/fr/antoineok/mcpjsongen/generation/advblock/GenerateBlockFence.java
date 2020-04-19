package fr.antoineok.mcpjsongen.generation.advblock;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;

import fr.antoineok.mcpjsongen.ref.Reference;

import java.io.*;

public class GenerateBlockFence
{
    public static void genBlock(String blockName, String textureName, String path){

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
            jw.name("multipart");
            jw.beginArray();
            jw.beginObject();
            jw.name("apply");
            jw.beginObject();
            jw.name("model").value(blockName + "_post");
            jw.endObject();
            jw.endObject();
            jw.beginObject();
            jw.name("when");
            jw.beginObject();
            jw.name("north").value("true");
            jw.endObject();
            jw.name("apply");
            jw.beginObject();
            jw.name("model").value(blockName + "_side");
            jw.name("uvlock").value(true);
            jw.endObject();
            jw.endObject();
            jw.beginObject();
            jw.name("when");
            jw.beginObject();
            jw.name("east").value("true");
            jw.endObject();
            jw.name("apply");
            jw.beginObject();
            jw.name("model").value(blockName + "_side");
            jw.name("y").value(90);
            jw.name("uvlock").value(true);
            jw.endObject();
            jw.endObject();
            jw.beginObject();
            jw.name("when");
            jw.beginObject();
            jw.name("south").value("true");
            jw.endObject();
            jw.name("apply");
            jw.beginObject();
            jw.name("model").value(blockName + "_side");
            jw.name("y").value(180);
            jw.name("uvlock").value(true);
            jw.endObject();
            jw.endObject();
            jw.beginObject();
            jw.name("when");
            jw.beginObject();
            jw.name("west").value("true");
            jw.endObject();
            jw.name("apply");
            jw.beginObject();
            jw.name("model").value(blockName + "_side");
            jw.name("y").value(270);
            jw.name("uvlock").value(true);
            jw.endObject();
            jw.endObject();
            jw.endArray();
            jw.endObject();

            writer.close();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        genBlockModel(blockName, textureName, path);
        genBlockItemModel(blockName, path);

    }

    private static void genBlockModel(String blockName, String textureName, String path){

        File fileDir = new File(path + File.separator + "models" + File.separator + "block" + File.separator);
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }

        try {

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + File.separator + blockName + "_post" + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();
            jw.name("comment").value(Reference.signature);
            jw.name("parent").value("block/fence_post");
            jw.name("textures");
            jw.beginObject();
            jw.name("texture").value("blocks/" + textureName);
            jw.endObject();
            jw.endObject();

            writer.close();

            Writer writer2 = new OutputStreamWriter(new FileOutputStream(fileDir + File.separator + blockName + "_side" + ".json"), "UTF-8");
            JsonWriter jw2 = gson.newJsonWriter(writer2);

            jw2.beginObject();
            jw2.name("comment").value(Reference.signature);
            jw2.name("parent").value("block/fence_side");
            jw2.name("textures");
            jw2.beginObject();
            jw2.name("texture").value("blocks/" + textureName);
            jw2.endObject();
            jw2.endObject();

            writer2.close();

            Writer writer3 = new OutputStreamWriter(new FileOutputStream(fileDir + File.separator + blockName + "_inventory" + ".json"), "UTF-8");
            JsonWriter jw3 = gson.newJsonWriter(writer3);

            jw3.beginObject();
            jw3.name("comment").value(Reference.signature);
            jw3.name("parent").value("block/fence_inventory");
            jw3.name("textures");
            jw3.beginObject();
            jw3.name("texture").value("blocks/" + textureName);
            jw3.endObject();
            jw3.endObject();

            writer3.close();

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
            jw.name("parent").value("block/" + blockName + "_inventory");

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
