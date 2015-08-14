# IWEKS

Proyecto de reconocimiento de voz usando el plugin `TalkingJava SDK` y `JSpeech` para esta tarea y el servicio de traducción de Microsoft (`Microsft Translator`)

## Iniciar la aplicación

* Para iniciar la aplicación necesitas usar el `Java Development Kit 6` (`JDK 6`) ya que este proyecto fue desarrollado y probado con este JDK.
* Agregar los plugins (`.jar`) necesarios para ejecutar el proyecto, los encuentras en la carpeta `dist/lib`.
* Agregar el `dll` necesario para ejecutar `TalkingJava SDK` en la ruta de instalación del JDK según la arquitectura de la computadora (`cgjsapi170.dll` para `32 bits` y `cgjsapi170_x64.dll` para `64 bits`):

    Ejemplo: `C:/Program Files/Java/jdk1.6.0_45/jre/lib/ext`
    
* Agregar los códigos necesarios para ejecutar el servicio de `Microsoft Translator`, para obtener tus claves puedes seguir el siguiente tutorial de Microsoft [Obtener tus Access Tokens](https://msdn.microsoft.com/en-us/library/hh454950.aspx).
* El archivo gramatical detectado por el `SDK` tiene el nombre `grammar.txt` y es libre de modificación siempre y cuando se cumpla la sintaxis de `JSpeech Grammar Format (JSGF)`, puede leer al respecto de este tema en el siguiente enlace: [JSpeech Grammar Format](http://www.w3.org/TR/jsgf/)

Cualquier problema con el código o mejoras son bienvenidas.