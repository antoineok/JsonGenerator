package fr.antoineok.mcpjsongen.generation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;


import java.io.*;

public class GenBlock
{
    public static void genBlock(String blockName, String textureName, String path, boolean version)
    {

        File fileDir = new File(path + File.separator + "blockstates" + File.separator);
        if(!fileDir.exists())
        {
            fileDir.mkdirs();
        }

        try
        {

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + File.separator + blockName + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();
            jw.name("variants");
            jw.beginObject();
            jw.name("normal");
            jw.beginObject();
            jw.name("model").value(blockName);
            jw.endObject();
            jw.endObject();
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

        genBlockModel(blockName, textureName, path);
        genBlockItemModel(blockName, path, version);

    }

    private static void genBlockModel(String blockName, String textureName, String path)
    {

        File fileDir = new File(path + File.separator + "models" + File.separator + "block" + File.separator);
        if(!fileDir.exists())
        {
            fileDir.mkdirs();
        }

        try
        {

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + File.separator + blockName + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();
            jw.name("parent").value("block/cube_all");
            jw.name("textures");
            jw.beginObject();
            jw.name("all").value("blocks/" + textureName);
            jw.endObject();
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

    private static void genBlockItemModel(String blockName, String path, boolean version)
    {

        File fileDir = new File(path + File.separatorChar + "models" + File.separatorChar + "item" + File.separatorChar);
        if(!fileDir.exists())
        {
            fileDir.mkdirs();
        }

        try
        {

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileDir + File.separator + blockName + ".json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonWriter jw = gson.newJsonWriter(writer);

            jw.beginObject();

            jw.name("parent").value("block/" + blockName);

            if(version)
            {
                jw.name("display").beginObject();

                jw.name("thirdperson").beginObject();

                jw.name("rotation").beginArray().value(10).value(-45).value(170).endArray();
                jw.name("translation").beginArray().value(0).value(1.5).value(-2.75).endArray();
                jw.name("scale").beginArray().value(0.375).value(0.375).value(0.375).endArray();

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
