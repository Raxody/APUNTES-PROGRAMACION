package company.behavioral.state;

public class Silence implements MobileAlertState{


    @Override
    public void alert(MobileAlertStateContext context) {
        System.out.println("Silencio...Pantallla Iluminada...");
    }


}
