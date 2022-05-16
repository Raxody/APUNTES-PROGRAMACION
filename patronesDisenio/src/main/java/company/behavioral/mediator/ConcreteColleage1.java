package company.behavioral.mediator;

public class ConcreteColleage1 extends Colleage{

    public ConcreteColleage1(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void send(String message) {
    mediator.send(message,this);
    }

    @Override
    public void messageRceived(String message) {
        System.out.println("el colega 1 ha recibido el siguente mensaje del chat"+ message);
    }
}
