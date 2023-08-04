package com.company.notebook;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class JsonFileReader {

    String fileName = Driver.fileName;
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    List<Note> listNotesFromGson = new ArrayList<>();

    public List<Note> readResource() throws IOException {

        JsonFileReader jsonFileReader = new JsonFileReader();
        InputStream inputStream = jsonFileReader.getFileFromResourceAsStream(fileName);

        listNotesFromGson = jsonFileReader.setContentToList(inputStream);

        inputStream.close();

        return listNotesFromGson;
    }

    private InputStream getFileFromResourceAsStream(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }
    }

    private List<Note> setContentToList(InputStream is) {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

            Type listType = new TypeToken<ArrayList<Note>>() {}.getType();
            listNotesFromGson = gson.fromJson(reader, listType);
            reader.close();
        } catch (Exception e) {
            System.out.println("In process appeared some problem. A specific description is below.");
            e.printStackTrace();
        }

        return listNotesFromGson;
    }
}