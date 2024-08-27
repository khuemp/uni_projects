package tinycc.implementation.statement;

import tinycc.implementation.expression.Expression;
import tinycc.implementation.type.Type;
import tinycc.parser.Token;

public class DeclarationStatement extends Statement {

    private Type type;
    private Token name;
    private Expression init;

    public DeclarationStatement(Type type, Token name, Expression init){
        this.type = type;
        this.name = name;
        this.init = init;
    }

    @Override
    public String toString() {
        if (init == null){
            return this.type.toString() + " " + this.name.toString() + ";";
        }
        return this.type.toString() + " " + this.name.toString() + " = " + this.init.toString() + ";";
    }

    @Override
    public void checkType() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void genCode() {
        // TODO Auto-generated method stub
        
    }
    
}
