# PracticasJunio

Commit 05/04/2018: Añadido el CSS a todas las páginas. Creado el formulario simple (tanto el html como el servlet) con validaciones en la parte del cliente (sólo los required). Esta funcionalidad simplemente nos devuelve los datos que el usuario introduce en el formulario.
                   
Commit 06/04/2018: Añadido el formulario complejo sin validaciones. Falta implementar la subida de la imagen de avatar de usuario y realizar el formulario complejo con validaciones.

Commit 07/04/2018: Añadido el formulario complejo con validaciones. Validaciones de los campos nombre, teléfono, email y vehículos funcionando correctamente, falta implementar la validacion del campo fecha de nacimiento. También está pendiente la implementación del campo avatar en el formulario complejo sin validaciones.

Commit 08/04/2018: Añadida la validación de la fecha de nacimiento, con lo que doy por concluido el formulario complejo con validaciones. Sigue faltando la implementación del campo avatar en el otro formulario, que no consigo realizarla.

Commit 09/04/2018: Añadida la funcionalidad Ciclo de vida de un Servlet e iniciada la funcionalidad de registro. Sólamente está operativo el formulario html, falta implementar el servlet completo.

Commit 10/04/2018: Añadido el HolaMundo JSP, la funcionalidad saludo que según el sexo y la hora devuelve un saludo diferente, y la funcionalidad calcular edad, que muestra el número de años, meses y días vividos según la fecha de nacimiento introducida.

Commit 12/04/2018: Completada la funcionalidad de registro, pendiente de la solución las siguientes cuestiones:
            
                    - He tenido que hacer que el campo fecha de nacimiento sea required, ya que en caso de dejarlo en blanco al pulsar enviar el programa no mostraba ningún contenido.
                    - La validación de la fecha la he realizado por pattern por falta de tiempo, debo modificarlo.
                    - Las preferencias me causan problemas y según cuáles seleccione desaparecen algunas de ellas y los botones del formulario. Aparentemente para que esto no suceda deben estar seleccionadas las dos últimas   (cine y viajes) o tres, debiendo ser viajes una de ellas. En caso contrario desaparece contenido.
                    - Debo modificar las marcas que indican si el campo ha sido completado correctamente o con errores por algo más visual como imágenes en lugar de párrafos.
                    

Commit 12/04/2018: Añadida la funcionalidad contador de visitas con cookies, con las opciones de borrar la cookie para reiniciar el contador. La primera vez que se visita la página se muestran ciertos atributos de la cookie como el nombre, el tiempo de expiración, la versión o si utiliza un protocolo seguro.