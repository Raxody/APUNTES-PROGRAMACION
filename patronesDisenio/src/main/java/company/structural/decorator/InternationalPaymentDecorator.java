package company.structural.decorator;

public class InternationalPaymentDecorator extends CreditDecorator{


    public InternationalPaymentDecorator(Credit decoratedCredit) {
        super(decoratedCredit);
    }

    @Override
    public void showCredit() {
        decoratedCredit.showCredit();
        configInternationalPayment();

    }

    private void configInternationalPayment(){
        System.out.println("La tarjeta ha sidoconfigurada para hacer pagos internacionales");
    }
}
