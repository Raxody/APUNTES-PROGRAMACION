package company.behavioral.observer;

public class Coche implements Observer{

    @Override
    public void update(Semaforo semaforo) {
        if(semaforo.status.equals("ROJO_COCHE")){
            System.out.println("Semaforo rojo para coche");
        }else{
            System.out.println("Semaforo verde para coche");
        }
    }
}
