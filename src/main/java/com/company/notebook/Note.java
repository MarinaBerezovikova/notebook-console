package com.company.notebook;

import java.io.Serializable;
import java.time.LocalDate;

public class Note implements Serializable {

    private String topic;
    private LocalDate date;
    private String email;
    private String text;

    //default constructor
    public Note() {
        topic = "Unnamed";
        date = LocalDate.now();
        email = "Undefined";
        text = "No text";
    }

    public String getTopic() {
        return topic;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }

    public String getText() {
        return text;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setText(String text) {
        this.text = text;
    }

   @Override
   public String toString() {
        return "Topic: " + topic +
                "\nDay of creature note: " + date.getDayOfMonth() + " " + date.getMonth() + " " + date.getYear() +
                "\nEmail: " + email +
                "\nText: " + text + "\n";
   }
}