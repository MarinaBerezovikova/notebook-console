package com.company.notebook.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Notebook implements Serializable {

    private List<Note> notes = new ArrayList<>();

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}