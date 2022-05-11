package company.creational.abstractfactory;

public class Debit implements PaymentMethod{
    @Override
    public String doPay() {
        return "Pago a debito";
    }
}
