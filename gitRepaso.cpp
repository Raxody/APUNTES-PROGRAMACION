git// Para mirar la ruta sobre la cual se esta trabajando uso 

gwd

// Revisar si esta instalado con 

git --version

// Comandos para guardar informacion personal antes de iniciar

git config --global user.name "JuanLopez"

git config --global user.email juancho_lopez6@hotmail.com

// Para ver elementos ocultos de una carpeta o en general todos 

ls -la

/*                                      PASOS                               */

// 1. Para comenzar voy a la ruta donde este el proyecto, se puede ir a la carpeta darle click derecho y Git Bush here
// 2. para inicializar el proyecto le doy e inicializa una rama master

git init 

// 3. Pasa saber  el estado del proyecto uso

git status

// 4. Para darle seguimiento a un archivo se usa git add "nombreproyecto.extension"

git add autobiografia.txt

// 4.1 Para agregar todos los archivos y no hacerlo 1 por 1 se una es 

git add . 

// 5. Para generar commits se usa git commit -m "Mensaje" y esto se hace para ir generando copias con su respectiva versión

git commit -m "Esta biografia es una prueba"

// 6. Repetir desde el paso 3 cada que se vaya a hacer un commit 

        //EXCEPTO CUANDO YA SE HIZO UN ADD Y UN COMMIT PORQUE AHI SE PUEDE USAR git commit -am "nombre del commit"
        
        git commit -am "Agregadas las dos al tiempo"

// 7. Se envia a la rama que se desee del Git git push origin "rama"

        git push origin master

//Siempre va a estar el HEAD en la version más actualizada, para ver las versiones uso

git log --oneline 

// Para devolverse entre versiones se debe usar el git checkout "direccion o id con el comando anterior" 

git ckeckout d2972c8

// si se quiere volver a la rama master osea donde esta el HEAD se usa

git ckeckout master

// Para mirar el autor que hizo el commit se usa

git log

// Para mirar los cambios que se hicieron se usa osea cambios entre commits

git show 

// si por ejemplo hay una copia que esta mal y se quiere devolver a una copia eliminando lo que haya en las que estan despues de esta se usa
// git reset "id del commit " --hard                esto tiene mucho poder 

git reset 6069064 --hard


// Para mirar las ramas de mi proyecto uso 

git branch 

 // Para crear una nueva rama se usa git branch "nombre rama" y esta genera una copia exacta de donde este el HEAD

 git branch nuevaBiografia


 // Para pasar a otra rama se usa git checkout "nombre rama" porque también es una version

 git checkout nuevaBiografia

 // Normalmente cuando se crea la otra rama es para hacer pruebas o ensayos entonces cuando ya se llega a lo que se quiere se suele llevar a la
 // rama master entonces primero nos paramos sobre la master

        git checkout master
        
// Para despues utilizar el git merge " nombre de la rama que quiero devolver a la master"

git merge nuevaBiografia


// Si se hace doble commit osea otra persona lo hace lo más seguro es que se revise que se ha hecho y se elija uno de los dos

  /*----------------------------------------------------------------------------------------------------------*/


  // Para trabajarlo como debe ser desde el repositorio se abre el GitHub y se siguen mas que todo los pasos de alla

  // 1. creo un repositorio colocando nombre del mismo y descripcion

  // Para enlazar el codigo uso la linea de comando que me da el repositorio de GitHub que dice más o menos algo asi

  git remote add origin https://github.com/Raxody/ParqueaderoHilos.git

  // Para validar si esta conectado o a que repositorio esta apuntando se usa 

  git remote -v

  // esto envia un commit o una version al repositorio 

  git push -u origin master

 // Para guardar un repositorio de git al pc osea descargarlo uso git clone "link que da el github" "nombre a guardar"

 git clone https://github.com/Raxody/ParqueaderoHilos.git pruebaQueSirve

 // Para traer la ultima version de una rama determinada uso el Git pull origin master 

 Git pull origin master 


 //Cuando no se quiere hacer una sobrecarga masiva de esas que se instalan solas se usa git ignore
 // entonces en la carpeta del proyecto se crea un .git ignore y dentro de el se pone el nombre de los archivos que no
 // se van a usar

 // se puede poner un tag que es como el indicador de que version se esta trabajando
 // git tag -a "numero version" -m "descripcion" "la direccion del commit"

 git tag -a v0.1 -m "mi primera version estable" d2972c8

 // para  saber a que commit se le hizo el tag se usa

 git show-ref --tags

 // Para enviar los tags se usa

 git push origin --tags

// para eliminar un tag de git se usa  git tag -d "nombre versiones"

 git tag -d v0.2

 // para eliminar un tag de github se usa git push origin: refs/tags/"nombre tag"

 git push origin: refs/tags/v0.2

 // Para usar un readme.md es como una presentacion del codigo   primero lo creo con el touch

 touch readme.md 

// Procurar no usar esto pero con el gitk se puede ver todo

gitk