package parse;

import memory.Memory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by David on 6/5/2017.
 */
public class DeclParser {
    private final Memory memory;
    private int depth;

    public DeclParser(final Memory memory) {
        this.memory = memory;
        depth = 0;
    }

    public boolean checkLine(final String text) {
        return isFormFunction(text) || isBracketCloser(text) || isFormInt(text) || isFormChar(text);
    }

    public void parseLine(final String text) {
        if (isFormInt(text)) memory.addInteger(extractIntName(text), extractInt(text));
        else if (isFormChar(text)) memory.addCharacter(extractCharName(text), extractChar(text));
        else memory.addData(text);
    }

    private String extractIntName(final String text) {
        final List<String> declParts = Arrays.asList(text.split("=")[0].split("\\s+")).stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        return declParts.get(declParts.size() - 1) + "_int";
    }

    private int extractInt(final String text) {
        return Integer.parseInt(text.split("=")[1].replaceAll("\\D", ""));
    }

    private String extractCharName(final String text){
        final List<String> declParts = Arrays.asList(text.split("=")[0].split("\\s+")).stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        return declParts.get(declParts.size() - 1) + "_char";
    }
    private char extractChar(final String text) {
        return text.split("'")[1].charAt(0);
    }

    private boolean isFormFunction(final String text) {
        return text.matches("\\s*(int|char)\\s*\\w+\\(\\)\\s*\\{");
    }

    private boolean isBracketCloser(final String text) {
        return text.matches("\\s*}");
    }

    private boolean isFormInt(final String text) {
        return text.matches("\\s*int\\s*\\w+\\s*=\\s*\\d+\\s*;");
    }

    private boolean isFormChar(final String text) {
        return text.matches("\\s*char\\s*\\w+\\s*=\\s*'.'\\s*;");
    }

    private boolean isFormArray(final String text) {
        return text.matches("\\s*\\[]\\s*");
    }
}
