package company;

import company.behavioral.interpreter.AndExpression;
import company.behavioral.interpreter.Expression;
import company.behavioral.interpreter.OrExpression;
import company.behavioral.interpreter.TerminalExpression;
import company.behavioral.iterator.CardList;
import company.behavioral.iterator.Iterator;
import company.behavioral.iterator.List;
import company.behavioral.mediator.ConcreteColleage1;
import company.behavioral.mediator.ConcreteColleague2;
import company.behavioral.mediator.ConcreteMediator;
import company.behavioral.memento.Article;
import company.behavioral.memento.ArticleMemento;
import company.behavioral.memento.Carataker;
import company.behavioral.observer.Coche;
import company.behavioral.observer.MessagePublisher;
import company.behavioral.observer.Peaton;
import company.behavioral.observer.Semaforo;
import company.behavioral.state.MobileAlertStateContext;
import company.behavioral.state.Silence;
import company.behavioral.state.Vibration;
import company.behavioral.strategy.CapitalStrategyTextFormatter;
import company.behavioral.strategy.Context;
import company.behavioral.strategy.LowerStrategyTestFormatter;
import company.behavioral.templatemethod.Paypal;
import company.behavioral.templatemethod.Visa;
import company.behavioral.visitor.*;
import company.creational.abstractfactory.AbstractFactory;
import company.creational.abstractfactory.Card;
import company.creational.abstractfactory.FactoryProvider;
import company.creational.abstractfactory.PaymentMethod;
import company.behavioral.chainofresponsability.Tarjeta;
import company.behavioral.command.CreditCard;
import company.behavioral.command.CreditCardActivateCommand;
import company.behavioral.command.CreditCardDesactivateCommand;
import company.behavioral.command.CreditCardInvoker;
import company.creational.factorymethod.Payment;
import company.creational.factorymethod.PaymentFactory;
import company.creational.factorymethod.TypePayment;
import company.creational.prototype.PrototypeCard;
import company.creational.prototype.PrototypeFactory;
import company.structural.bridge.ClassciCreditCard;
import company.structural.bridge.SecureCreditCard;
import company.structural.bridge.UnsecureCreditCard;
import company.structural.composite.CuentaAhorro;
import company.structural.composite.CuentaComponent;
import company.structural.composite.CuentaComposite;
import company.structural.composite.CuentaCorriente;
import company.structural.decorator.*;
import company.structural.facade.CreditMarket;
import company.structural.flyweight.Enemy;
import company.structural.flyweight.EnemyFactory;
import company.structural.proxy.Internet;
import company.structural.proxy.ProxyInternet;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        probarFactoruMethod();
    }

    private static void probarFactoruMethod() {

        //CREACIONALES
        probarFactoryMethod();
        probarAbstractFactory();
        probarBuilder();
        probarPrototype();
        probarSingleton();

        //COMPORTAMIENTO
        probarChainOfResponsability();
        probarCommand();
        probarIterator();
        probarMediator();
        probarMemento();
        probarObserver();
        probarState();
        probarInterpreter();
        probarStrategy();
        probarTemplateMethod();
        probarVisitor();

        //STRUCTURALES
        probarAdapter();
        probarBridge();
        probarComposite();
        probarDecorator();
        probarFacade();
        probarFliweight();
        probarProxy();


    }

    private static void probarProxy(){
        Internet internet = new ProxyInternet();
        try {
            internet.connectTo("udemy.com");
            internet.connectTo("facebook.com");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void probarFliweight(){
        for(int i = 0; i < 15; i++){
            Enemy enemy = EnemyFactory.getEnemy(getRandomEnemyType());
            enemy.setWeapon(getRandomWeapongType());
            enemy.lifePoints();
        }
    }
    private static String getRandomEnemyType(){
        Random r = new Random();
        int randInt = r.nextInt(enemyType.length);
        return enemyType[randInt];
    }

    private static String getRandomWeapongType(){
        Random r = new Random();
        int randInt = r.nextInt(weaponType.length);
        return weaponType[randInt];
    }

    private static String[] enemyType = {"Private", "Detective"};
    private static String[] weaponType = {"Fusil", "Rifle","Revolver","Pistola","Metralleta"};

    private static void probarFacade(){
        CreditMarket creditMarket = new CreditMarket();
        creditMarket.showCreditBlack();
        creditMarket.showCreditGold();
        creditMarket.showCreditSilver();
    }

    private static void probarDecorator(){
        Credit gold = new Gold();
        Credit blackInternationalPayment = new Black();
        blackInternationalPayment = new InternationalPaymentDecorator(blackInternationalPayment);

        Credit goldSecureInternational = new Gold();
        goldSecureInternational = new InternationalPaymentDecorator(goldSecureInternational);
        goldSecureInternational = new SecureDecorator(goldSecureInternational);

        System.out.println("----tarjeta gold con configuracion----" );
        gold.showCredit();

        System.out.println("----tarjeta black con configuracion----" );
        blackInternationalPayment.showCredit();

        System.out.println("----tarjeta gold2 con configuracion----" );
        goldSecureInternational.showCredit();

    }

    private static void probarComposite(){
        CuentaComponent cuentaCorriente = new CuentaCorriente(1000.0, "Juan");

        CuentaComponent cuentaAhorro = new CuentaAhorro(20000.0, "Juan");

        CuentaComposite cuentaComposite = new CuentaComposite();
        cuentaComposite.addCuenta(cuentaCorriente);
        cuentaComposite.addCuenta(cuentaAhorro);

        cuentaComposite.showAccountName();
        System.out.println(cuentaComposite.getAmount());

    }

    private static void probarBridge() {
        company.structural.bridge.CreditCard classic = new ClassciCreditCard(new UnsecureCreditCard());
        classic.realizarPago();

        classic = new ClassciCreditCard(new SecureCreditCard());
        classic.realizarPago();

    }

    private static void probarAdapter() {
        company.structural.adapter.CreditCard creditCard = new company.structural.adapter.CreditCard();
        creditCard.pay("classic");
        creditCard.pay("gold");
        creditCard.pay("black");
        creditCard.pay("silver");

    }

    public static void probarVisitor() {
        OfertaElement ofertaElement = new OfertaGasolina();
        ofertaElement.accept(new BlackCreditCardVisitor());

        ofertaElement = new OfertaVuelos();
        ofertaElement.accept(new ClassicCreditCardVisitor());
    }

    public static void probarTemplateMethod() {
        company.behavioral.templatemethod.Payment payment = new Visa();
        payment.makePayment();

        payment = new Paypal();
        payment.makePayment();
    }

    public static void probarStrategy() {
        Context context = new Context(new CapitalStrategyTextFormatter());
        context.publicarText("juanito alimaña en mayuscula");

        context = new Context(new LowerStrategyTestFormatter());
        context.publicarText("JUANITO ALIMANÑA EN minuscuLas");


    }

    public static void probarInterpreter() {
        Expression cero = new TerminalExpression("0");
        Expression uno = new TerminalExpression("1");

        Expression containBoolean = new OrExpression(cero, uno);
        Expression containsOneAndCero = new AndExpression(cero, uno);

        System.out.println(containBoolean.interpret("cero"));
        System.out.println(containBoolean.interpret("0"));

        System.out.println(containsOneAndCero.interpret("0"));
        System.out.println(containsOneAndCero.interpret("0, 1"));
    }

    private static void probarMediator() {
        ConcreteMediator mediator = new ConcreteMediator();
        ConcreteColleage1 user1 = new ConcreteColleage1(mediator);
        ConcreteColleague2 user2 = new ConcreteColleague2(mediator);

        mediator.setUser1(user1);
        mediator.setUser2(user2);

        user1.send("Hola soy user 1");
        user2.send("Hola user 1 soy user 2");

    }

    private static void probarIterator() {
        company.behavioral.iterator.Card[] cards = new company.behavioral.iterator.Card[5];
        cards[0] = new company.behavioral.iterator.Card("VISA");
        cards[1] = new company.behavioral.iterator.Card("AMEX");
        cards[2] = new company.behavioral.iterator.Card("MASTER CARD");
        cards[3] = new company.behavioral.iterator.Card("GOOGLE CARD");
        cards[4] = new company.behavioral.iterator.Card("APPLE CARD");

        List lista = new CardList(cards);

        Iterator iterator = lista.iterator();

        while (iterator.hasNext()) {
            company.behavioral.iterator.Card tarjeta = (company.behavioral.iterator.Card) iterator.next();
            System.out.println(tarjeta.getType());
        }

    }

    private static void probarState() {
        MobileAlertStateContext context = new MobileAlertStateContext();
        context.alert();
        context.alert();
        context.setCurrentState(new Vibration());
        context.alert();
        context.alert();
        context.setCurrentState(new Silence());
        context.alert();
        context.alert();
    }

    private static void probarCommand() {
        CreditCard creditCard = new CreditCard();
        CreditCard creditCardDesactivate = new CreditCard();
        CreditCardInvoker creditCardInvoker = new CreditCardInvoker();

        creditCardInvoker.setCommand(new CreditCardActivateCommand(creditCard));
        creditCardInvoker.run();
        System.out.println("--------------------------------------");
        creditCardInvoker.setCommand(new CreditCardDesactivateCommand(creditCardDesactivate));
        creditCardInvoker.run();
    }

    private static void probarBuilder() {
        company.creational.builder.Card card = new company.creational.builder.Card.CardBuilder("VISA",
                "0000 00000 0000 S").name("Juanito").build();
        System.out.println(card.toString());
        company.creational.builder.Card card2 = new company.creational.builder.Card.CardBuilder("VISA",
                "0000 00000 0000 S").name("Juanito").credit(true).build();
        System.out.println(card2.toString());
    }


    private static void probarAbstractFactory() {
        AbstractFactory abstractFactory = FactoryProvider.getFactory("Card");
        Card tarjeta = (Card) abstractFactory.create("VISA");
        AbstractFactory abstractFactory1 = FactoryProvider.getFactory("PaymentMethod");
        PaymentMethod paymentMethod = (PaymentMethod) abstractFactory1.create("DEBIT");
        System.out.println("Una tarjeta de tipo" + tarjeta.getCardType()
                + "Con el metodo de pago" + paymentMethod.doPay());

    }

    private static void probarFactoryMethod() {
        Payment payment = PaymentFactory.buildPayment(TypePayment.CARD);
        payment.doPayment();
    }

    private static void probarSingleton() {

        company.creational.singleton.Card.getINSTANCE().setCardNumber("1234-1234-1234-1234");
        System.out.println(company.creational.singleton.Card.getINSTANCE().getCardNumber());
    }

    private static void probarPrototype() {
        PrototypeFactory.loadCard();
        try {
            PrototypeCard visa = PrototypeFactory.getInstance(PrototypeFactory.CartType.VISA);
            visa.getCard();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    private static void probarChainOfResponsability() {
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.creditCardRequest(48000);
    }

    private static void probarMemento() {
        Carataker carataker = new Carataker();
        Article article = new Article("Alberto", "Memento es una pelicula");
        article.setText(article.getText() + " de Nolan");
        System.out.println(article.getText());

        carataker.addMemento(article.createMememnto());
        article.setText(article.getText() + " protagonizada por Guy Pearce");
        System.out.println(article.getText());

        carataker.addMemento(article.createMememnto());

        article.setText(article.getText() + " y Leonardo DiCaprio");
        System.out.println(article.getText());

        ArticleMemento memento1 = carataker.getMemento(0);
        ArticleMemento memento2 = carataker.getMemento(1);

        article.restoreMemento(memento1);
        System.out.println(article.getText());


        article.restoreMemento(memento2);
        System.out.println(article.getText());

        article.setText(article.getText() + " del año ");

    }

    private static void probarObserver() {
        Coche coche = new Coche();
        Peaton peaton = new Peaton();

        MessagePublisher messagePublisher = new MessagePublisher();
        messagePublisher.attach(coche);
        messagePublisher.attach(peaton);

        messagePublisher.notify(new Semaforo("ROJO_COCHE"));
        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }
        messagePublisher.notify(new Semaforo("VERDE_COCHE"));
    }

}
