package company.behavioral.visitor;

public class BlackCreditCardVisitor implements CreditCardVisitor{

    @Override
    public void ofertaGasolina(OfertaGasolina ofertaGasolina) {
        System.out.println("Descuento del 10% en gasoliina con tu tarjeta black");
    }

    @Override
    public void ofertaVuelos(OfertaVuelos ofertaVuelos) {
        System.out.println("Descuento del 25% en gasoliina con tu tarjeta black");
    }
}
