import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Music> musicList = getData();
        printData(musicList);
    }

    private static List<Music> getData() {
        Scanner scanner;
        List<Music> list = new ArrayList<>();
        try {
            File file = new File("src/res/Data.txt");
            scanner = new Scanner(file);
            List<String> values = new ArrayList<>();
            while (scanner.hasNext()) {
                values.add(scanner.nextLine());
            }
            for (int i = 0; i < values.size(); i+=6) {
                list.add(new Music(values.get(i),values.get(i+1), Integer.parseInt(values.get(i+2)), Integer.parseInt(values.get(i+3)),Integer.parseInt(values.get(i+4))));
            }

        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return list;
    }

    private static void printData(List<Music> musicList) {
        for (Music music : musicList) {
            System.out.println(music);
        }
    }
}