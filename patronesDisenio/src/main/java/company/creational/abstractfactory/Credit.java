package company.creational.abstractfactory;

public class Credit implements PaymentMethod{
    @Override
    public String doPay() {
        return "Pago a credito";
    }
}
