import java.util.List;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

class Hangman {
    public static List<String> pictures = new ArrayList<>();
    public static List<String> DICT = makeDict();
    // String[] PICTURES = [
/*
 +---+
 |   |
     |
     |
     |
     |
==========,

 +---+
 |   |
 O   |
     |
     |
     |
==========,

 +---+
 |   |
 O   |
 |   |
     |
     |
==========,

 +---+
 |   |
 O   |
/|   |
     |
     |
==========,

 +---+
 |   |
 O   |
/|\  |
     |
     |
==========,

 +---+
 |   |
 O   |
/|\  |
/    |
     |
==========,

 +---+
 |   |
 O   |
/|\  |
/ \  |
     |
==========*/

    public static void showBoard () {

    }

    public static void main(String[] args) {
        System.out.println("Still in progress. Come back later :)");
    }

    public static List<String> makeDict() {
        try {
            return Files.readAllLines(
                Paths.get("/usr/share/dict/american-english-small"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
