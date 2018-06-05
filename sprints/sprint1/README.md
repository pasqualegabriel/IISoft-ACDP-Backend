# Iteración 1

## Investigaciones

### Mongodb

Se cambio la persistencia de Hibernate a Mongodb del proyecto, se persistió un objeto y se probaron las queries por default que provee Grails con éxito pero por problemas de configuración al ejecutar queries por propiedades no filtraba y traía todos los objetos. Se intento resolver el problema pero no tuvimos éxito y se decidió seguir con Hibernate. 

### executeQuery

Se investigo como funciona el executeQuery en Grails:
Publication.executeQuery("from Publication where title <> ?", ['RetrospectiveIISoft'])
En este caso, para traer una lista de Publicaciones con title distinto de ‘RetrospectiveIISoft’ no hace falta escribir select, basta con escribir “from Publication” mas las condiciones (where, group by, limit, etc).
Publication.executeQuery("select title from Publication where title <> ?", ['RetrospectiveIISoft'])
Para seleccionar las columnas/atributos de las Publicaciones se utiliza el select mas el nombre de cada atributo separado por una coma, esta query trae una lista de titles con title distinto de ‘RetrospectiveIISoft’.
Los signos de pregunta ‘?’ son remplazados en orden por los valores de la lista del segundo parámetro de executeQuery.






