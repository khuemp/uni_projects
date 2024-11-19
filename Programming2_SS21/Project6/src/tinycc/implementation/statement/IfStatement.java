package tinycc.implementation.statement;

import tinycc.implementation.expression.Expression;

public class IfStatement extends Statement {

    private Expression condition;
    private Statement consequence;
    private Statement alternative;

    public IfStatement(Expression condition, Statement consequence, Statement alternative) {
        this.condition = condition;
        this.consequence = consequence;
        this.alternative = alternative;
    }

    @Override
    public String toString() {
        if (alternative == null) {
            return "if(" + this.condition.toString() + ")" + this.consequence.toString();
        }
        return "if(" + this.condition.toString() + ")" + this.consequence.toString() + "else"
                + this.alternative.toString();
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
