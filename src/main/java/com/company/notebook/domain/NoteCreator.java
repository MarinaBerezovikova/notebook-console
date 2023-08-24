package com.company.notebook.domain;

import com.company.notebook.utils.ScannerManager;

import java.time.LocalDate;

public class NoteCreator extends Note {

    public static void CreateNote(Notebook notebook) {
        Note note = new Note();
        note.setDate(LocalDate.now());
        System.out.println("Input a topic of note:");
        note.setTopic(ScannerManager.getTopicWithScanner());

        System.out.println("Input the email of note:");
        note.setEmail(ScannerManager.getEmailWithScanner());

        System.out.println("Input the text of note:");
        note.setText(ScannerManager.getTheTextWithScanner());

        SaveNote(notebook, note);
    }

    private static void SaveNote(Notebook notebook, Note newNote) {
        notebook.getNotes().add(newNote);
    }
}