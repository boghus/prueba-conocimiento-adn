# prueba-conocimiento-adn

Este ejercicio esta desarrolado las siguientes en JAVA 11, con Springboot 2.6.7. usando una base de datos de PostgreSql. Expondiendo un servicio web para determinar si un 
## Funcionamiento

Esta aplicacion esta diseñada para exponer un servicio web, que detecte si una persona tiene diferencias genéticas basándose en su
secuencia de ADN.

El servicio debe de recibir como parámetro un arreglo de Strings que representan cada fila de una matriz (de NxN) con la secuencia del ADN. Las letras de los Strings solo pueden ser:
(A,T,C,G), las cuales representan cada base nitrogenada del ADN.

Sin mutación:
A T G C G A\
C A G T G C\
T T A T T T\
A G A C G G\
G C G T C A\
T C A C T G

Con mutación:
A T G C G A\
C A G T G C\
T T A T G T\
A G A A G G\
C C C C T A\
T C A C T G

Se sabe que existe una mutación si se encuentra más de una secuencia de cuatro letras iguales, de forma oblicua, horizontal o vertical.

## Requerimientos

- Java 11
- Maven 3.6.0
- PostgreSql

## Instalación

1. Clona este repositorio
```
git clone https://github.com/boghus/prueba-conocimiento-adn.git
```

2. Crea la base de datos Postgresql
```
create database dbprueba_adn; 
```

3. Configura tu usuario y contraseña para la base de datos
- Edita el archivo src/main/resources/application.properties
- Introduce los valores de spring.datasource.username y spring.datasource.password con los datos de tu usuario de base de datos PostgreSql

4. Ejecuta la aplicación

Ejecutar el proyecto con java -jar 
 ```
 mvn package
 java -jar -Dspring.profiles.active=test target/com.sprinboot.adn-0.0.1-SNAPSHOT.war
 ```

Como alternativa se puede ejecutar la aplicacion sin empaquetar usando:
  ```
 mvn spring-boot:run 
 ```
La aplicacion debera ejecutarse en la siguiente dirección http://localhost:8080.

## API

### POST mutation
Identifica si el arreglo de Strings contiene mutación 

| Metodo | POST | 
|---|---|
| URL  | "mutation/index", "mutation"  |
| Entrada  | JSON con la estructura dna, y la lista de Strings. Ejemplo {"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]}	|
| Salida  | Si tiene mutación se regresa un codigo 200, si no existe mutacion 403 |
| curl | curl --request POST   --url http://localhost:8080/mutation/index   --header 'Content-Type: application/json'   --data '{ "dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]	}' |

### Get mutation/status
Indica las estadisticas de los mutaciones revisadas

| Metodo | Get | 
|---|---|
| URL  | "mutation/status"  |
| Salida  | Regresa un json con los siguientes parametros, count_mutation: indica la cantidad de pruebas totales que ha tenido mutacion, count_no_mutaions:  indica la cantidad de pruebas totales que NO ha tenido mutacion, ratio: la relacion entre estos dos valores |
| curl | curl --request GET    --url http://localhost:8080/mutation/status  	}' |


