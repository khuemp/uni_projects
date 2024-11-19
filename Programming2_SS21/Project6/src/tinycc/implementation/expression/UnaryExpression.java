package tinycc.implementation.expression;

import tinycc.implementation.type.Type;
import tinycc.parser.Token;

public class UnaryExpression extends Expression {

    private Token operator;
    private boolean postfix;
    private Expression operand;

    public UnaryExpression(Token operator, boolean postfix, Expression operand) {
        this.operator = operator;
        this.postfix = postfix;
        this.operand = operand;
    }

    @Override
    public String toString() {
        if (!postfix) {

        }
        return "(" + this.operator.toString() + this.operand.toString() + ")";
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
