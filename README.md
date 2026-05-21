# Guía

## Instrucciones para la puesta en marcha

1. El proyecto incluye un `Dockerfile` ya configurado. Para generar la imagen basta con construirlo, `docker build .` en el directorio del proyecto. Construyendo la imagen también se encarga de compilar el proyecto para tener la versión más reciente.

2. El servidor con la aplicación se abre en el puerto `8080` del contenedor. En concreto, la url base completa es `http://<host>:8080/blobsim`.

3. Los endpoints concretos se detallan en la especificación de la API. (`blobsim.html` presenta la misma documentación en formato HTML).

4. Para una explicación detallada sobre el funcionamiento de la simulación ver `Reglas y modificación de parámetros`.

## Reglas y modificación de parámetros

> Para una mayor documentación acerca del código, el javadoc del proyecto está en <https://huarandi.github.io/trabajo-tt1>

- El cliente envía el numero de células inmóviles i, móviles m y reproductoras r que necesita.

- El servidor crea un tablero cuadrado de lado t siendo t = i + m + r.

- Las células se colocan de manera aleatoria en el tablero inicial, el resto de posiciones quedan vacías.

- Cada simulación consta de 49 instantes a partir del primero, sumando 50 instantes en total.

- Las células inmóviles tratan de mantenerse en la casilla en la que están, su color es rojo.

- Las células móviles tratan de moverse a una casilla adyacente (1 de distancia vertical o horizontal) de forma aleatoria entre las 4 posiciones, su color es el amarillo.

- Las células reproductoras se reproducen con una probabilidad de 1/3 a una casilla adyacente, en caso de que se reproduzca se reproduce al hacer a una casilla adyacente, su color es azul.

- Si varias células tratan de ocupar la misma casilla en un instante, se ha establecido un sistema de prioridad entre los tipos para ocupar una casilla en conflicto, siendo de mayor prioridad a menos para ocuparla este orden: INMOVIL >> MOVIL >> REPRODUCTORA.

- El servidor te devuelve todas las posiciones de todos los instantes.

GUIA PARA MODIFICAR PARAMETROS:

- Tamaño del tablero: variable tmax, linea 41 Clase ThreadGame de Server.
- Numero de Instantes del juego: Contante N_INSTANTS, linea 23 de la Clase ThreadGame de Server.
- Probabilidad de reproducirse: Lineas 97-98 de la Clase SimIterator de logic.
- Prioridad de las celulas: Lineas 31-33 de la Clase CellPrioritizer de logic.
- Color de las células: método getColor() de cada implementación de Cell.

## Especificación de la API

# blobsim

Base URLs: `http://<host>:8080/blobsim`

## POST Solicitud/Solicitar

POST /blobsim/Solicitud/Solicitar

> Body Parameters

```json
{
	"nombreEntidades": ["dynamic", "static", "reproductive"],
	"cantidadesIniciales": [1, 3, 5]
}
```

### Params

| Name                  | Location | Type     | Required | Description |
| --------------------- | -------- | -------- | -------- | ----------- |
| nombreUsuario         | query    | string   | no       | none        |
| body                  | body     | object   | yes      | none        |
| » nombreEntidades     | body     | [string] | yes      | none        |
| » cantidadesIniciales | body     | [number] | yes      | none        |

#### Enum

| Name              | Value        |
| ----------------- | ------------ |
| » nombreEntidades | static       |
| » nombreEntidades | dynamic      |
| » nombreEntidades | reproductive |

> Response Examples

> 200 Response

```json
{
	"done": true,
	"tokenSolicitud": 2040521220,
	"errormessage": "",
	"data": ""
}
```

### Responses

| HTTP Status Code | Meaning                                                        | Description                                                                                                            | Data schema |
| ---------------- | -------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------- | ----------- |
| 200              | [OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)        | El tokenSolicitud devuelto se utilizará para recuperar los resultados de la simulación en el endpoint POST /Resultados | Inline      |
| 404              | [Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4) | none                                                                                                                   | None        |

### Responses Data Schema

HTTP Status Code **200**

| Name             | Type    | Required | Restrictions | Title | description |
| ---------------- | ------- | -------- | ------------ | ----- | ----------- |
| » done           | boolean | true     | none         |       | none        |
| » tokenSolicitud | number  | true     | none         |       | none        |
| » errormessage   | string  | true     | none         |       | none        |
| » data           | string  | true     | none         |       | none        |

## POST Resultados

POST /Resultados

### Params

| Name          | Location | Type   | Required | Description |
| ------------- | -------- | ------ | -------- | ----------- |
| nombreUsuario | query    | string | no       | none        |
| tok           | query    | number | no       | none        |

> Response Examples

> 200 Response

