package tinycc.implementation.statement;

import java.util.List;

public class BlockStatement extends Statement {

    private List<Statement> statements;

    public BlockStatement(List<Statement> statements){
        this.statements = statements;
    }

    @Override
    public String toString() {
        String list = "";
        for(int i = 0; i<this.statements.size(); i++){
            list += this.statements.get(i).toString();
        }
        return "{" + list + "}";
    }

    @Override
    public void checkType() {
        for(int i = 0; i<this.statements.size(); i++){
            this.statements.get(i).checkType();;
        }
        
    }

    @Override
    public void genCode() {
        // TODO Auto-generated method stub
        
    }
    
}
