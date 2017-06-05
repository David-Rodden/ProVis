package parse;

import memory.Memory;

/**
 * Created by David on 6/5/2017.
 */
public class DeclParser {
    private final Memory memory;

    public DeclParser(final Memory memory) {
        this.memory = memory;
    }

    public boolean checkLine(final String text){
        return isFormInt(text) || isFormChar(text);
    }
    public void parseLine(final String text) {
        memory.addData(isFormInt(text) ? "INTEGER" : isFormChar(text) ? "CHARACTER" : "NONE");

    }

    private boolean isFormInt(final String text) {
        return text.matches("\\s*int\\s*\\w+\\s*=\\s*\\d+\\s*;");
    }

    private boolean isFormChar(final String text) {
        return text.matches("\\s*char\\s*\\w+\\s*=\\s*'.'\\s*;");
    }
}
