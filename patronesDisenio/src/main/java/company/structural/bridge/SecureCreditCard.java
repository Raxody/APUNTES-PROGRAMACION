package company.structural.bridge;

public class SecureCreditCard implements ICreditCard{

    @Override
    public void realizarPago() {
        System.out.println("pago realizacion con seguridad");
    }
}
