package com.company.notebook;

public class NotebookUtility {
    static boolean isWorking = true;
    static NotebookShower notebookShower = new NotebookShower();

    public static void startApplication() {

        System.out.println("Welcome! Everything is ready to work. Let's start work with notebook.\n");

        int choose;
        while (isWorking) {
            System.out.println("What would you want to do:\n1) Show me all notes \n2) Add a new note \n3) Find the note \n4) Exit from application\nInput a count of active:");
            choose = ScannerManager.getChooseActive();
            switch (choose) {
                case 0:
                    System.out.println("In step above you input a wrong number. Try again:");
                    break;
                case 1:
                    System.out.println("You chose number 1 - \"Show me all notes\"\n");
                    notebookShower.showNotebookList(Notebook.notes);
                    break;
                case 2:
                    System.out.println("You chose number 2 - \"Add a new note\"\n");
                    NoteCreator.CreateNote();
                    notebookShower.showNotebookList(Notebook.notes);
                    break;
                case 3: // выделить в отдельный метод
                    System.out.println("You chose number 3 - \"Find the note\"\n");
                    searchingMenu();
                    break;
                case 4:
                    System.out.println("You chose number 4 - \"Exit from application\"\n ");
                    System.out.println("The application is closed. Have a good day!");
                    isWorking = false;
            }
        }
    }

    static NoteSearcher noteSearcher = new NoteSearcher();

    static void searchingMenu() {
        System.out.println("We able to search by several parameters:\n1 - topic\n2 - date\n3 - email\n4 - part of text\n0 - step back\nPlease, input the number of fits parameter:");

        switch (ScannerManager.getChooseSearching()) {
            case 0:
                break;
            case 1: //topic
                noteSearcher.findNoteByTopic();
                verifiedResult();
                break;

            case 2: //date
                noteSearcher.findNoteByDate();
                verifiedResult();
                break;

            case 3: //email
                noteSearcher.findNoteByEmail();
                verifiedResult();
                break;

            case 4: //a part of text
                noteSearcher.findNoteByMatchText();
                verifiedResult();
                break;
        }
    }

    static void verifiedResult() {
        if (noteSearcher.foundedNotes.size() != 0) {
            offerToSortNotes();
            notebookShower.showNotebookList(noteSearcher.foundedNotes);
        } else {
            System.out.println("We not found any notes by your parameter.\n");
        }
    }

    static void offerToSortNotes() {
        System.out.println("We should to sort found notes?\n'Y' - yes\n'N' - no");
        if (ScannerManager.getAnswerNeedSort()) {
            sortingMenu();
        }
    }

    static void sortingMenu() {
        System.out.println("Input the count of needed way of sort: \n1 - sort by topics\n2 - sort by dates\n0 - step back");
        int choice = ScannerManager.getAnswerTypeSort();
        switch (choice) {
            case 0:
                break;
            case 1: // sort by topic
                NoteSorter.sortByTopic(noteSearcher.foundedNotes);
                break;
            case 2: // sort by date
                NoteSorter.sortByDate(noteSearcher.foundedNotes);
                break;
        }
    }
}