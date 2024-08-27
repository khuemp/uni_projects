package tinycc;

import tinycc.diagnostic.Locatable;
import tinycc.diagnostic.Location;
import tinycc.parser.Token;
import tinycc.parser.TokenKind;

public class Main {
    public static void main(String[] args) {
        Locatable l = new Location("test",0,0);
        Token c = new Token(l, TokenKind.CHARACTER, "k");
        Token s = new Token(l, TokenKind.STRING, "khue");
        Token o = new Token(l, TokenKind.AND_AND, "&&");
        Token i = new Token(l, TokenKind.IDENTIFIER, "i");
        System.out.println(c.toString() + "\n");
        System.out.println(s.toString() + "\n");
        System.out.println(o.toString() + "\n");
        System.out.println(i.toString() + "\n");
    }
}
