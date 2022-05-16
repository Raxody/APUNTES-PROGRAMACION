package company.structural.bridge;

public abstract class CreditCard {

    protected ICreditCard tarjeta;

    public CreditCard(ICreditCard tarjeta) {
        this.tarjeta = tarjeta;
    }

    public abstract void realizarPago();

}
