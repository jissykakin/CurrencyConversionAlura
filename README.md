# Convertidor de Moneda - Alura Latam 🏦💸

¡Bienvenido al Convertidor de Moneda!, 🌍💱 una herramienta sencilla y efectiva con interfaz de texto a través de la consola desarrollada en Java, que te permite realizar conversiones de divisas usando tasas de cambio actualizadas a través de la API de ExchangeRate-API. Con un menú intuitivo y opciones avanzadas, para conversiones personalizadas, visualización y gestión del historial de conversiones. 

## Cómo Empezar 🚀
Prerrequisitos:
 - Java 8 o superior.
 - Conexión a Internet.
 - Clave API de ExchangeRate-API.

## Instalación
1. Clona este repositorio:

```ts
git clone https://github.com/jissykakin/CurrencyConversionAlura.git
```
2. Obtén tu clave API gratuita en ```ExchangeRate-API``` y reemplaza ```YOUR-API-KEY``` en las rutas de la API dentro del código ubicado dentro del paquete ```services ``` modifica la variable ``` apiKey ```.


3. Navega a la carpeta del proyecto:
```
cd CurrencyConversionAlura
```
3. Compila el código: ``` javac Main.java.```


4. Ejecuta el programa con ```java Main```.


## Menú Principal 🍽️

Cuando ejecutes el programa, verás el siguiente menú:

```
Menú Principal:
1.  Dólar           =>> Peso Colombiano
2.  Peso Colombiano =>> Dólar
3.  Euro            =>> Peso Colombiano
4.  Peso Colombiano =>> Euro
5.  Dólar           =>> Peso Brasileño
6.  Peso Brasileño  =>> Dólar
7.  Euro            =>> Dólar
8.  Dólar           =>> Euro
9.  Opciones Avanzadas
0.  Salir
```
Las opciones del 1 al 8 permitirán generar una conversión manual a través de códigos de monedas preestablecidos, obteniendo la tasa de cambio mediante la ruta:
```ts
 GET https://v6.exchangerate-api.com/v6/YOUR-API-KEY/latest/USD
```

![image](https://github.com/user-attachments/assets/34e62f45-e3c7-4b7b-8894-32ddb4a1a2db)

## Opciones Avanzadas 🛠️
Dentro de las Opciones Avanzadas podrás realizar las siguientes acciones:
```
Menú Opciones Avanzadas:
1. Conversión personalizada
2. Ver histórico de conversiones realizadas
3. Borrar histórico
0. Regresar a menú principal
```

### 1. Conversión Personalizada
Permite realizar conversiones entre monedas utilizando códigos válidos proporcionados por la API., realizando la conversion directamente de la API :
 - Genera una lista de los códigos validos por la api a traves de la consulta a la ruta ```GET https://v6.exchangerate-api.com/v6/YOUR-API-KEY/codes)```
    ![image](https://github.com/user-attachments/assets/805ceaa4-edb4-4e49-8c2b-10fa792921e1)


 - Debe ingresar los códigos válidos de la moneda base y la moneda a convertir y el valor que desea convertir.
    ![image](https://github.com/user-attachments/assets/d3db2f32-05d6-4550-8321-2d858da42bed)


### 2. Ver Histórico
Muestra todas las conversiones realizadas durante la sesión, creando persistencia a través de un archivo Json utilizando la libreria GSON.


![image](https://github.com/user-attachments/assets/6683dba6-4c3e-4801-853d-72e50be6eb4e)

### 3. Borrar Histórico
Elimina el historial de conversiones realizadas.

## Contribuciones 🤝
¡Las contribuciones son bienvenidas! Si deseas mejorar el proyecto, no dudes en enviar un pull request.

## Licencia 📄
Este proyecto está licenciado bajo la Licencia MIT.
