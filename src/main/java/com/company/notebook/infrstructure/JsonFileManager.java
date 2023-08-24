package com.company.notebook.infrstructure;

import com.company.notebook.domain.Note;
import com.company.notebook.domain.Notebook;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class JsonFileManager {

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final Type listType = new TypeToken<List<Note>>() {}.getType();

    public List<Note> readNotesFromResource(String fileName) {

        List<Note> listNotesFromReadResourceMethod;
        InputStream inputStream = getResourceAsStream(fileName);

        listNotesFromReadResourceMethod = parseNotesFromInputStream(inputStream);

        return listNotesFromReadResourceMethod;
    }

    private InputStream getResourceAsStream(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        }
        return inputStream;
    }

    private List<Note> parseNotesFromInputStream(InputStream inputStream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            return gson.fromJson(reader, listType);
        } catch (JsonIOException e) {
            throw new ParseNoteListException("Error parsing JSON data: " + e.getMessage(), e);
        } catch (JsonSyntaxException e) {
            throw new ParseNoteListException("JSON file has a syntax error: " + e.getMessage(), e);
        } catch (IOException e) {
            throw new ParseNoteListException("Error with input processing: " + e.getMessage(), e);
        }
    }

    //record data to json file
    public void writeNotesToFile(Notebook notebook, String path) {
        try (FileWriter writer = new FileWriter(path)) {
            gson.toJson(notebook.getNotes(), writer);
        } catch (JsonIOException e) {
            throw new FileWriterException("Error with JSON processing when using GSON library:" + e.getMessage(), e);
        } catch (IOException e) {
            throw new FileWriterException("Error with output processing:" + e.getMessage(), e);
        }
    }
}