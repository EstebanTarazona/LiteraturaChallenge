# Proyecto de Literatura Challenge

## Índice

1. [Introducción](#introducción)
2. [Características](#características)
3. [Instalación](#instalación)
4. [Uso](#uso)
5. [Contribuciones](#contribuciones)
6. [Agradecimientos](#agradecimientos)

## Introducción

En este proyecto, un desafio de la academia alura se busco desarrollar un Catálogo de Libros que ofrezca interacción textual (vía consola) con los usuarios, proporcionando al menos 5 opciones de interacción. Los libros se buscarán a través de una API específica.

## Características

 - Buscar libros por titulo
 - Mostrar todos los libros
 - Mostrar por autores
 - Mostrar por autores en la epoca que se publicaron
 - Mostrar libros por idiomas

## Instalación

Para instalar el proyecto, sigue estos pasos:

1. Clona el repositorio: `git clone https://github.com/usuario/LiteraturaChallenge.git`
2. Navega al directorio del proyecto: `cd LiteraturaChallenge`
3. Luego habre el archivo
4. solo debemos hacer un paso para iniciarlo correctamente
   
   4.1 Debes tener instalado postgres o en su lugar algun gestor de bases de datos relacionales
   
   4.2 En el archivo application.properties debes poner TU nombre de usuario registrado en la base de datos y la contraseña
   
   ![image](https://github.com/user-attachments/assets/93628f8a-04d4-4171-9fb9-ae8d7dcc45ae)
    
6. Luego deberia correr sin ningun problema
   
## Uso

Para iniciar el proyecto, corre el proyecto:

vas a ver un menu bastante sencillo

![image](https://github.com/user-attachments/assets/118b1405-e8b5-4535-8692-28a8760ef726)

La primera opcion te pide buscar un libro para añadirlo a la base de datos
  - En este ejemplo vamos a buscar un libro por la palabra odio

![image](https://github.com/user-attachments/assets/951799fe-a3a5-48e5-ad58-2e00f40eb55d)

  - se puede observar que elegimos la opcion uno, luego nos encontro un libro y nos dio los datos de titulo, autor, fecha de nacimiento, 
   idioma y descargas totales con un mensaje de guardado con exito

  - la segunda opcion es igual de sencilla, escribe 2 y visualiza los libros que has añadido

![image](https://github.com/user-attachments/assets/6cb27ea2-c133-4d21-bf5e-17f752d0f618)

  - la tercera opcion sigue siendo igual de sencilla, mira que autores has guardado en tu base de datos

![image](https://github.com/user-attachments/assets/674af5e6-e501-4735-a770-c630cdfbf702)

  - La cuarta opcion cambia un poco, vamos a buscar autores por fecha de nacimiento y nos deberia mostrar los libros de ese autor que estan guardados en nuestra base de datos

![image](https://github.com/user-attachments/assets/f3f98823-9f30-407d-be55-bae1cef57e7c)

  - la ultima pero no la más aburrida nos va a mostrar los libros que esten escritos en un idioma en especifico

![image](https://github.com/user-attachments/assets/28d6605b-7d4a-4bfa-98cf-2255c7952a03)

## Contribuciones
Si deseas contribuir a este proyecto, por favor sigue estos pasos:

Haz un fork del repositorio
Crea una rama para tu feature: `git checkout -b mi-feature`
Haz commit de tus cambios: `git commit -m 'Añadir mi feature`
Empuja tu rama: `git push origin mi-feature`
Abre un Pull Request


## Agradecimientos

- Un eterno agradecimeinto a Alura y a los profesores que hicieron posible todos mis avances con Spring.
- Un agradecimiento a gutendex por proporcionar la API que permitio realizar este trabajo.

