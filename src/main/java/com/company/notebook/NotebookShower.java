package com.company.notebook;

import java.util.List;

public class NotebookShower {

    public void showNotebookList(List<Note> notes) {
        notes.forEach(System.out::println);
    }
}