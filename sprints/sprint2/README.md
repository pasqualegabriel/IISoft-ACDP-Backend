# Iteración 2

## Investigaciones

### CORS

Para habilitar CORS en Grails se agregan las siguientes lineas en el archivo application.yml
grails:
    cors:
       enabled: true
       allowedMethods: ['*']

### Axios

Para instalar Axios en la terminal se puede utilizar alguno de los siguientes comandos:
$ yarn add axios
$ npm install axios --save
Para poder usarlo en react usa lo importamos de la siguiente manera:
import React from 'react'
Get:
axios.get('https://localhost:3000/param', token).then(res => {}).catch(err => {})
Post:
axios.post('https://localhost:3000/param', json, token).then(res => {}).catch(err => {})

### React (Ciclo de vida de un Componente)

- Construcción / Mounting

componentWillMount:
Es un método muy sencillo de comprender. Sólo se ejecuta antes de que el componente sea montado en el DOM. Si utilizas ecmascript 6, debes usar el método constructor pasándole las props como parámetro y usar el método super para activar correctamente el componente.

componentDidMount:
Este método solo se ejecuta justo después de que el componente haya sido montado en el DOM. Es el método perfecto para integrar librerias de terceros (plugins jquery), realizar alguna petición ajax ó establecer algún timer de tipo setTimeout ó setInterval.

- Actualización / Updating

componentWillReceiveProps:
Este método no se ejecutará una vez se monte el componente, si no que se esperará a recibir nuevas props de un componente padre para ejecutarse. Tiene como parámetro las futuras propiedades que va tener nuestro componente.

componentWillUpdate:
Muy similar a componentWillReceiveProp solo que se ejecuta justo antes del render, cuando nuestros props o estados han sido recibidos. Es útil para preparar antes de hacer un render. Tampoco se va a ejecutar con el primer render.
Es importante no usar aquí setState() ya que la aplicación entraría en bucle.

shouldComponentUpdate:
Se ejecuta de la misma forma que el anterior. Con este método podremos mejorar nuestra performance. Por defecto, siempre retorna true.
Si hacemos que retorne false, cancelariamos el render hasta un nuevo cambio de propiedades o de estado y ni componentWillUpdate, ni componentWillReceiveProps serían ejecutados.

componentDidUpdate:
Es invocado inmediatamente después de que el componente se haya actualizado. Aquí es donde podemos manejar el componente ya renderizado y actualizado en el DOM.

- Destrucción / Unmounting

componentWillUnmount:
Este metodo se ejecuta justo antes de que el componente sea destruido o eliminado del DOM. Es perfecto para cualquier tipo de reset y no recibe ningún tipo de parámetro.

- Orden de ejecución de los métodos

Creación de un componente:

Se dispara el método componentWillMount
Se renderiza y se monta el componente en el DOM
Se dispara el método componentDidMount

Actualización de un componente:

Se dispara el método shouldComponentUpdate
Se dispara el método componentWillReceiveProps si recibe nuevas props.
Se dispara el método componentWillUpdate antes de volver a renderizar.
Se actualiza el componente y se renderiza en el DOM
Se dispara el método componentDidUpdate una vez este el componente renderizado.

Destrucción de un componente:

Se dispara el método componentWillUnmount antes de que se destruya el componente
El componente es destruido y eliminado del DOM


## Retrospectiva

Método de retrospectiva: Mad, Sad, Glad

### MAD

- Pelear todavía con travis a último momento(no utilizar bien el tiempo de trabajo).

### SAD

- Falta de coordinación, espacio o tiempo.

### GLAD

- Se arreglo el bug de doble pegada a la api.
- La interfaz aunque esté gateando aún se empieza a ver más pretty y alegre.
- Cumplir gran parte del sprint.



