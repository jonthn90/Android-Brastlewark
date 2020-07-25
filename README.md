# Android-Brastlewark

Proyecto de prueba de codificación para Android con Kotlin

Flujo:

1. Se accede al endpoitn indicado para obtener el JSON con el response.
2. Dicha informacoin se descarga y es almacenada en una base de datos local, para evitar su descarga posterior.
3. Se muestra al usuario una pantalla con el listado de los habitantes.
4. Puede realizar busqueda por nombre.
5. Se puede entrar a ver el detalle de cada habitante en donde se muestra su foto e información.


Arquitectura utilizada:

Se implemento una arquitectura Clean en donde tenemos divididos en las capas de Domain, Data, UsesCases, App (Android). Ordenado de más a menos abstracto:

- Domain: definicion de entities.
- Data:definicion de data sources y repositories.
- UsesCases (Interactors): Acciones que el usuario puede desencadenar
- App (Android): capa de presentación, framework y UI.

Esto permite matener los pricipios SOLID y poder hacer testeos mas fácil. Ademas de que al separar la capa de App (Android) no dependemos del framework para los niveles mas abtrasctos de las capas mas internas.

Para la capa de presentación se utilizo el patron MVVM dentro de la capa de App(Android).

Y tambien se utilizo un patron Single Activity para la funcionalidad general (Se tiene un Splash activity usado netamente para el Splash Screen y si fuese neecsario este activity podria funcionar para un proceso de autenticación)


Tecnologías usadas:

- Retrofit con MoshiConverter: para hacer la peticion HTTP
- Room: para el manejo de la base de datos local
- Coroutines Kotlin: para el manejo de operaciones en hilos
- Koin: para la inyeccion de dependencias
- Navigation Component: para el flujo de navegación entre pantallas
- Databinding: para el binding de la interfaz
- Live Data: para la comunicación entre el ViewModel y la UI
- View Model: para el manejo de los casos de uso y datos de la app
- Fresco: para la carga y cacheo de imagenes
- Lottie: para las animaciones
- Timber: para maejo de logs
- JUnit y Mockito: para los test unitarios
