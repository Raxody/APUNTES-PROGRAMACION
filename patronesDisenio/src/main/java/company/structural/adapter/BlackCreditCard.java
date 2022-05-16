package company.structural.adapter;

public class BlackCreditCard implements Secure{

    @Override
    public void payWithSecureLevelA() {
        System.out.println("Tarjeta black: alto nivel de seguridad A");
    }

    @Override
    public void payWithSecureLevelZ() {
        //No implementar
    }

}
