import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadFile {
    public ReadFile() {
    }

    void readFile() throws IOException {
        final String filePath = "src/katalog.txt";
        final List<String> list = new ArrayList<String>();
        list.add(0,"nazwa producenta");
        list.add(1,"przekątna ekranu");
        list.add(2,"rodzaj powierzchni ekranu");
        list.add(3,"czy ekran jest dotykowy");
        list.add(4,"nazwa procesora");
        list.add(5,"liczba rdzeni fizycznych");
        list.add(6,"prędkość taktowania MHz");
        list.add(7,"wielkość pamięci RAM");
        list.add(8,"pojemność dysku");
        list.add(9,"rodzaj dysku");
        list.add(10,"nazwa układu graficznego");
        list.add(11,"pamięć układu graficznego");
        list.add(12,"nazwa systemu operacyjnego");
        list.add(13,"rodzaj napędu fizycznego w komputerze");

        BufferedReader fileReader = new BufferedReader(new FileReader(filePath));
        String line;

        while (null != (line = fileReader.readLine())) {
            System.out.println(Arrays.toString(line.split(";")));
        }
    }

    public static void main(String[] args) throws IOException {
        ReadFile file = new ReadFile();
        file.readFile();

    }

}

