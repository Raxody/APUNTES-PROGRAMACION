package company.behavioral.strategy;

public class LowerStrategyTestFormatter implements StrategyTextFormatter{

    @Override
    public void format(String text) {
        System.out.println("texto en minuscula"+ text.toLowerCase());
    }
}
