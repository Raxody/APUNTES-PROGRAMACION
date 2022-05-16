package company.structural.facade;

public class Silver implements Credit{

    @Override
    public void showCredit() {
        System.out.println("La tarjeta silver tiene un crédito de 200000");
    }

}
