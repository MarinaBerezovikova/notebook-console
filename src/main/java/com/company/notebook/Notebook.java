package com.company.notebook;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Notebook implements Serializable {

    static List<Note> notes = new ArrayList<>();

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        Notebook.notes = notes;
    }
}