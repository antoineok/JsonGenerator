package fr.antoineok.mcpjsongen.generation.advblock;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;

import fr.antoineok.mcpjsongen.ref.Reference;

public class GenerateBlockPressurePlate
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
            jw.name("variants");
            jw.beginObject();

            jw.name("powered=false");
            jw.beginObject();
            jw.name("model").value(blockName + "_up");
            jw.endObject();

            jw.name("powered=true");
            jw.beginObject();
            jw.name("model").value(blockName + "_down");
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

        genBlockModel(blockName, textureName, path);
        genBlockItemModel(blockName, path);

    }

    private static void genBlockModel(String blockName, String textureName, String path){

        File fileDir = new File(path + File.separator + "models" + File.separator + "block" + File.separator);
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }

        try {

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + File.separator + blockName + "_up" + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();
            jw.name("comment").value(Reference.signature);
            jw.name("parent").value("block/pressure_plate_up");
            jw.name("textures");
            jw.beginObject();
            jw.name("texture").value("blocks/" + textureName);
            jw.endObject();
            jw.endObject();

            writer.close();

            Writer writer2 = new OutputStreamWriter(new FileOutputStream(fileDir + File.separator + blockName + "_down" + ".json"), "UTF-8");
            JsonWriter jw2 = gson.newJsonWriter(writer2);

            jw2.beginObject();
            jw2.name("comment").value(Reference.signature);
            jw2.name("parent").value("block/pressure_plate_down");
            jw2.name("textures");
            jw2.beginObject();
            jw2.name("texture").value("blocks/" + textureName);
            jw2.endObject();
            jw2.endObject();

            writer2.close();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void genBlockItemModel(String blockName, String path){

        File fileDir = new File(path + File.separator + "models" + File.separator +"item" + File.separator);
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }

        try {

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + File.separator + blockName + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();

            jw.name("comment").value(Reference.signature);
            jw.name("parent").value("block/" + blockName + "_up");

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
