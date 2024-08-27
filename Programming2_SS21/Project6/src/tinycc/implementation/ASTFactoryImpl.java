package tinycc.implementation;

import java.util.List;

import tinycc.diagnostic.Locatable;
import tinycc.implementation.expression.BinaryExpression;
import tinycc.implementation.expression.CallExpression;
import tinycc.implementation.expression.Expression;
import tinycc.implementation.expression.PrimaryExpression;
import tinycc.implementation.expression.UnaryExpression;
import tinycc.implementation.statement.BlockStatement;
import tinycc.implementation.statement.DeclarationStatement;
import tinycc.implementation.statement.EmptyStatement;
import tinycc.implementation.statement.ErrorStatement;
import tinycc.implementation.statement.ExpressionStatement;
import tinycc.implementation.statement.IfStatement;
import tinycc.implementation.statement.ReturnStatement;
import tinycc.implementation.statement.Statement;
import tinycc.implementation.statement.WhileStatement;
import tinycc.implementation.type.BaseType;
import tinycc.implementation.type.FunctionType;
import tinycc.implementation.type.PointerType;
import tinycc.implementation.type.Type;
import tinycc.parser.ASTFactory;
import tinycc.parser.Token;
import tinycc.parser.TokenKind;

public class ASTFactoryImpl implements ASTFactory {

    public ASTFactoryImpl(){}

    @Override
    public Statement createBlockStatement(Locatable loc, List<Statement> statements) {
        return new BlockStatement(statements);
    }

    @Override
    public Statement createBreakStatement(Locatable loc) {
        return null;
    }

    @Override
    public Statement createContinueStatement(Locatable loc) {
        return null;
    }

    @Override
    public Statement createDeclarationStatement(Type type, Token name, Expression init) {
        return new DeclarationStatement(type, name, init);
    }

    @Override
    public Statement createEmptyStatement(Locatable loc) {
        return new EmptyStatement();
    }

    @Override
    public Statement createErrorStatement(Locatable loc) {
        return new ErrorStatement();
    }

    @Override
    public Statement createExpressionStatement(Locatable loc, Expression expression) {
        return new ExpressionStatement(expression);
    }

    @Override
    public Statement createIfStatement(Locatable loc, Expression condition, Statement consequence,
            Statement alternative) {
        return new IfStatement(condition, consequence, alternative);
    }

    @Override
    public Statement createReturnStatement(Locatable loc, Expression expression) {
        return new ReturnStatement(expression);
    }

    @Override
    public Statement createWhileStatement(Locatable loc, Expression condition, Statement body, Expression invariant,
            Expression term, Token loopBound) {
        return new WhileStatement(condition, body, invariant, term, loopBound);
    }

    @Override
    public Statement createAssumeStatement(Locatable loc, Expression condition) {
        return null;
    }

    @Override
    public Statement createAssertStatement(Locatable loc, Expression condition) {
        return null;
    }

    @Override
    public Type createFunctionType(Type returnType, List<Type> parameters) {
        return new FunctionType(returnType, parameters);
    }

    @Override
    public Type createPointerType(Type pointsTo) {
        return new PointerType(pointsTo);
    }

    @Override
    public Type createBaseType(TokenKind kind) {
        return new BaseType(kind);
    }

    @Override
    public Expression createBinaryExpression(Token operator, Expression left, Expression right) {
        return new BinaryExpression(operator, left, right);
    }

    @Override
    public Expression createCallExpression(Token token, Expression callee, List<Expression> arguments) {
        return new CallExpression(token, callee, arguments);
    }

    @Override
    public Expression createConditionalExpression(Token token, Expression condition, Expression consequence,
            Expression alternative) {
        return null;
    }

    @Override
    public Expression createUnaryExpression(Token operator, boolean postfix, Expression operand) {
        return new UnaryExpression(operator, postfix, operand);
    }

    @Override
    public Expression createPrimaryExpression(Token token) {
        return new PrimaryExpression(token);
    }

    @Override
    public void createExternalDeclaration(Type type, Token name) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void createFunctionDefinition(Type type, Token name, List<Token> parameterNames, Statement body) {
        // TODO Auto-generated method stub
        
    }
    
}
