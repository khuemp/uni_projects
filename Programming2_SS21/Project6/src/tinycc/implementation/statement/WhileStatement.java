package tinycc.implementation.statement;

import tinycc.implementation.expression.Expression;
import tinycc.parser.Token;

public class WhileStatement extends Statement {

    private Expression condition;
    private Statement body;
    private Expression invariant;
    private Expression term;
    private Token loopBound;

    public WhileStatement(Expression condition, Statement body, Expression invariant, Expression term,
            Token loopBound) {
        this.condition = condition;
        this.body = body;
        this.invariant = invariant;
        this.term = term;
        this.loopBound = loopBound;
    }

    @Override
    public String toString() {
        if (invariant == null || term == null || loopBound == null) {
        }
        return "while(" + this.condition.toString() + ")" + this.body.toString();
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