```json
{
	"done": true,
	"tokenSolicitud": 2040521220,
	"errormessage": "",
	"data": "3\n0,0,1,blue\n0,0,2,blue\n0,1,2,blue\n0,2,0,red\n1,0,1,blue\n1,0,2,blue\n1,1,2,blue\n1,2,0,red\n2,0,1,blue\n2,0,2,blue\n2,1,2,blue\n2,2,0,red\n3,0,1,blue\n3,0,2,blue\n3,1,2,blue\n3,2,0,red\n4,0,1,blue\n4,0,2,blue\n4,1,2,blue\n4,2,0,red\n5,0,1,blue\n5,0,2,blue\n5,1,2,blue\n5,2,0,red\n6,0,1,blue\n6,0,2,blue\n6,1,2,blue\n6,2,0,red\n7,0,1,blue\n7,0,2,blue\n7,1,2,blue\n7,2,0,red\n8,0,1,blue\n8,0,2,blue\n8,1,2,blue\n8,2,0,red\n9,0,1,blue\n9,0,2,blue\n9,1,2,blue\n9,2,0,red\n10,0,1,blue\n10,0,2,blue\n10,1,2,blue\n10,2,0,red\n11,0,1,blue\n11,0,2,blue\n11,1,2,blue\n11,2,0,red\n12,0,1,blue\n12,0,2,blue\n12,1,2,blue\n12,2,0,red\n13,0,1,blue\n13,0,2,blue\n13,1,2,blue\n13,2,0,red\n14,0,1,blue\n14,0,2,blue\n14,1,2,blue\n14,2,0,red\n15,0,1,blue\n15,0,2,blue\n15,1,2,blue\n15,2,0,red\n16,0,1,blue\n16,0,2,blue\n16,1,2,blue\n16,2,0,red\n17,0,1,blue\n17,0,2,blue\n17,1,2,blue\n17,2,0,red\n18,0,1,blue\n18,0,2,blue\n18,1,2,blue\n18,2,0,red\n19,0,1,blue\n19,0,2,blue\n19,1,2,blue\n19,2,0,red\n20,0,1,blue\n20,0,2,blue\n20,1,2,blue\n20,2,0,red\n21,0,1,blue\n21,0,2,blue\n21,1,2,blue\n21,2,0,red\n22,0,1,blue\n22,0,2,blue\n22,1,2,blue\n22,2,0,red\n23,0,1,blue\n23,0,2,blue\n23,1,2,blue\n23,2,0,red\n24,0,1,blue\n24,0,2,blue\n24,1,2,blue\n24,2,0,red\n25,0,1,blue\n25,0,2,blue\n25,1,2,blue\n25,2,0,red\n26,0,1,blue\n26,0,2,blue\n26,1,2,blue\n26,2,0,red\n27,0,1,blue\n27,0,2,blue\n27,1,2,blue\n27,2,0,red\n28,0,1,blue\n28,0,2,blue\n28,1,2,blue\n28,2,0,red\n29,0,1,blue\n29,0,2,blue\n29,1,2,blue\n29,2,0,red\n30,0,1,blue\n30,0,2,blue\n30,1,2,blue\n30,2,0,red\n31,0,1,blue\n31,0,2,blue\n31,1,2,blue\n31,2,0,red\n32,0,1,blue\n32,0,2,blue\n32,1,2,blue\n32,2,0,red\n33,0,1,blue\n33,0,2,blue\n33,1,2,blue\n33,2,0,red\n34,0,1,blue\n34,0,2,blue\n34,1,2,blue\n34,2,0,red\n35,0,1,blue\n35,0,2,blue\n35,1,2,blue\n35,2,0,red\n36,0,1,blue\n36,0,2,blue\n36,1,2,blue\n36,2,0,red\n37,0,1,blue\n37,0,2,blue\n37,1,2,blue\n37,2,0,red\n38,0,1,blue\n38,0,2,blue\n38,1,2,blue\n38,2,0,red\n39,0,1,blue\n39,0,2,blue\n39,1,2,blue\n39,2,0,red\n40,0,1,blue\n40,0,2,blue\n40,1,2,blue\n40,2,0,red\n41,0,1,blue\n41,0,2,blue\n41,1,2,blue\n41,2,0,red\n42,0,1,blue\n42,0,2,blue\n42,1,2,blue\n42,2,0,red\n43,0,1,blue\n43,0,2,blue\n43,1,2,blue\n43,2,0,red\n44,0,1,blue\n44,0,2,blue\n44,1,2,blue\n44,2,0,red\n45,0,1,blue\n45,0,2,blue\n45,1,2,blue\n45,2,0,red\n46,0,1,blue\n46,0,2,blue\n46,1,2,blue\n46,2,0,red\n47,0,1,blue\n47,0,2,blue\n47,1,2,blue\n47,2,0,red\n48,0,1,blue\n48,0,2,blue\n48,1,2,blue\n48,2,0,red\n49,0,1,blue\n49,0,2,blue\n49,1,2,blue\n49,2,0,red\n"
}
```

### Responses

| HTTP Status Code | Meaning                                                          | Description                                                                                                                                                                                                                          | Data schema |
| ---------------- | ---------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ----------- |
| 200              | [OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)          | El campo dato presenta los datos de forma que la primera línea indica el número de casillas de alto y largo de una matriz cuadrada. Las siguientes líneas representan las coordenadas tiempo, y, x color para las casillas ocupadas. | Inline      |
| 400              | [Bad Request](https://tools.ietf.org/html/rfc7231#section-6.5.1) | none                                                                                                                                                                                                                                 | None        |

### Responses Data Schema

HTTP Status Code **200**

| Name             | Type    | Required | Restrictions | Title | description |
| ---------------- | ------- | -------- | ------------ | ----- | ----------- |
| » done           | boolean | true     | none         |       | none        |
| » tokenSolicitud | number  | true     | none         |       | none        |
| » errormessage   | string  | true     | none         |       | none        |
| » data           | string  | true     | none         |       | none        |
