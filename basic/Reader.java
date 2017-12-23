import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

class Reader {

    public static void main(String[] args) {
        try {
        File file;
        if (args.length == 1) {
            file = new File(args[0]);
        } else {
            file = new File(getSourceFile());
        }

        System.out.print(read(new FileInputStream(file)));
        } catch (IOException | URISyntaxException e) {
        e.printStackTrace();
        }
     }

    static String read(InputStream s) throws IOException {
        int bufferSize = 1024;
        char[] buffer = new char[bufferSize];
        final StringBuilder result = new StringBuilder();
        InputStreamReader in = new InputStreamReader(s, "UTF-8");
        int read;
        while (true) {
            read = in.read(buffer, 0, buffer.length);
            if (read < 0) break;
            result.append(buffer, 0, read);
        }
        return result.toString();
    }

    static String getSourceFile() throws URISyntaxException {
        return  new Reader().getClass()
                .getProtectionDomain()
                .getCodeSource()
                .getLocation()
                .toURI()
                .resolve("Reader.java")
                .getRawPath();
    }
}

