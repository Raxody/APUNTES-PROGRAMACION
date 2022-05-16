package company.structural.decorator;

public class Gold implements Credit{

    @Override
    public void showCredit() {
        System.out.println("El credito es de 50000");
    }

}
