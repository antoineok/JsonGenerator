package fr.antoineok.mcpjsongen.generation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;

import fr.antoineok.mcpjsongen.ref.Reference;

import java.io.*;

public class GenItem
{
    public static void genItem(String itemName, String textureName, String path, boolean version)
    {

        File fileDir = new File(path + "\\models\\item\\");
        if(!fileDir.exists())
        {
            fileDir.mkdirs();
        }

        try
        {

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + itemName + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();
            if(version)
            {
                jw.name("parent").value("builtin/generated");
            }
            else
            {
                jw.name("parent").value("item/generated");
            }
            jw.name("textures");
            jw.beginObject();
            jw.name("layer0").value("items/" + textureName);
            jw.endObject();
            if(version) {
                jw.name("display").beginObject();
                jw.name("thirdperson").beginObject();
                jw.name("rotation").beginArray().value(-90).value(0).value(0).endArray();
                jw.name("translation").beginArray().value(0).value(1).value(-3).endArray();
                jw.name("scale").beginArray().value(0.55).value(0.55).value(0.55).endArray();
                jw.endObject();
                jw.name("firstperson").beginObject();
                jw.name("rotation").beginArray().value(0).value(-135).value(25).endArray();
                jw.name("translation").beginArray().value(0).value(4).value(2).endArray();
                jw.name("scale").beginArray().value(1.7).value(1.7).value(1.7).endArray();
                jw.endObject();
                jw.endObject();
            }
            jw.endObject();

            writer.close();

        }
        catch(UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void genTool(String itemName, String textureName, String path, boolean version)
    {

        File fileDir = new File(path + "\\models\\item\\");
        if(!fileDir.exists())
        {
            fileDir.mkdirs();
        }

        try
        {

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + "\\" + itemName + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();
            if(version)
            {
                jw.name("parent").value("builtin/generated");
            }
            else
            {
                jw.name("parent").value("item/handheld");
            }
            jw.name("textures");
            jw.beginObject();
            jw.name("layer0").value("items/" + textureName);
            jw.endObject();
            if(version) {
                jw.name("display").beginObject();
                jw.name("thirdperson").beginObject();
                jw.name("rotation").beginArray().value(0).value(90).value(-35).endArray();
                jw.name("translation").beginArray().value(0).value(1.25).value(-3.5).endArray();
                jw.name("scale").beginArray().value(0.85).value(0.85).value(0.85).endArray();
                jw.endObject();
                jw.name("firstperson").beginObject();
                jw.name("rotation").beginArray().value(0).value(-135).value(25).endArray();
                jw.name("translation").beginArray().value(0).value(4).value(2).endArray();
                jw.name("scale").beginArray().value(1.7).value(1.7).value(1.7).endArray();
                jw.endObject();
                jw.endObject();
            }
            jw.endObject();

            writer.close();

        }
        catch(UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
