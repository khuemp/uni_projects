package tinycc.implementation.expression;

import tinycc.implementation.type.Type;
import tinycc.parser.Token;

public class BinaryExpression extends Expression {

    private Token operator;
    private Expression left;
    private Expression right;

    public BinaryExpression(Token operator, Expression left, Expression right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "(" + this.left.toString() + this.operator.toString() + this.right.toString() + ")";
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
