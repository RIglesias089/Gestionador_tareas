# Gestionador-de-tareas
## Objetivo del proyecto
  Desarrollar una aplicacion gestionadora de tareas y recordatorios colaborativos para distintos 
  tipos de usuarios registrados, que permiten realizar acciones segun el tipo de usuario, esto sera 
  realizado bajo el lenguaje de programacion Java, los conocimientos en POO, patrones de diseño, 
  concurrencias, interfaz grafica con JavaFX y con una conexion a base de datos con postgreSQL.

## Descipción
  La aplicacion que lleva por nombre "Snowlist" busca ser un sistema al estilo de una checklist grupal
  que ayudara a trabajos grupales y individuales, apoyando a los estudiantes y tambien impulsando su 
  modelo de repsonsabilidad y organizacion, incorporando un sistema de recordatorios los cuales ayudaran 
  a los estudiantes o trabajadores junto a nuna interfaz intuitiva la aplicacion buscara ser lo mas amigable
  y funcional posible.

## Funcionalidad del proyecto
  El sistema presentara un sistema de inicio de sesion o "login" para los usuarios una vez isntalada, con eso el 
  usaurio puede elgir si creara una cuenta o si ya tiene una existente iniciar sesion con su correo y contraseña,
  continuara presentando un plan donde el usuario podra elegir si se un usuario clasico o un usuario premium, 
  contando con las siguientes limitantes:

#### Usuario Clasico
  El usuario clasico llevara un plan gratuito con el cual contara con los siguientes Beneficios:
  1. 2 Grupos por cuenta
  2. 3 Integrantes por grupo
  3. Creacion, modificacion y manejo completo de un calendario para sus recordatorios, eventos y tareas a entregar.

#### Usuario Premium
  El usuario premium llevara un plan de pago de $0.99 mensualmente con el cual contrata los siguientes Beneficios:
  1. 6 Grupos por cuenta
  2. Integrantes ilimitados
  3. Creacion, modificacion y manejo completo de un calendario para sus recordatorios, eventos y tareas a entregar.

# Entregable 1

## objetivo de el entregable 1

En este primer entregable se busca entregar una base dle proyecto completo, basado en un sistema gestor de tareas, haciendo uso de datos quemados, que devolveran de manera basica resultados, de igual forma se busca demostrar con el pryecto el progrso de aprendizaje en el lenguaje de Java junto POO.

### 1. Modelado y Estructura Inicial

El sistema se realiza en el lenguaje de Java 17, aplicamos uso de buenas practicas en los commits y manejo de versiones, primero se desarrollo el diagrama UML con el cual el equipo nos guiamos para poder desarrollar proximamente este primer entregable de codigo, gracias a esto nos guiamos en el uso de clases, interfaces, sus atributos, y metodos respectivos.

El proyecto busca reflejar en su codigo lo siguiente:
- Diseño del sistema aplicando **principios de POO**.
- **Diagrama de clases** con:
  - Herencia
  - Polimorfismo
  - Encapsulamiento
  - Abstracción
    
- Uso de **clases abstractas** e **interfaces**.
- **Diagrama de objetos**.
- Implementación inicial en **Java usando Gradle**.
- Ejecución del sistema **en consola**.
- **No incluye interfaz gráfica**.

## Forma de ejecucion
Primero se debera clonar el repositorio actual, se debe ingresar al proyecto desde intellJ IDEA, se debe abrir el proyecto y dejar que el programa inicie correctamente todas las librerias y denmas, a continuacion cargado todo esto, navegara entre los archivos llegando a la ruta "src/main/java" encontrara el archivo main y la carpeta "modelo", entrar al archivo main y ejecutar el programa.

# Entregable 2

## Objetivo de el entregable 2
Buscamos implementar un mayor conocimiento de POO, al momento de hacer uso de los hilos y strategys para poder plantear recordatorios en segundo plano, de momento manejandonos en consola para poder mostrar los mensajes respectivos, de igual forma el equipo continuo con el desarrollo de los diagramas, implmenetando no solo el diagrama UML y el de objetos si no tambien implementando los siguientes diagramas:

  -Diagrama de secuencias
  -Diagrama de Actividades

## En que se diferencia este segundo entregable?
El sistema ahora no se maneja con datos quemados si no que ya solicita al usuario los datos respectivos para poder registrarse y rhacer uso de la interfaz, aunque se mantiene el uso de la interfaz por terminal.

# Entregable 3

## Objetivo de el entregable 3
Terminando el aprendizaje momentaneo en Java y POO, este entregabe tres busca dar ya un salto a la interfaz de usuario, la logica anteriormente programada se mantieen con la diferencia que ahora hacemos uso de JavaFX, para poder moldear una interfaz para le usuario y que este pueda navegar sin problemas.

## Implementacion de JavaFX
JavaFX nos ayuuda a podr implemnetar una interfaz de usuario haciendo uso de un poco de FXML junto con CSS y terminando con la logica de el manejo de el programa con los controller.java, Hacemos uso de este para que el usuario se pueda mover de manera tranquila y organizada

## Implementaciond de una base de datos
De igual manera implementamos una base de datos SQL, especificamente en PostgreSQL, para poder guardar datos de los usuarios registrados y dar un mayor orden y manejo de informacion de los usuarios, todo esto conectado a travez de intelliJ IDEA, cerrando con esto.


