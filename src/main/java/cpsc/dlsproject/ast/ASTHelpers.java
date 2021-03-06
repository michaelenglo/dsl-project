package cpsc.dlsproject.ast;

import cpsc.dlsproject.tools.Tokenizer;

public class ASTHelpers {

    public static boolean CheckForRequestType() {
        Tokenizer tokenizer = Tokenizer.getTokenizer();
        return tokenizer.checkToken("GET") || tokenizer.checkToken("POST") || tokenizer.checkToken("DELETE") || tokenizer.checkToken("PUT");
    }

    public static boolean CheckForCond() {
        Tokenizer tokenizer = Tokenizer.getTokenizer();
        return tokenizer.checkToken("IF") || tokenizer.checkToken("ELSE") || tokenizer.checkToken("THEN");
    }

    public static boolean CheckForIO() {
        Tokenizer tokenizer = Tokenizer.getTokenizer();
        return tokenizer.checkToken("READFILE") || tokenizer.checkToken("WRITEFILE");
    }

    public static boolean CheckForLogical() {
        Tokenizer tokenizer = Tokenizer.getTokenizer();
        return  tokenizer.checkToken("<") || tokenizer.checkToken(">") || tokenizer.checkToken("==") ||
                tokenizer.checkToken("!=") || tokenizer.checkToken("<=") || tokenizer.checkToken(">=");
    }

    public static boolean CheckForOperator() {
        Tokenizer tokenizer = Tokenizer.getTokenizer();
        return  tokenizer.checkNext().matches("PLUS") || tokenizer.checkToken("-") || tokenizer.checkToken("MULTI") || tokenizer.checkToken("/");
    }
}
