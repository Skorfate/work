Para ejecutar el proyecto lo ideal seria que lo importaran al ide Eclipse


Diccionario de datos
Model:

UnidadValor: Clase la cual guardara los valores de cada entrada valida, nos indicara si
la unidad si es credito con su respectivo valor, o si es una unidad romana

Controladores (delegador,procesoPregunta,ProcesoValor)
Delegador:

esta encargado de destinar la tarea a otros controlares, identifica si la entrada es un valor unico Ejemplo:  "glob is L" o si es una pregunta.


ProcesoPregunta:
Controlador encargado de la logica de pregunta.

ProcesoValor:
Controlador encargado de la logica de entrada de datos.

funciones:
Util:
Contiene varias funcionalidades que se ocupan en los controladores

Enum

Se utilizan 2 enum que se ocupan como constantes

ExprReg: enum que contiene las expresiones regulares
NroRomano: enum que contiene la informacion con respecto a los numeros romanos