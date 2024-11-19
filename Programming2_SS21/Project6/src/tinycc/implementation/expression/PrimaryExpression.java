package tinycc.implementation.expression;

import tinycc.implementation.type.Type;
import tinycc.parser.Token;

public class PrimaryExpression extends Expression {
    
    private Token token;

    public PrimaryExpression(Token token){
        this.token = token;
    }

    @Override
    public String toString() {
        return this.token.toString();
    }

    @Override
    public Type getType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void genCode() {
        // TODO Auto-generated method stub
        
    }
    
}
