import java.util.Collection;
import java.util.Collections;
import java.util.List;

///

public class Comensal{

    String nombre;
    double montoPedido;
    int mesa;

    public Comensal(String nombre, double montoPedido, int mesa) {
        this.nombre = nombre;
        this.montoPedido = montoPedido;
        this.mesa = mesa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMontoPedido() {
        return montoPedido;
    }

    public void setMontoPedido(double montoPedido) {
        this.montoPedido = montoPedido;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    @Override
    public String toString() {
             return   "nombre='" + nombre + '\'' +
                ", montoPedido=" + montoPedido +
                ", mesa=" + mesa ;
    }
    
}


//

public class Filtro {

    public List<Comensal> validadorPredicate(List<Comensal> listaComensal, Predicate<Comensal> evaluadorComensal) {
        List<Comensal> listaComensales = new ArrayList<>();
        for (Comensal comensal : listaComensal) {
            if (evaluadorComensal.test(comensal)) {
                listaComensales.add(comensal);
            }
        }
        return listaComensales;
    }

    public void validadorConsumer(List<Comensal> listaComensal, Consumer<Comensal> consumerComensal) {
        listaComensal.forEach(comensal -> consumerComensal.accept(comensal));

    }
}


public class main {

//// Hay distintas interfaces, pero con predicate puedo testear si algo es verdadero o no, que seria en este caso
// algo así y la cosa es que tira true si la condicion se cumple
    public static void main1(String[] args) {

        System.out.println(convertidor.apply(30).length());
        List<Comensal> listaComensales = Arrays.asList(
                new Comensal("Juan", 5000.5, 3),
                new Comensal("Andres", 7000.5, 1),
                new Comensal("Lopez", 4000.5, 2),
                new Comensal("Avila", 5004, 6),
                new Comensal("Sofia", 88000.5, 4),
                new Comensal("Tatiana", 65000.5, 5));
        Filtro filtro = new Filtro();

        List<Comensal> comensalesBuenPedido = filtro.validadorPredicate(listaComensales,
                comensal -> comensal.getMontoPedido() >= 8000);

        comensalesBuenPedido.forEach(comensal -> System.out.println(comensal.toString()));

        System.out.println("////////////////////////////////////////");

        List<Comensal> comensalesTacaniosPedido = filtro.validadorPredicate(listaComensales,
                comensal -> comensal.getMontoPedido() < 8000 || comensal.getMontoPedido() >= 8000);
                
        comensalesTacaniosPedido.forEach(comensal -> System.out.println(comensal.toString()));

    }
// Aca trabajo una interface Consumer que esta puede hacer todo lo que se le diga, ya sea cambiar valores,
// pensar si se cumple si no
    public static void main2(String[] args) {

        List<Comensal> listaComensales = Arrays.asList(
                new Comensal("Juan", 5000.5, 3),
                new Comensal("Andres", 7000.5, 1),
                new Comensal("Lopez", 4000.5, 2),
                new Comensal("Avila", 5004, 6),
                new Comensal("Sofia", 88000.5, 4),
                new Comensal("Tatiana", 65000.5, 5));
        Filtro filtro = new Filtro();

        filtro.validadorConsumer(listaComensales, comensal -> System.out.println(comensal.toString()));

        filtro.validadorConsumer(listaComensales, comensal -> comensal.setNombre(comensal.getNombre()+"2"));

        filtro.validadorConsumer(listaComensales, comensal -> System.out.println(comensal.toString()));


    }

    // Para ordenamientos se usa así: 

    public static void main3(String[] args) {


        List<Comensal> listaComensales = Arrays.asList(
                new Comensal("Juan", 5000.5, 3),
                new Comensal("Andres", 7000.5, 1),
                new Comensal("Lopez", 4000.5, 2),
                new Comensal("Avila", 5004, 6),
                new Comensal("Sofia", 88000.5, 4),
                new Comensal("Tatiana", 65000.5, 5));
        
           // Comparar por Strings

         Collections.sort(listaComensales, Comparator.comparing(Comensal::getNombre));

           // tambien para organizar pero por un valor se puede usar con Comparator.comparing 
           // así y de paso revertir la lista con reversed

           Collections.sort(listaComensales, Comparator.comparingDouble(Comensal::getMontoPedido).reversed());

        // y si se va a organizar por "ids" osea enteros se puede con: 

        Collections.sort(listaComensales, Comparator.comparingInt(Comensal::getMesa));

        // y se imprime en cualquiera de los casos

        listaComensales.forEach(comensal -> System.out.println(comensal.toString()));
    }

//Para realizar un acomulador de un filtrado uso sum() 

    public static void main4(String[] args) {

        List<Comensal> listaComensales = Arrays.asList(
                new Comensal("Juan", 5000.5, 3),
                new Comensal("Andres", 7000.5, 1),
                new Comensal("Lopez", 4000.5, 2),
                new Comensal("Avila", 5004, 6),
                new Comensal("Sofia", 88000.5, 4),
                new Comensal("Tatiana", 65000.5, 5));
        
    // primero se filtra lo que se necesita y con map decimos sobre que variable se hara enfasis
    // para luego con el metodo sum() realizar la suma de todos

    listaComensales.stream().filter(comensal -> comensal.getMontoPedido() > 2000)
    .mapToDouble(comensal -> comensal.getMontoPedido()).sum();

    //primero se filtra lo que se necesita para luego con el metodo count() saber la cantidad de incidencias
    
    listaComensales.stream().filter(comensal -> comensal.getMontoPedido() > 2000).count();


    }

    //Para ordenamiento con streams uso sorted()

    public static void main5(String[] args) {

        List<Comensal> listaComensales = Arrays.asList(
                new Comensal("Juan", 5000.5, 3),
                new Comensal("Andres", 7000.5, 1),
                new Comensal("Lopez", 4000.5, 2),
                new Comensal("Avila", 5004, 6),
                new Comensal("Sofia", 88000.5, 4),
                new Comensal("Tatiana", 65000.5, 5));
        
    // Genero el stream, filtro sobre que variable hare enfasis, con el sorted() lo ordeno y lo muestro

    listaComensales.stream()
    .map(comensal -> comensal.getNombre())
    .sorted()
    .forEach(System.out::println);

    // Genero el stream, filtro sobre que variable hare enfasis, con el sorted() lo ordeno a la par que
    // le mando como argumento una sentencia del comparator con una nueva instruccion, en este caso
    // que lo invierta y lo muestro
    
    listaComensales.stream()
    .map(comensal -> comensal.getMontoPedido())
    .sorted(Comparator.reverseOrder())
    .forEach(System.out::println);


    }


       //Para saber maximos, minimos, promedios y todas las estadisticas con 
       // max(), min(),  average(), summaryOperator()

       public static void main6(String[] args) {

        List<Comensal> listaComensales = Arrays.asList(
                new Comensal("Juan", 5000.5, 3),
                new Comensal("Andres", 7000.5, 1),
                new Comensal("Lopez", 4000.5, 2),
                new Comensal("Avila", 5004, 6),
                new Comensal("Sofia", 88000.5, 4),
                new Comensal("Tatiana", 65000.5, 5));
        
        // para saber el minimo se puedo mapeando el stream sacandole el minimo y mapear de nuevo el 
        // resultado

        listaComensales.stream()
                .mapToDouble(Comensal::getMontoPedido)
                .min()
                .stream()
                .forEach(System.out::println);        

        // A la par que se puede solo sacar el stream, tomar el maximo usando como referencia el 
        // comparator con el argumento deseado y mostrandolo

        listaComensales.stream()
                .max(Comparator.comparingDouble(Comensal::getMontoPedido))
                .stream()
                .forEach(System.out::println);

        //Para sacar el promedio uso el average()

        OptionalDouble sumaaaa = listaComensales.stream()
                .mapToDouble(Comensal::getMontoPedido)
                .average();                

        List<Integer> numeros2 = Arrays.asList(1,2,3,4,5,67,8,4,3);

        numeros2.stream()
                .mapToInt(Integer::intValue)
                .average()
                .stream()
                .forEach(System.out::println); 
                
                
        // para mirar todas las estadisticas es con summaryOperator()

        System.out.println(listaComensales.stream()
                                          .mapToDouble(Comensal::getMontoPedido)
                                          .summaryStatistics());

            
         // para mirar una estadistica en concreto de todas las calculadas es con: 
                                                   
        System.out.println(listaComensales.stream()
                                          .mapToDouble(Comensal::getMontoPedido)
                                          .summaryStatistics().getMax());                                 


    }

// Para utilizar el operador ternario se hace así:


    public String  pruebaTermario(int numero){
    // maneja la estructura (condicion) ? resultado si es true : resultado si es false;
        return (numero > 10) ? "Numero mayor de 10" : "Numero menor de 10";
    }

    public static void main8(String[] args) {   
    
    boolean validador= true;
    
    // maneja la estructura (condicion) ? resultado si es true : resultado si es false;
    int numero = (validador) ? 7 : 12;

    main objMain = new main();

    System.out.println(objMain.pruebaTermario(25));
    System.out.println(objMain.pruebaTermario(7));
    }



}


