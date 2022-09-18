import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class FileReader {
  public static HashMap<String, Integer> Read(String path){
    try {
      File file = new File(path);
      Scanner reader = new Scanner(file);
      var fileData = new StringBuilder();
      while (reader.hasNextLine()) {
        fileData.append( " "+reader.nextLine());
      }
      reader.close();
      return mapWords(fileData.toString());
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred: file not found");
      e.printStackTrace();
      System.exit(1);
      return null;
    }
  } 
  private static HashMap<String, Integer> mapWords(String data){
    var words = data.split("[ \\-\\+\\,\\\\/\\.\\=\\(\\)]|[0-9]");
    var wordMap = new HashMap<String, Integer>();
    for (String word : words) {
      var wordToLower = word.toLowerCase();
      if (!wordMap.containsKey(word))
        if(wordToLower != ""){
          wordMap.put(wordToLower, countConsonants(wordToLower));
        }
    }
    return wordMap;
  }
  private static Integer countConsonants(String word){
    var res = 0;    
    for (Character character : word.toCharArray()) {
      if (Constants.Consonants.contains(character.toString())){
        res++;
      }
    }
    return res;
  }
}
