package company.structural.flyweight;

public class Detective implements Enemy {

    private String weapon;
    private final String LIFE;

    public Detective() {
        this.LIFE = "10000";
    }

    @Override
    public void setWeapon(String weapon) {
        this.weapon = weapon;
        System.out.println("El arma es: " + weapon);
    }

    @Override
    public void lifePoints() {
        System.out.println("La vida de un teniente es: " + LIFE);
    }
}
