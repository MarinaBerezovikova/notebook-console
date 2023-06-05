package com.company.notebook;

import java.time.LocalDate;

public class NoteCreator extends Note {

    public static Note CreateNote() {
        Note note = new Note();
        note.setDate(LocalDate.now());
        System.out.println("Input a topic of note:");
        note.setTopic(ScannerManager.getTopicWithScanner());

        System.out.println("Input the email of note:");
        note.setEmail(ScannerManager.getEmailWithScanner());

        System.out.println("Input the text of note:");
        note.setText(ScannerManager.getTheTextWithScanner());

        SaveNote(note);
        return note;
    }

    private static void SaveNote(Note newNote) {
        Notebook.notes.add(newNote);
    }
}