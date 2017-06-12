package parse;

import memory.Memory;

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
        if (isFormInt(text)) memory.addInteger(32);
        else if (isFormChar(text)) memory.addCharacter('c');
        else memory.addData(text);
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
