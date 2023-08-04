package com.company.notebook;

import java.io.IOException;

public class Driver {

    static String fileName = "data_note.json";

    public static void main(String[] args) throws IOException {

        JsonFileReader jsonFileReader = new JsonFileReader();
        JsonFileWriter jsonFileWriter = new JsonFileWriter();

        Notebook.notes = jsonFileReader.readResource();

        NotebookUtility.startApplication();

        ScannerManager.scan.close();
        jsonFileWriter.fileWriter();
    }
}