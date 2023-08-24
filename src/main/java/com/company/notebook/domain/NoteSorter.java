package com.company.notebook.domain;

import java.util.Comparator;
import java.util.List;

public class NoteSorter {

    private static final Comparator<Note> COMPARE_BY_DATA =
            Comparator.comparing(Note::getDate);

    private static final Comparator<Note> COMPARE_BY_TOPIC =
            Comparator.comparing(Note::getTopic);

    public static List<Note> sortByDate(List<Note> notes) {
        notes.sort(COMPARE_BY_DATA);
        return notes;
    }

    public static List<Note> sortByTopic(List<Note> notes) {
        notes.sort(COMPARE_BY_TOPIC);
        return notes;
    }
}