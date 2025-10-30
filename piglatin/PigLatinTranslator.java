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
        System.out.println("  -> translate('" + input + "')");

        if (input == null) return "";
        String trimmed = input.trim();
        if (trimmed.isEmpty()) return "";

      
        String[] parts = trimmed.split("\\s+");
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            if (!parts[i].isEmpty()) {
                out.append(translateWord(parts[i]));
                if (i < parts.length - 1) out.append(' ');
            }
        }
        return out.toString();
    }

  
    private static String translateWord(String token) {
        System.out.println("  -> translateWord('" + token + "')");

        if (token.isEmpty()) return "";

        // Strip trailing non-letters (keep internal hyphens)
        int end = token.length();
        while (end > 0 && !isLetterOrHyphen(token.charAt(end - 1))) {
            end--;
        }
        String core = token.substring(0, end);
        String trailing = token.substring(end); // punctuation/symbols to re-append

        if (core.isEmpty()) return trailing;

        boolean firstWasUpper = Character.isUpperCase(core.charAt(0));
        String translatedCore;

        if (startsWithVowel(core)) {
            translatedCore = core + "ay";
        } else {
            int v = indexOfFirstVowel(core);
            if (v == -1) {
                // No vowels: just append "ay"
                translatedCore = core + "ay";
            } else {
                String remainder = core.substring(v);                 // keep original casing
                String cluster = core.substring(0, v).toLowerCase();  // moved cluster lowercased
                translatedCore = remainder + cluster + "ay";
            }
        }

       
        translatedCore = transferFirstLetterStyle(translatedCore, firstWasUpper);

        return translatedCore + trailing;
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
