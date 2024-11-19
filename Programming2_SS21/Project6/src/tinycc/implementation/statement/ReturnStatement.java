package tinycc.implementation.statement;

import tinycc.implementation.expression.Expression;

public class ReturnStatement extends Statement {

    private Expression expression;

    public ReturnStatement(Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        if (expression == null) {
            return "return;";
        }
        return "return" + this.expression.toString() + ";";
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
