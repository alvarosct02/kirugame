:declarar variables
set bin=bin2

:Agregar el PATH
SET PATH=%PATH%;D:\Program Files (x86)\Java\jdk1.8.0_60\bin

:Crear directorio para los .class
mkdir %bin%

:Compilar todos los paquetes
javac -d %bin% -sourcepath src src\Main.java

:Crear .jar de Modelo y Controlador
jar cf jarModCont.jar %bin%\Modelo\*.class %bin%\Controlador\*.class

:Crear .jar de Vista usando el jar anterior
jar cfm jarVista.jar manifest.txt %bin%\Vista\*.class

:Limpiar la pantalla
:cls

:Ejecutar el .jar de Vista
java -cp jarVista.jar;%bin%; Main

:Agregar una pausa al final de la ejecucion
pause