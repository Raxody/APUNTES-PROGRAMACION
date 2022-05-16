package company.behavioral.observer;

public interface Subject {

    void attach(Observer observer);
    void dettach(Observer observer);
    void notify(Semaforo semaforo);

}
