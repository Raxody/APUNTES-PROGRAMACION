package company.creational.prototype;

import java.util.HashMap;
import java.util.Map;

public class PrototypeFactory {

    public static class CartType{

        public static final String VISA= "visa";
        public static final String AMEX = "amex";

    }
    private static Map<String, PrototypeCard> prototypes = new HashMap<>();

    public static PrototypeCard getInstance(final  String tipo) throws CloneNotSupportedException{
        return prototypes.get(tipo).clone();
    }

    public static void loadCard(){
        Visa visa = new Visa();
        visa.setName("Esta tarjeta es de tipo visa con número 0000");
        prototypes.put(CartType.VISA,visa);

        Amex amex = new Amex();
        amex.setName("Esta tarjeta es de tipo amex con número 0000");
        prototypes.put(CartType.AMEX,amex);


    }
}
