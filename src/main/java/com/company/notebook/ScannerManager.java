package com.company.notebook;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScannerManager {

    //case-insensitive included
    public static final Pattern EMAIL =
            Pattern.compile("(?i)^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$");

    //05-04-2005
//    public static final Pattern DATE =
//    Pattern.compile("^((0[1-9])|(1[0-9]|(2[0-9])))([-]|[\\/])([0|1|2][0-9])([-]|[\\/])(\\d{4})");

    static Scanner scan = new Scanner(System.in);

    public static String getTopicWithScanner() {
        return scan.next();
    }

    public static LocalDate getDateWithScanner() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = null;

        String dateStr = scan.next();
        try {
            date = LocalDate.parse(dateStr, dateFormat);
        } catch (DateTimeParseException e) {
            System.out.println("Oops! Our analyzer haven't understand inputted date.\n");
            getDateWithScanner();
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String getEmailWithScanner() {
        String email = scan.next();
        int availableTries = 2;
        int countOfTries = 0;
        while (!verifiedEmail(email) & countOfTries != availableTries) {
            System.out.println("Entered email is not valid. Try enter again:");
            email = scan.next();
            countOfTries++;
        }
        if (verifiedEmail(email)) {
            return email;
        } else return "undefined";
    }

    public static String getPartOfTextWithScanner() {
        String textPart = scan.next();
        if (textPart.equals("")) {
            return "no text";
        }
        return textPart;
    }

    public static String getTheTextWithScanner() {
        System.out.println("*Hint: When you will want to over type text input \"/\" for exit.*");

        List<String> tokens = new ArrayList<>();
        String temp;
        while (!(temp = scan.nextLine()).equals("/")) {
            tokens.add(temp);
        }
        return String.join("\n", tokens);
    }

    public static int getChooseActive() {
        int choose; // default choose == 0
        while (!(scan.hasNextInt())) {
            scan.next();
        }
        choose = scan.nextInt();
        if (verifiedActiveChoose(choose)) {
            return choose;
        } else {
            return 0;
        }
    }

    public static int getChooseSearching() {
        int choose; // default choose == 0
        while (!(scan.hasNextInt())) {
            scan.next();
        }
        choose = scan.nextInt();
        if (verifiedSearchingChoose(choose)) {
            return choose;
        } else {
            return 0;
        }
    }

    public static boolean getAnswerNeedSort() {
        char answer;
        try {
            answer = scan.next().charAt(0);
            return verifiedSortingChoose(answer);
        } catch (
                NoSuchElementException exception) {
            return false;
        }
    }

    public static int getAnswerTypeSort() {
        int choose;
        // default choose == 0
        try {
            choose = scan.nextInt();
            if (verifiedSortingTypeChoose(choose)) {
                return choose;
            } else {
                return 0;
            }
        } catch (InputMismatchException exception) {
            return 0;
        }
    }

    private static boolean verifiedActiveChoose(int choose) {
        // count of variable command from NoteSearcher
        int lastCommand = 4;
        int firstCommand = 1;
        return choose <= lastCommand && choose >= firstCommand;
    }

    private static boolean verifiedSearchingChoose(int choose) {
        // count of parameters from Notebook
        int lastCommand = 4;
        int firstCommand = 1;
        return choose <= lastCommand && choose >= firstCommand;
    }

    private static boolean verifiedSortingChoose(char answer) {
        // count of variable command from NoteSearcher
        char answerYes = 'Y';
        char answerYes0 = 'y';
        return answer == answerYes || answer == answerYes0;
    }

    private static boolean verifiedSortingTypeChoose(int choose) {
        //there is two sort way - by topic and by date
        int lastCommand = 2;
        int firstCommand = 1;
        return choose <= lastCommand && choose >= firstCommand;
    }

    private static boolean verifiedEmail(String email) {
        Matcher matcher = EMAIL.matcher(email);
        return matcher.find();
    }
}