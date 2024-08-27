package tinycc.implementation.statement;

public class ErrorStatement extends Statement {

    public ErrorStatement(){}

    @Override
    public String toString() {
        return "Syntax error";
    }

    @Override
    public void checkType() {
        // Immer wohlgetypt
    }

    @Override
    public void genCode() {
    }
    
}
