package company.structural.flyweight;

public class Private implements Enemy{

    private String weapon;
    private final String LIFE;

    public Private() {
        this.LIFE = "200";
    }

    @Override
    public void setWeapon(String weapon) {
        this.weapon = weapon;
        System.out.println("El arma es: " + weapon);
    }

    @Override
    public void lifePoints() {
        System.out.println("La vida de un soldado son: " + LIFE);
    }
}
