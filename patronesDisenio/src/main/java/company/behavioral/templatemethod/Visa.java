package company.behavioral.templatemethod;

public class Visa extends Payment{

    @Override
    void initialize() {
        System.out.println("Inicializamos el pago con Visa");
    }

    @Override
    void startPayment() {
        System.out.println("Realizando el pago con Visa");
    }

    @Override
    void endPayment() {
        System.out.println("Finalizado el pago a traves de los servidores de Visa");
    }
}
