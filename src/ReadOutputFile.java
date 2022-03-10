import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadOutputFile {
    public ReadOutputFile() {
    }

    void prepareFile() throws IOException {
        final String filePath = "src/katalog.txt";
        final List<String> list = new ArrayList<String>();
        list.add(0, "Lp");
        list.add(1, "Producent");
        list.add(2, "Przekątna ekranu");
        list.add(3, "Rozdzielczość");
        list.add(4, "Rodzaj powierzchni ekranu");
        list.add(5, "Dotykowy");
        list.add(6, "Procesor");
        list.add(7, "Liczba rdzeni fizycznych");
        list.add(8, "Prędkość taktowania MHz");
        list.add(9, "Wielkość pamięci RAM");
        list.add(10, "Pojemność dysku");
        list.add(11, "Rodzaj dysku");
        list.add(12, "Nazwa układu graficznego");
        list.add(13, "Pamięć układu graficznego");
        list.add(14, "Nazwa systemu operacyjnego");
        list.add(15, "Rodzaj napędu fizycznego w komputerze");

        BufferedReader fileReader = null;
        String line;
        try {
            fileReader = new BufferedReader(new FileReader(filePath));

        } catch (FileNotFoundException e) {
            System.out.println("Blad przy otwieraniu pliku!");
        }

        int lDell = 0;
        int lAsus = 0;
        int lFujitsu = 0;
        int lHuawei = 0;
        int lMSI = 0;
        int lSamsung = 0;
        int lSony = 0;
        int j = 1;

        System.out.print("\n");
        for (int i = 0; i < list.size(); i++) {
            if (i == 0)
                System.out.print(list.get(i) + "\t" + "|");
            else {
                show(list.get(i));
            }
        }
        System.out.print("\n");

        writeSeparate(635, "-", "\n");

        if (fileReader != null) {
            while (null != (line = fileReader.readLine())) {
                String[] words = line.split(";", -1);
                System.out.print(j + "\t" + "|");
                int i = 0;
                for (String word : words) {
                    if (word.isEmpty() && i < words.length - 1)
                        show("Brak informacji");
                    else if (!word.isEmpty())
                        show(word);

                    if (i == 0) {
                        if (word.equals("Dell")) {
                            lDell++;
                        } else if (word.equals("Asus")) {
                            lAsus++;
                        } else if (word.equals("Fujitsu")) {
                            lFujitsu++;
                        } else if (word.equals("Huawei")) {
                            lHuawei++;
                        } else if (word.equals("MSI")) {
                            lMSI++;
                        } else if (word.equals("Sony")) {
                            lSony++;
                        } else if (word.equals("Samsung")) {
                            lSamsung++;
                        }
                    }

                    i++;
                    if (i > words.length - 1) {
                        System.out.print("\n");
                        i = 0;
                    }
                }
                j++;
            }
        }
        showProducent(lDell, lAsus, lFujitsu, lHuawei, lMSI, lSamsung, lSony);
    }

    private static void writeSeparate(int i2, String s, String s2) {
        for (int i = 0; i < i2; i++) {
            System.out.print(s);
        }
        System.out.print(s2);
    }

    private void showProducent(int lDell, int lAsus, int lFujitsu, int lHuawei, int lMSI, int lSamsung, int lSony) {
        System.out.println("\nSuma poszczególnych producentów laptopów:" +
                "\n" + "Dell: " + lDell +
                "\n" + "Asus: " + lAsus +
                "\n" + "Fujitsu: " + lFujitsu +
                "\n" + "Huawei: " + lHuawei +
                "\n" + "MSI: " + lMSI +
                "\n" + "Sony: " + lSony +
                "\n" + "Samsung: " + lSamsung);
    }

    private static void show(String word) {
        int size = word.length();
        System.out.print(" " + word);
        writeSeparate(40 - size, " ", "|");
    }

    public static void main(String[] args) throws IOException {
        ReadOutputFile file = new ReadOutputFile();
        file.prepareFile();
    }

}


