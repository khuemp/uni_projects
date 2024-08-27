package tinycc.implementation.expression;

import java.util.List;

import tinycc.implementation.type.Type;
import tinycc.parser.Token;

public class CallExpression extends Expression {

    private Token token;
    private Expression callee;
    private List<Expression> arguments;

    public CallExpression(Token token, Expression callee, List<Expression> arguments) {
        this.token = token;
        this.callee = callee;
        this.arguments = arguments;
    }

    @Override
    public String toString() {
        String list = "";
        for (int i = 0; i < this.arguments.size(); i++) {
            if (i < this.arguments.size() - 1) {
                list += this.arguments.get(i).toString() + ",";
            } else {
                list += this.arguments.get(i).toString();
            }
        }
        return this.callee.toString() + this.token.toString() + list + ")";
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
