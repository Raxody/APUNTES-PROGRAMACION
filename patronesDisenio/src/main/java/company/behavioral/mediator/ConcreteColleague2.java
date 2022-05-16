package company.behavioral.mediator;

public class ConcreteColleague2  extends Colleage{

    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void send(String message) {
        mediator.send(message,this);
    }

    @Override
    public void messageRceived(String message) {
        System.out.println("el colega 2 ha recibido el siguente mensaje del chat"+ message);
    }
}
