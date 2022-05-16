package company.structural.bridge;

public class UnsecureCreditCard implements ICreditCard{

    @Override
    public void realizarPago() {
        System.out.println("Pago realizado sin seguridad");
    }
}
