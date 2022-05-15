package cheater.home;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Starter {
    public static Dictionary dictionary = new Dictionary();

    public static void main(String[] args) {
        try {
            dictionary = new Dictionary(getDictionary());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Possible letters: ");
            String letters = scanner.nextLine();
            if (letters.trim().length() < 3) {
                break;
            }
            while (true) {
                System.out.print("Template:");
                String template = scanner.nextLine();
                if (template.length() == 0) {
                    break;
                }
                List<SingleWord> byTemplate=dictionary.getByTemplate(template)
                        .stream().filter(w->w.checkRestrictions(letters))
                        .collect(Collectors.toList());
               if(byTemplate.size()==0){
                   System.out.println("Варианты не найдены");
               }else{
                   for(SingleWord singleWord:byTemplate){
                       System.out.println(singleWord.getWord());
                   }

               }
            }
        }
        System.out.println("Done!");
    }

    private static List<String> getDictionary() throws FileNotFoundException, URISyntaxException {
        URL resource = Starter.class.getClassLoader().getResource("singular.txt");
        if ((resource == null)) {
            throw new FileNotFoundException("Dictionary file not found");
        }
        File wordslist = new File(resource.toURI());
        List<String> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(wordslist)) {
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
        }
        return list;
    }
}
