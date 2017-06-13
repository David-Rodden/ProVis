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
        return isFormFunction(text) || isBracketCloser(text) || isFormInt(text) || isFormChar(text) || isFormString(text);
    }

    public void parseLine(final String text) {
        if (isFormInt(text)) extractInt(text);
        else if (isFormChar(text)) extractChar(text);
        else if (isFormString(text)) extractString(text);
        else memory.addData(text);
    }

    private String getDeclName(final String text) {
        final List<String> declParts = Arrays.asList(text.split("=")[0].split("\\s+")).stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        return declParts.get(declParts.size() - 1);
    }

    private void extractInt(final String text) {
        final int value = Integer.parseInt(text.split("=")[1].replaceAll("\\D", ""));
        memory.addInteger(getDeclName(text) + "_int", value);
    }

    private void extractChar(final String text) {
        memory.addCharacter(getDeclName(text) + "_char", text.split("'")[1].charAt(0));
    }

    private void extractString(final String text) {
        memory.addString(getDeclName(text) + "_char()", text.split("\"")[1]);
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

    private boolean isFormString(final String text) {
        return text.matches("\\s*char\\(\\)\\s*\\w+\\s*=\\s*\"\\w*\"\\s*;");
    }

    private boolean isFormArray(final String text) {
        return text.matches("\\s*\\[]\\s*");
    }
}
