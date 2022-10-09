import java.util.HashMap;

public class Consonant {
  public static Integer CountInWord(String word){
    var res = 0;    
    for (Character character : word.toCharArray()) {
      if (Constants.Consonants.contains(character.toString())){
        res++;
      }
    }
    return res;
  }
  public static HashMap<String, Integer> CountInText(String data){
    var words = data.split("[ \\-\\+\\,\\\\/\\.\\=\\(\\)]|[0-9]");
    var wordMap = new HashMap<String, Integer>();
    for (String word : words) {
      var wordToLower = word.toLowerCase();
      if (!wordMap.containsKey(word))
        if(wordToLower != ""){
          wordMap.put(wordToLower, CountInWord(wordToLower));
        }
    }
    return wordMap;
  }
}
