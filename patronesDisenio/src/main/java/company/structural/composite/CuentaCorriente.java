package company.structural.composite;

public class CuentaCorriente implements CuentaComponent{
    private  Double amount;
    private String name;

    public CuentaCorriente(Double amount, String name) {
        this.amount = amount;
        this.name = name;
    }

    @Override
    public void showAccountName() {
        System.out.println("Cuenta corriente: " + name);
    }

    @Override
    public Double getAmount() {
        return amount;
    }
}