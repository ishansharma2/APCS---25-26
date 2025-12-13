package piglatin;

public class PigLatinTranslator {

    public static Book translate(Book input) {
        Book translated = new Book();
        translated.setTitle(input.getTitle());

        for (int i = 0; i < input.getLineCount(); i++) {
            translated.appendLine(translate(input.getLine(i)));
        }
        return translated;
    }

    public static String translate(String input) {
        if (input == null) return "";

        // Keep original spacing at the ends? Your version trims, so we keep that behavior.
        String trimmed = input.trim();
        if (trimmed.isEmpty()) return "";

        String[] parts = trimmed.split("\\s+");
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < parts.length; i++) {
            String p = parts[i];
            if (!p.isEmpty()) {
                out.append(translateWord(p));
                if (i < parts.length - 1) out.append(' ');
            }
        }
        return out.toString();
    }

  
private static String translateWord(String token) {
        if (token == null || token.isEmpty()) return "";

        // Split token into:
        // leading punctuation/symbols + core word (letters/hyphen) + trailing punctuation/symbols
        int start = 0;
        while (start < token.length() && !isLetterOrHyphen(token.charAt(start))) {
            start++;
        }

        int end = token.length();
        while (end > start && !isLetterOrHyphen(token.charAt(end - 1))) {
            end--;
        }

        String leading = token.substring(0, start);
        String core = token.substring(start, end);
        String trailing = token.substring(end);

        if (core.isEmpty()) return token; // no letters at all, just return it

        boolean firstWasUpper = Character.isUpperCase(core.charAt(0));
        String translatedCore;

        if (startsWithVowel(core)) {
            translatedCore = core + "ay";
        } else {
            int v = indexOfFirstVowel(core);
            if (v == -1) {
                translatedCore = core + "ay";
            } else {
                String remainder = core.substring(v);
                String cluster = core.substring(0, v).toLowerCase();
                translatedCore = remainder + cluster + "ay";
            }
        }

        translatedCore = transferFirstLetterStyle(translatedCore, firstWasUpper);

        return leading + translatedCore + trailing;
    }

    private static boolean isLetterOrHyphen(char c) {
        return Character.isLetter(c) || c == '-';
    }

    private static boolean startsWithVowel(String s) {
        return !s.isEmpty() && isVowel(s.charAt(0));
    }

    private static boolean isVowel(char c) {
        switch (Character.toLowerCase(c)) {
            case 'a': case 'e': case 'i': case 'o': case 'u':
                return true;
            default:
                return false;
        }
    }

    private static int indexOfFirstVowel(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) return i;
        }
        return -1;
    }

    private static String transferFirstLetterStyle(String s, boolean makeUpper) {
        if (s.isEmpty()) return s;
        char first = s.charAt(0);
        char newFirst = makeUpper ? Character.toUpperCase(first) : Character.toLowerCase(first);
        if (first == newFirst) return s;
        return newFirst + s.substring(1);
    }
}