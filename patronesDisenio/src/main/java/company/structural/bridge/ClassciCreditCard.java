package company.structural.bridge;

public class ClassciCreditCard extends CreditCard{


    public ClassciCreditCard(ICreditCard tarjeta) {
        super(tarjeta);
    }

    @Override
    public void realizarPago() {
        tarjeta.realizarPago();
    }
}
