import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class App {
    public static void main(String[] args) throws Exception {
        var words = FileReader.Read(Constants.FilePath);
        var sortedWords = new LinkedHashMap<String, Integer>();
        var list = new ArrayList<Integer>();
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return (num1).compareTo(num2);
            }
        });
        for (Integer num : list) {
            for (Entry<String, Integer> entry : words.entrySet()) {
                if (entry.getValue() == num) {
                    sortedWords.put(entry.getKey(), num);
                }
            }
        }
        System.out.println(sortedWords.keySet());
    }
}
