package tinycc.implementation.statement;

import tinycc.implementation.expression.Expression;

public class ExpressionStatement extends Statement {

    private Expression expression;

    public ExpressionStatement(Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return this.expression.toString() + ";";
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
