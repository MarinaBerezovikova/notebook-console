package com.company.notebook;

import java.io.IOException;

public class Driver {

    static String path = "e:\\LocalRepositoryGit\\data_note_6task.json";

    public static void main(String[] args) throws IOException {

        JsonManager jsonManager = new JsonManager();
        Notebook.notes = jsonManager.fileReader();

        NotebookUtility.startApplication();

        ScannerManager.scan.close();
        jsonManager.fileWriter();
    }
}