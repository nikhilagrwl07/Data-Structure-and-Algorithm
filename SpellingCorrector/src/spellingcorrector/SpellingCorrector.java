
package spellingcorrector;
 import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class SpellingCorrector {

      private HashMap<String, String> dictionary;

      public static void main(String[] args) {

      }

      public HashMap<String, String> getDictionary() {
            return dictionary;
      }

      public void setDictionary(HashMap<String, String> dictionary) {
            this.dictionary = dictionary;
      }

      /**
       * Get all possible edits of given word by swapping, inserting and deleting
       *
       * @param word
       * @return
       */
      public List<String> getEdits(String word) {
            List<String> edits = new ArrayList<String>();
            int wordLen = word.length();

            // Swapping i with i+1
            for (int i = 1; i < wordLen - 1; i++) {
                  edits.add(word.substring(0, i) + word.charAt(i + 1)
                              + word.charAt(i) + word.substring(i + 2));
            }

            // deleting one char, skipping i
            for (int i = 0; i < wordLen; i++) {
                  edits.add(word.substring(0, i) + word.substring(i + 1));
            }

            // inserting one char
            for (int i = 0; i < wordLen + 1; i++) {
                  for (char j = 'a'; j <= 'z'; j++)
                        edits.add(word.substring(0, i) + j + word.substring(i));
            }

            return edits;
      }

      /**
       * For given word, return closest match correct spelling
       *
       * @param word
       * @return
       */
      public String correctWord(String word) {
            if (!Util.isStringValid(word))
                  return null;

            if (dictionary.containsKey(word))
                  return word;

            List<String> edits = getEdits(word);
            if (edits.size() > 0) {
                  Map<String, String> suggestions = new HashMap<String, String>();

                  for (String edit : edits) {
                        if (dictionary.containsKey(edit)) {
                              suggestions.put(dictionary.get(edit), edit);
                        }
                  }
                 
                  if (suggestions.size() <= 0) {
                        List<String> tmpEdits = null;
                        for (String edit : edits) {
                              tmpEdits = getEdits(word);
                              for (String tmpEdit : tmpEdits) {
                                    if (dictionary.containsKey(edit)) {
                                          suggestions.put(dictionary.get(tmpEdit), tmpEdit);
                                    }
                              }
                        }
                  }

                  if (suggestions.size() > 0) {
                        return mostPopular(suggestions);
                  }
            }
            return null;
      }

      /**
       * Function to return most popular spelling suggestion
       *
       * For making it more fun for the reader, this function can be updated to
       * implement Edit Distance algorithm on top 5 valid words of given
       * suggestion and then find the most relevant spelling suggestion.
       *
       * @param suggestions
       * @return
       */
      public String mostPopular(Map<String, String> suggestions) {
            return suggestions.get(0);
      }

}

/**
 * Util functions
 *
 * @author paramsethi
 *
 */
class Util {

      public static boolean isStringValid(String input) {
            return input != null && input.length() > 0;
      }

      public static boolean isListValid(List data) {
            return (data != null && data.size() > 0);
      }

}
