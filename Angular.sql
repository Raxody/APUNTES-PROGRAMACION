
--Para crear un proyecto  me paro sobre la ruta por cmd y escribo ng new "nombreProyecto"

ng new miPrimerProyecto

-- para abrir el proyecto me paro sobre la ruta del proyecto y escribo code .

code .

-- para correr un proyecto uso

    --Esto corre el servidor y muestra la ruta
    ng serve    

    --Esto corre el servidor y lo abre en el navegador
    ng serve --open           --es con los dos guiones pero aca me lo comentario xd

-- Para detener el servidor espicho varias vecec control + c

control + c 

-- los comandos de crear, construir, testear se encuentran en el package.json ademas de las dependencias

-- segun el package json se van a descargar los node_modules



-- Es una mala practica programar sobre el index.html en un proyecto de angular

-- los componentes de mi app estan en la carpeta app 

-- el archivo .ts es el typescript el cual contiene logica

-- para instalar - instalo bootstrap con 

npm install bootstrap@next

-- Para desinstalar uso

npm uninstall bootstrap

-- busco en el angular json los styles y pongo

"node_modules/bootstrap/dist/css/bootstrap.min.css"
"styles.scss"

-- En el styles.css 

@import '~bootstrap/dist/css/bootstrap.min.css'

-- en el componente en la parte de los import se agrega el onInit y se implementa en la clase para realizar un constructor así se puede visualizar

-- para recorrer la lista que este en el .ty se hace

<ul *ngFor ="let item of amigos">
<li>
Mi amigo se llama: {{item.nombre}} y su edad es {{item.edad}} 
</li>
</ul>

-- para componente visual lo mejor es angular material y se comienza instalando en el cmd así y escojo la primera con si y si

ng add @angular/material
 
-- en los modulos de app. modules.ts importo lo que esta en api del componente que deseo de angular material

import {MatButtonModule} from '@angular/material/button'; -- esto es en la parte de arriba

MatButtonModule -- esto va dentro de la etiqueta @ngModule dentro de los imports

-- para crear componentes se usa:  ng g c "ruta"/"nombreDelComponente"

ng generate component components/navBar

ng g c components/navBar

-- se importan los componentes en el el app que es como el main

import {HeaderComponente} from './components/navbar/navbar.component';

-- para crear un servicio de conectar la api con el front se crea un servicio ng g s  "ruta"/"nombreDelComponente"

ng g s services/personajes 

-- en la clase service.ts se crea el conector 

private API_PERSONAJES= "https://traerUsuarios.com"


-- con el selector

@input 
para enviar un componente

-- jasmine es un framework que ayuda a ejecutar las pruebas de un javascript sin un dom

-- karma es una herramienta que corre todas las pruebas con jasmine 

-- protractor corre las pruebas con jasmine 

-- para las pruebas en el spc.ts 

    -- el describe es la descripcion de la prueba    
    -- el beforeEach es lo que hace antes de cada prueba 
    -- el it es cada prueba unitaria
    -- toBeTruthy es que aparte de true exista   

-- para correr los test de karma uso ng test

-- para correr los test de protractor uso ng e2e

-- async y await son promesas

-- Core: Como angular se trabaja por componentes y en este caso estos van a ser usados en todas las paginas 
    -- pues se trabaja desde acá lo que es en navbar y la toolbar

-- Feature: Acá hay componentes con especialidades especificas 

-- Shared: Acá son componentes compartidos para todos 

--  Los servicios son clases que se encargan de acceder a los datos para entregarlos a los componentes.

-- Guards: Los Guards en Angular, son de alguna manera: middlewares (el que proporciona servicios a las apps ) que se
   --  ejecutan antes de cargar una ruta y determinan si se puede cargar dicha ruta o no.

-- Los pipes se usan para realizar transformaciones de los datos, a la hora de mostrarlos en los templates de los componentes