package piglatin;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Book {
    private String title;
    private ArrayList<String> text = new ArrayList<String>();

    Book() {
        // Empty book - no code needed here.
    }

    // Helper to debug code
    // Prints out a range of lines from a book
    public void printlines(int start, int length) {
        System.out.println("Lines " + start + " to " + (start + length) + " of book: " + title);
        for (int i = start; i < start + length; i++) {
            if (i < text.size()) {
                System.out.println(i + ": " + text.get(i));
            } else {
                System.out.println(i + ": line not in book.");
            }
        }
    }

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    String getLine(int lineNumber) {
        return text.get(lineNumber);
    }

    int getLineCount() {
        return text.size();
    }

    void appendLine(String line) {
        text.add(line);
    }

    public void readFromString(String title, String string) {
    this.title = title;
    Scanner scan = new Scanner(string);
    while (scan.hasNextLine()) {
        text.add(scan.nextLine());
    }
    scan.close();
}

    public void readFromUrl(String title, String url) {
    this.title = title;
    try {
        URL bookUrl = URI.create(url).toURL();
        Scanner scan = new Scanner(bookUrl.openStream());
        while (scan.hasNextLine()) {
            text.add(scan.nextLine());
        }
        scan.close();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}

  void writeToFile(String name) {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(name));
            for (String line : text) {
                out.println(line);
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}