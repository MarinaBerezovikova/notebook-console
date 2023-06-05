package com.company.notebook;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NoteSearcher {

    List<Note> foundedNotes = new ArrayList<>();

    public void findNoteByTopic() {
        clearList();

        // finds by word, sentences and part of topic
        System.out.println("Enter the topic of the searched note:");
        String needToFindByTopic = ScannerManager.getTopicWithScanner().toLowerCase();
        Notebook.notes.stream()
                .filter(note -> note.getTopic().toLowerCase().contains(needToFindByTopic))
                .forEach(note -> foundedNotes.add(note));
        // dialog about need to filter list
        NoteSorter.sortByTopic(foundedNotes);
    }

    public void findNoteByEmail() {
        clearList();
        System.out.println("Enter the email, which specified in the searched note:");
        String needToFindEmail = ScannerManager.getEmailWithScanner();

        Notebook.notes.stream()
                .filter(note -> note.getEmail().toLowerCase().contains(needToFindEmail))
                .forEach(note -> foundedNotes.add(note));
    }
    public void findNoteByDate() {
        clearList();
        System.out.println("Enter the day, month and year via these format 20-12-2007 of the searched note:");
        LocalDate needToFindByDate = ScannerManager.getDateWithScanner();
        Notebook.notes.forEach(note1 -> {
            LocalDate date = note1.getDate();
            if (date.equals(needToFindByDate)) {
                foundedNotes.add(note1);
            }
        });
        NoteSorter.sortByDate(foundedNotes);
    }

    public void findNoteByMatchText() {
        // finds by word, sentences and part of text
        clearList();
        System.out.println("Enter the part text of the searched note:");
        String textToFindMatch = ScannerManager.getPartOfTextWithScanner().toLowerCase();

        Notebook.notes.stream()
                .filter(note -> note.getText().toLowerCase().contains(textToFindMatch))
                .forEach(note -> foundedNotes.add(note));
    }

    private void clearList() {
        if (!foundedNotes.isEmpty()) {
            foundedNotes.clear();
        }
    }
}