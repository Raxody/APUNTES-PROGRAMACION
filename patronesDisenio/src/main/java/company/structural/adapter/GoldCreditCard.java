package company.structural.adapter;

public class GoldCreditCard implements Secure{

    @Override
    public void payWithSecureLevelA() {
        //No implementar
    }

    @Override
    public void payWithSecureLevelZ() {
        System.out.println("Tarjeta gold: bajo nivel de seguridad z");
    }
}
