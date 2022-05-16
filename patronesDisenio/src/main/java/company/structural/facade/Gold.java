package company.structural.facade;

public class Gold implements Credit{

    @Override
    public void showCredit() {
        System.out.println("La tarjeta gold tiene un crédito de 5000");
    }
}
