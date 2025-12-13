package piglatin;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class Book {
    private String title;
    private ArrayList<String> text = new ArrayList<>();

    public Book() {
        // Empty book
    }


    // Helper to debug code
    // Prints out a range of lines from a book
   public void printlines(int start, int length) {
        System.out.println("Lines " + start + " to " + (start + length) + " of book: " + title);
        for (int i = start; i < start + length; i++) {
            if (i >= 0 && i < text.size()) {
                System.out.println(i + ": " + text.get(i));
            } else {
                System.out.println(i + ": line not in book.");
            }
        }
    }

    public String getTitle() {
        return title;
    }


        public void setTitle(String title) {
        this.title = title;
    }

    public String getLine(int lineNumber) {
        return text.get(lineNumber);
    }

    public int getLineCount() {
        return text.size();
    }

    public void appendLine(String line) {
        text.add(line);
    }

    public void readFromString(String title, String string) {
        this.title = title;
        text.clear();

        if (string == null) return;

        Scanner scan = new Scanner(string);
        while (scan.hasNextLine()) {
            text.add(scan.nextLine());
        }
        scan.close();
    }

    public void readFromUrl(String title, String url) {
        this.title = title;
        text.clear();

        try {
            URL bookUrl = URI.create(url).toURL();
            Scanner scan = new Scanner(bookUrl.openStream(), StandardCharsets.UTF_8);
            while (scan.hasNextLine()) {
                text.add(scan.nextLine());
            }
            scan.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (IllegalArgumentException ex) {
            // bad URL format passed into URI.create
            ex.printStackTrace();
        }
    }

    public void writeToFile(String name) {
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
