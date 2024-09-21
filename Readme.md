##Patron de diseño usado:

El patron de diseño usado fue el observer, que trata de que cada vez que modifico un stock, el observador se encarga de notificar a los agentes para que estos efectuen correspondientemente


## ProductControler

# localhost:8080/productos/add

para agregar un producto se debe hacer un post con el siguiente formato:

```json
{
    "nombre": "nombre",
    "precio": 0,
    "stock": 0,
    "categoria": "categoria"
}
```

# localhost:8080/productos/delete/{name}

Para eliminar un producto

# localhost:8080/productos/update/{name}/{stock}
Para actualizar el stock de un producto

# localhost:8080/productos/getAll
Para obtener todos los productos existentes

### se recomienda probar con Postmant la API REST

