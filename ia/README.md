# Connect4

- Enunciado:
* Modificar el código dado para que en vez de jugadores aleatorios complementarios a los usuarios, sean jugadores aleatorios tramposos
** En su turno, buscan una columna aleatoria con tope del color opuesto
** Se lleva la ficha a otra columna
** Pone una ficha suya 

- Solución:
* Añadir
** nueva clase TrickyRandomMachinePlayer, derivada de RandomMachinePlayer
** añadir 5 métodos a clase Board 
* Diagrama en src/docs/design.svg