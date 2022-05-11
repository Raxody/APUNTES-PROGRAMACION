package company;

import company.creational.abstractfactory.AbstractFactory;
import company.creational.abstractfactory.Card;
import company.creational.abstractfactory.FactoryProvider;
import company.creational.abstractfactory.PaymentMethod;
import company.creational.factorymethod.Payment;
import company.creational.factorymethod.PaymentFactory;
import company.creational.factorymethod.TypePayment;
import company.creational.prototype.PrototypeCard;
import company.creational.prototype.PrototypeFactory;

public class Main {
    public static void main(String[] args) {
    probarFactoruMethod();
    }

    private static void probarFactoruMethod(){
        Payment payment = PaymentFactory.buildPayment(TypePayment.CARD);
        payment.doPayment();
        probarAbstractFactory();
        probarBuilder();
        probarPrototype();
    }

    private static void probarBuilder(){
        company.creational.builder.Card card = new company.creational.builder.Card.CardBuilder("VISA",
                "0000 00000 0000 S").name("Juanito").build();
        System.out.println(card.toString());
        company.creational.builder.Card card2 = new company.creational.builder.Card.CardBuilder("VISA",
                "0000 00000 0000 S").name("Juanito").credit(true).build();
        System.out.println(card2.toString());
    }


    private static void probarAbstractFactory(){
        AbstractFactory abstractFactory = FactoryProvider.getFactory("Card");
        Card tarjeta = (Card) abstractFactory.create("VISA");
        AbstractFactory abstractFactory1 = FactoryProvider.getFactory("PaymentMethod");
        PaymentMethod paymentMethod = (PaymentMethod) abstractFactory1.create("DEBIT");
        System.out.println("Una tarjeta de tipo" + tarjeta.getCardType()
                + "Con el metodo de pago" + paymentMethod.doPay());

    }

    private static void probarPrototype(){
        PrototypeFactory.loadCard();
        try{
            PrototypeCard visa = PrototypeFactory.getInstance(PrototypeFactory.CartType.VISA);
            visa.getCard();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
    }
}
