import com.sun.deploy.util.StringUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FileParseUtils {
private static final String DELIMITER_OMITTING_PUNCTUATION_AND_SPACES = "[\\p{Blank}\\p{Punct}]";
    public Map<String, TextRowRepresentation> parse(InputStream location) {
        Map<String, TextRowRepresentation> uniqueWordsInfo = new TreeMap<>();
        try {
            Reader reader = new InputStreamReader(location);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String thisLine;
            Integer lineNumber = 1;
            while ((thisLine = bufferedReader.readLine()) != null) {
                parseLine(uniqueWordsInfo, thisLine, lineNumber);
                lineNumber++;
            }
            reader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return uniqueWordsInfo;

    }

    private static void parseLine(Map<String, TextRowRepresentation> uniqueWordsInfo, String line, Integer lineNumber) {
        String[] wordsArray = line.split(DELIMITER_OMITTING_PUNCTUATION_AND_SPACES);
        for(String word : wordsArray) {
            if(word != "" && !word.trim().isEmpty()) {
                uniqueWordsInfo.put(word, addNewValToUniqueWords(uniqueWordsInfo, word, lineNumber));
            }
        }
    }

    private static TextRowRepresentation addNewValToUniqueWords(Map<String, TextRowRepresentation> mapRepresentingUniqueWords, String word, Integer lineNumber) {
        TextRowRepresentation rowRepresentation;
        if(mapRepresentingUniqueWords.get(word) == null) {
            rowRepresentation = new TextRowRepresentation(lineNumber);
        } else {
            rowRepresentation = mapRepresentingUniqueWords.get(word);
            rowRepresentation.increaseAmountOfApearances();
            rowRepresentation.addAnotherLinePosition(lineNumber);
        }
        return rowRepresentation;
    }
}
