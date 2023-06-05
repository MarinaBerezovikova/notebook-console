package com.company.notebook;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonManager {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    List<Note> notes = new ArrayList<>();

    public List<Note> fileReader() throws IOException {

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(Driver.path));
            notes = gson.fromJson(reader, new TypeToken<List<Note>>() {}.getType());

        } catch (FileNotFoundException e) {
            System.out.println("For input was passed a non-existed file. Program is closing.");
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("In process appeared some problem. A specific description is below.");
        } finally {
            assert reader != null;
            reader.close();
        }
        Notebook.notes = notes;
        return notes;
    }

    public void fileWriter() {

        try (FileWriter writer = new FileWriter(Driver.path)) {
            gson.toJson(notes, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}