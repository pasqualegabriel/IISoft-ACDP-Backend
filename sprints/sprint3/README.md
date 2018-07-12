# Iteración 3

## Investigaciones

### Grails

Para correr la aplicación (en este caso la api) desde la terminal se utiliza el siguiente comando:
$ grails run-app
Para correr los tests desde la terminal se utiliza el siguiente comando:
$ grails test-app

### Travis

Configuración de Travis para que corra todos los test (integración/calidad) de la aplicación (persistencia, dominio, api). 
Para ello se agregan en el archivo .travis.yml las siguientes lineas:

language: groovy

jdk: 
 - openjdk8

before_install:
 - curl -s get.sdkman.io | bash
 - source "$HOME/.sdkman/bin/sdkman-init.sh"
 - sdk install grails

script: grails test-app


## Retrospectiva

Método de retrospectiva: Mad, Sad, Glad

### SAD

- El feriado, no seguir con la rutina de los sprint.

### GLAD

- Test integración/calidad funcionando correctamente con travis.
- La tecnología gustó más de lo pensado.
- El equipo se dejo de joder y por primera vez es un equipo sincronizado.
- La mejora en la comunicación del equipo.
- Más compañerismo, mejor ambiente trabajo.
- Llegar con los planificado en el sprint.
- Agregar más valor al sprint que el planeado.

