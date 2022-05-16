package company.structural.facade;

public class Black implements Credit{

    @Override
    public void showCredit() {
        System.out.println("La tarjeta black tiene un crédito de 1000000");
    }

}
