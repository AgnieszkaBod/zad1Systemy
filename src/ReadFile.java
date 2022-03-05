import java.io.*;

public class ReadFile {
    String filePath = "src/katalog.txt";

    public ReadFile() throws IOException {
        BufferedReader fileReader = new BufferedReader
                (new FileReader(new File(filePath)));
        String line;

        while (null != (fileReader.readLine())) {
            line = fileReader.readLine();
        }
    }

    public static void main(String args[]) {
        String[] result = "this;is;a;test".split(";");

        for (int x = 0; x < result.length; x++) {
            System.out.println(result[x]);
        }
    }

}

