package tinycc.implementation.statement;

public class EmptyStatement extends Statement {

    public EmptyStatement(){}

    @Override
    public String toString() {
        return ";";
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
