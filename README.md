# Aplicación de Escritorio.

---
## Contenido:

- img
- <details>
    <summary>ProjectFrontDesktop</summary>

    - <details>
      <summary>Java</summary>
    
        - <details>
            <summary>Main App</summary>
    
            - controllers
            - dto
            - mapper
            - model
            - rest
            - App.java
           </details>
        - module-info.java
      </details>
    - <details>
        <summary>Resources</summary>

        - css
        - fxml
        - i18n
        - img
        - application.properties
      </details>
  </details>

---
## img
>Fotos del prototipo de la aplicación de escritorio. El objetivo de estas es
> usarlas como "plano".

---
## ProjectFrontDesktop
### Java 
#### Controllers
> Dotan de funcionalidad a la aplicación, haciendo que cuando el usuario interactúe con ella, 
> esta responda apropiadamente. 

> Clases en este paquete:
>- GraficoController
>- ListController
>- LoginController
>- MainController
>- PistaController
>- ReservaController
>- UserController
#### Dto 
> Clases que son enviadas y recibidas en forma de json desde y hacia la API.

> Clases en este paquete:
>- AdminDTO
>- AlquilerDTO
>- ClienteDTO
>- InfraestructuraDTO
>- LoginDTO
#### Mapper 
> Este paquete, que solo contiene una clase, mapea (transforma) los diferentes DTO 
> a clases del modelo y viceversa.
#### Model 
> Clases pojo que usará la aplicación como modelo, como su nombre indica.

> Clases en este paquete:
>- Pista
>- Reserva
>- User
#### Rest 
> Este paquete contiene las clases con la configuración de Retrofit, la forma de conectarse a la 
> API y las llamadas que necesita para hacer que la aplicación funcione correctamente.

> Clases en este paquete:
>- Client
>- Config
>- RestOperations
#### App.java 
> Es la clase main.
#### module-info.java
> Contiene la información acerca de qué módulos de la JVM son usados en nuestra aplicación.

### Resources 
#### css
> Aquí se guarda el fichero styles.css, el cual dota de estilo a la aplicación.
#### fxml 
> Este paquete contiene las diferentes vistas en formato fxml.

> Ficheros en este paquete:
>- grafico
>- list
>- login
>- main
>- pista
>- reserva
>- user
#### i18n 
> Este paquete contiene los ficheros .properties con los idiomas 
> que soporta nuestra aplicación.

> Ficheros en este paquete:
>- strings_en_US.properties (Para idioma inglés)
>- strings_es_ES.properties (Para idioma castellano)
#### img 
> Este paquete contiene las diferentes imágenes jpg y png que utiliza la aplicación.

> Ficheros en este paquete:
>- avatar
>- bglogin
>- login
>- pista
>- reserva
#### application.properties
> El fichero properties, en este caso, sólamente guarda la información de en qué idioma se 
> mostrará la aplicación.

---
## Hecho por:

| Programador             | GitHub                                       | Gmail                               |
|-------------------------|----------------------------------------------|-------------------------------------|
| Dylan Hurtado López     | [GitHub](https://github.com/DyLaNHurtado)    | [Gmail](dylanhurtado43@gmail.com)   |
| Eneko Rebollo Hernández | [GitHub](https://github.com/enekor)          | [Gmail](enekorebollo@gmail.com)     |
| Saúl Mellado Herrera    | [GitHub](https://github.com/saulmella12)     | [Gmail](saulmella12@gmail.com)      |
| Emilio López Novillo    | [GitHub](https://github.com/emilio2403)      | [Gmail](lopeznovillo2000@gmail.com) |
| Daniel Rodríguez Muñoz  | [GitHub](https://github.com/Idliketobealoli) | [Gmail](daniel.ro.mu02@gmail.com)   |