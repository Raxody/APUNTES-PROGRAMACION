
/* TODOS LOS PATRONES DE DISEÑO EN SU PARTE TEORIA BUSQUELOS EN GURU: https://refactoring.guru/
      y los ejemplos de como se puede aplicar los tiene en su git*/


///////////////////////////////////////////PATRONES CREACIONALES///////////////////////////////////////////////

/* Factory Method define un método, que debe usarse para crear objetos en lugar de una 
llamada directa al constructor ( newoperador). Las subclases pueden anular este método para cambiar 
la clase de objetos que se crearán.*/


/*Abstract Factory define una interfaz para crear todos los productos distintos, pero deja la creación
real del producto a clases de fábrica concretas. Cada tipo de fábrica corresponde a una determinada 
variedad de productos..*/

/* El patrón Builder es un patrón bien conocido en el mundo de Java. Es especialmente útil cuando 
necesita crear un objeto con muchas opciones de configuración posibles.*/

/* Prototype es un patrón de diseño creacional que le permite copiar objetos existentes sin hacer 
que su código dependa de sus clases.*/


///////////////////////////////////////////PATRONES DE COMPORTAMIENTO///////////////////////////////////////////////

/*La chain of responsability es un patrón de diseño de comportamiento que le permite pasar solicitudes 
a lo largo de una cadena de controladores. Al recibir una solicitud, cada controlador decide procesarla
 o pasarla al siguiente controlador de la cadena. */

 /*El comando es un patrón de diseño de comportamiento que convierte una solicitud en un objeto independiente 
 que contiene toda la información sobre la solicitud. Esta transformación le permite pasar solicitudes como
  argumentos de método, retrasar o poner en cola la ejecución de una solicitud y admitir operaciones que se
  pueden deshacer. */

/*Iterator es un patrón de diseño de comportamiento que le permite recorrer elementos de una colección sin
 exponer su representación subyacente (lista, pila, árbol, etc.). Aunque este ya lo implementa java con las List
 así que no es necesario usarlo*/

 /*Mediator es un patrón de diseño de comportamiento que le permite reducir las dependencias caóticas entre
  objetos. El patrón restringe las comunicaciones directas entre los objetos y los obliga a colaborar solo
   a través de un objeto mediador.*/

/*Observer es un patrón de diseño de comportamiento que le permite definir un mecanismo de suscripción
 para notificar a varios objetos sobre cualquier evento que le suceda al objeto que están observando. */ 
 
 /* State es un patrón de diseño de comportamiento que permite a un objeto alterar su comportamiento
  cuando su estado interno cambia. Parece como si el objeto cambiara su clase.*/

  /* El patron interpreter es validar con ifs practicamente condiciones booleanas esta feo y no lo 
  pienso usar  */

  /* El patron estrategy  es un patrón de diseño de comportamiento que le permite definir una familia de
  algoritmos, colocar cada uno de ellos en una clase separada y hacer que sus objetos sean 
  intercambiables. */

  /* Template Method es un patrón de diseño de comportamiento que define el esqueleto de un algoritmo
   en la superclase pero permite que las subclases anulen pasos específicos del algoritmo sin cambiar 
   su estructura.*/


   /*Visitor es un patrón de diseño de comportamiento que le permite separar los algoritmos de los
    objetos en los que operan super bacano como se distribuye segun las interfaces generando objetos
    que trabajan o apuntan sobre ellos */

///////////////////////////////////////// PATRONES ESTRUCTURALES //////////////////////////////////////////

    /*El adapter es un patrón de diseño estructural que permite la colaboración de objetos con 
    interfaces incompatibles. */

    /*Bridge es un patrón de diseño estructural que le permite dividir una clase grande o un conjunto 
    de clases estrechamente relacionadas en dos jerarquías separadas, abstracción e implementación, 
    que se pueden desarrollar de forma independiente. */

    /*Composite es un patrón de diseño estructural que le permite componer objetos en estructuras de 
    árbol y luego trabajar con estas estructuras como si fueran objetos individuales. */

    /* Decorator es un patrón de diseño estructural que le permite adjuntar nuevos comportamientos 
    a los objetos colocando estos objetos dentro de objetos envolventes especiales que contienen 
    los comportamientos. */

    /*Facade es un patrón de diseño estructural que proporciona una interfaz simplificada para
     una biblioteca, un marco o cualquier otro conjunto complejo de clases.*/

     /*Proxy es un patrón de diseño estructural que le permite proporcionar un sustituto o marcador
      de posición para otro objeto. Un proxy controla el acceso al objeto original, lo que le permite 
      realizar algo antes o después de que la solicitud llegue al objeto original. */


      
