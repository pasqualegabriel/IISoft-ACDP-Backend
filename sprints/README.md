# Caso de uso

Nombre: Dar de alta un usuario

Actor: Admin

Descripción: El Admin da de alta un usuario. El sistema lo registra o indica error en caso que no confirme correctamente la contraseña, que el username o email existan, y que los campos del formulario no esten vacios. Una vez dado de alta, un usuario puede conectarse.

Precondición: El admin tiene que estar logueado.

Poscondición: Ninguna.

Flujo Principal:

1 - Usuario: Llena los campos.
2 - Sistema: verifica los campos.
3 - Usuario: Da la confirmación de alta.
4 - Sistema: Registra al nuevo usuario.

Flujo alternativo: 

2a – campos incorrectos sistema tira una alerta y cancela boton aceptación.

