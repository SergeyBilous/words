package cheater.home;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Starter {
    public static Dictionary dictionary=new Dictionary();
    public static void main(String[] args) {
        try {
            dictionary=new Dictionary(getDictionary());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        System.out.println("Done!");
    }

    private static List<String> getDictionary() throws FileNotFoundException, URISyntaxException {
        URL resource = Starter.class.getClassLoader().getResource("singular.txt");
        if ((resource == null)) {
            throw new FileNotFoundException("Dictionary file not found");
        }
        File wordslist = new File(resource.toURI());
        List<String> list=new ArrayList<>();
        try(Scanner scanner=new Scanner(wordslist)){
            while (scanner.hasNextLine()){
                list.add(scanner.nextLine());
            }
        }
        return list;
    }
}
