package company.behavioral.strategy;

public class Context {

    private StrategyTextFormatter strategyTextFormatter;

    public Context(StrategyTextFormatter strategyTextFormatter) {
        this.strategyTextFormatter = strategyTextFormatter;
    }

    public void publicarText(String text){
        strategyTextFormatter.format(text);

    }
}
