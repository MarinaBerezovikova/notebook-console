package com.company.notebook.application;

import com.company.notebook.infrstructure.JsonFileManager;
import com.company.notebook.utils.NotebookUtility;
import com.company.notebook.domain.Notebook;

public class Driver {

    private final static String FILE_NAME = "data_note.json";
    private final static String FILE_PATH = "src/main/resources/data_note.json";

    public static void main(String[] args) {

        JsonFileManager jsonFileManager = new JsonFileManager();
        Notebook notebook = new Notebook();

        notebook.setNotes(jsonFileManager.readNotesFromResource(FILE_NAME));

        NotebookUtility.startApplication(notebook);

        jsonFileManager.writeNotesToFile(notebook, FILE_PATH);
    }
}