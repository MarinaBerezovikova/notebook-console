package com.company.notebook;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonFileWriter {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String filePath = "src/main/resources/data_note.json";

    public void fileWriter() {

        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(Notebook.notes, writer);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
