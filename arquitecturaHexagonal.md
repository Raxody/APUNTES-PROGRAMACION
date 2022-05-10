dominio    -->    Capa de entidades, dto, servicios y lógica
    vehiculo
        modelo   
            dto
                DtoVehiculo -> es el data object transfer de la base de doGenerateSubmoduleConfigurations
            entidad 
                Vehiculo -> Esta es la entidad normal de Vehiculo
        puerto
            dao 
                DaoVehiculo -> Interface Esta es data access object es un componente que suministra una interfaz comun y en esta interfaz 
                            declararemos el metodo de listar 
            repositorio
                RepositorioVehiculo -> Interface la cual declarara distintos metodos a trabajar
            servicio
                ServicioActualizarVehiculo -> trae el "RepositorioVehiculo" para trabajar sobre el lo nesario para actualizar el vehiculo
                ServicioCrearVehiculo -> trae el "RepositorioVehiculo" para trabajar sobre el lo nesario para crear el vehiculo
                ServicioEliminarVehiculo -> trae el "RepositorioVehiculo" para trabajar sobre el lo nesario para eliminar el vehiculo


aplicacion    -->    Capa de fabrica, manejadores de servicios, comando de la entidad y la consulta 
    vehiculo
        comando   
            fabrica
                @component
                FabricaVehiculo -> crea objetos de tipo vehiculo a partir de los datos que traiga el comandoVehiculo
            manejador 
                ManejadorActualizarVehiculo -> Trae la "fabrica y el servicio de actualiza"r genera lo que necesita el servicio de actualizar 
                                            pero creando con la fabrica del vehiculo                                            
                ManejadorCrearVehiculo ->      Trae la "fabrica y el servicio de crear genera" lo que necesita el servicio de crear pero 
                                               creando con la fabrica el vehiculo
                ManejadorActualizarVehiculo ->  Trae la "fabrica y el servicio de eliminar" genera lo que necesita el servicio de eliminar     
                                                pero creando con la fabrica el vehiculo
            ComandoVehiculo -> genera los mismos atributos que necesita la entidad vehiculo para manejarlos en la fabrica
            consulta
                ManejadorListarVehiculo -> Trae el "DaoVehiculo"y genera lo necesario para listar


infraestructura    -->    capa de configuracion, adaptadores, repositorios y controlador
    configuracion
        @Configuration
        BeanServicio -> Acá se realiza la configuracion las semillas @Bean con los servicios mandandoles como argumentos los repositorios 
    vehiculo
        adaptador   
            dao
                DaoVehiculoMysql -> aca genero la busqueda segun la sentencia que tenga en sql.consultas
                                    y se la mando al "CustomNamedParameterJdbcTemplate" junto al mapeo de la bd
                MapeoVehiculo -> aca mapeo el dto osea lo que recibo de la base de datos generado objetos
                                 de tipo DtoVehiculo segun el numero de filas que hayan en la bd
            repositorio 
                RepositorioVehiculoMysql -> Acá estan todos los otros metodos definidos en el repositoio del 
                                            dominio  y asignandole la sentencia que tenga en sql.consultas
                                            a la par que generando la accion y enviandosela a 
                                            "CustomNamedParameterJdbcTemplate"
        controlador
            ComandoControladorVehiculo -> Se traen los "manejadores de la aplicacion" para realizar los metodos
                                          siendo este nuestro rest controller 
            ComandoControladorVehiculo -> Se trae l "consulta de la aplicacion" para realizar la consulta
                                          siendo este nuestro rest controller de consulta

            
UN COMAND ES UNA MANERA DE DECIR QUE HACES UNA ACCION

¿arquitectura hecagonal?: La forma de crear y estructurar nuestro proyecto
de fuera hacia dentro osea lo que esta adentro no puedo conocer lo que esta afuera
 
 cqrs: (command query responsability segregation) es un patron de arquitectura que separa los modelos para leer y escribir datos en conclusion los permite separar la lectura y la escritura escalandolas de manera 
 independiente

        - query modelo devuelven un estado o consulta sin cambiar el estado del sistema
        - command model cambian el valor del sistema sin devolver un valor

mock mvc: es un servidor web simulado para los test unitarios de los controladores

3a: arrange - organizar : Se organiza y se prepara el sistema o los colaboradores
    act  - actuar: Se ejecuta el metodo o la accion a probar
    assert - verificar: Verificamos que el resultado obtenido sea el resultado que nosotros estamos esperando
    