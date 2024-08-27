package tinycc.implementation.type;

import java.util.List;

public class FunctionType extends Type {

    private Type returnType;
    private List<Type> parameters;

    public FunctionType(Type returnType, List<Type> parameters) {
        this.returnType = returnType;
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        String list = "";
        for (int i = 0; i < this.parameters.size(); i++) {
            if (i < this.parameters.size() - 1) {
                list += this.parameters.get(i).toString() + ",";
            } else {
                list += this.parameters.get(i).toString();
            }
        }
        return this.returnType.toString() + "(" + list + ")";
    }

}
