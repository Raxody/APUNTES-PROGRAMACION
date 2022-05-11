package company.creational.prototype;

public class Visa implements PrototypeCard{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public PrototypeCard clone() throws CloneNotSupportedException {
        System.out.println("Clonando tarjeta visa ...");
        return (Visa) super.clone();
    }

    @Override
    public void getCard() {
        System.out.println("Esto es una tarjeta visa");
    }
}
