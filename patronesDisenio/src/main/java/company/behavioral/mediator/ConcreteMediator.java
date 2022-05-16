package company.behavioral.mediator;

public class ConcreteMediator implements Mediator{

    private ConcreteColleage1 user1;
    private ConcreteColleague2 user2;

    public void setUser1(ConcreteColleage1 user1) {
        this.user1 = user1;
    }

    public void setUser2(ConcreteColleague2 user2) {
        this.user2 = user2;
    }

    @Override
    public void send(String message, Colleage colleage) {
        if(colleage == user1){
            user2.messageRceived(message);
        }else if(colleage == user2){
            user1.messageRceived(message);
        }
    }
}
