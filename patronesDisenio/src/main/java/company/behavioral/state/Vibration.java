package company.behavioral.state;

public class Vibration implements  MobileAlertState{

    @Override
    public void alert(MobileAlertStateContext context) {
        System.out.println("Vibrando...");
    }
}
