# API Rest de Bazar

Este proyecto es una API Rest desarrollada en Java con Spring Boot que permite gestionar un bazar. Proporciona endpoints para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre ventas, clientes y productos.

## Estructura del Proyecto

El proyecto está organizado en diferentes paquetes:

- **model**: Contiene las clases que representan los modelos de datos, como Venta, Cliente y Producto.
- **repository**: Aquí se encuentran las interfaces de repositorio que definen las operaciones de acceso a datos para cada entidad.
- **service**: Contiene las clases que implementan la lógica de negocio de la aplicación.
- **controller**: Aquí se encuentran los controladores que gestionan las peticiones HTTP y definen los endpoints de la API.

## Uso

Para utilizar la API, se pueden realizar las siguientes operaciones:

- **Crear una venta**: `POST /ventas`
- **Obtener todas las ventas**: `GET /ventas`
- **Obtener una venta por ID**: `GET /ventas/{id}`
- **Actualizar una venta**: `PUT /ventas/{id}`
- **Eliminar una venta**: `DELETE /ventas/{id}`

Se pueden realizar operaciones similares para clientes y productos.

## Documentación de la API

Se incluye un archivo Postman en la carpeta `PostMan` que contiene una colección de requests para probar la API. Para importar esta colección en Postman, sigue los siguientes pasos:

1. Abre Postman.
2. Haz clic en `Import` en la esquina superior izquierda.
3. Selecciona `Import From Link`.
4. Ingresa la URL del archivo Postman: `/PostMan/Bazar_API.postman_collection.json`

## Base de Datos

Se proporciona un archivo de base de datos en la carpeta `DataBase` que contiene el esquema y datos de ejemplo para la aplicación. Puedes importar este archivo en tu gestor de bases de datos para utilizarlo en tu entorno local.

## Docker

Para ejecutar la aplicación utilizando Docker, sigue estos pasos:

1. Asegúrate de tener Docker y Docker Compose instalados en tu máquina.
2. Clona el repositorio:
   ```sh
   git clone https://github.com/tuusuario/tu-repositorio.git
   ```
3. Navega al directorio del proyecto:
   ```sh
   cd tu-repositorio
   ```
4. Construye y levanta los contenedores:
   ```sh
   docker-compose up --build
   ```
5. La aplicación estará disponible en `http://localhost:8080`.

## Motivo
Este proyecto fue realizado gracias a los conocimientos aportados en el curso de Desarrollo de APIS en Java con SpringBoot.
## Licencia

Este proyecto está bajo la licencia [MIT](LICENSE).
