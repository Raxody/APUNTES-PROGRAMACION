package company.behavioral.templatemethod;

public class Paypal extends Payment{

    @Override
    void initialize() {
        System.out.println("Inicializamos el pago con Paypal");
    }

    @Override
    void startPayment() {
        System.out.println("Realizando el pago con Paypal");
    }

    @Override
    void endPayment() {
        System.out.println("Finalizado el pago a traves de los servidores de Paypal");
    }
}
