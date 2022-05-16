package company.behavioral.interpreter;

public class TerminalExpression implements Expression{

    private String text;

    public TerminalExpression(String text) {
        this.text = text;
    }

    @Override
    public boolean interpret(String context) {
        return context.contains(text) ? true : false;
    }
}
