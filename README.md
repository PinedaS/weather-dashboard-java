# Proyecto de Consulta del Clima 🌤️

## Descripción del proyecto
Este proyecto es una aplicación que consume la API de **WeatherAPI** para consultar el clima actual, obtener pronósticos a 2 días y comparar el clima de varias ciudades. El enfoque principal del proyecto es aplicar **programación funcional en Java** para manipular y mostrar la información climática.

### **Características principales**:
- Consultar el clima actual de una ciudad.
- Obtener el pronóstico del clima para los próximos 2 días.
- Comparar el clima entre varias ciudades para encontrar la ciudad más cálida.

## Tecnologías utilizadas
- **Java 22**
- **WeatherAPI**: API de datos meteorológicos.
- **Gson**: Para deserializar las respuestas JSON de la API.
- **Maven**: Para la gestión de dependencias.
- **JUnit 5**: Para pruebas unitarias.

## Historias de Usuario

### 1. **Consultar el clima actual de una ciudad**
**Como usuario**, quiero consultar el clima actual de una ciudad para saber las condiciones meteorológicas actuales y planificar mis actividades diarias.

#### Criterios de aceptación:
- El usuario debe poder ingresar el nombre de una ciudad.
- La aplicación debe mostrar:
    - Temperatura actual.
    - Sensación térmica.
    - Condición climática (soleado, nublado, etc.).
    - Humedad.
- Se debe utilizar **`Optional`** para manejar datos nulos.

---

### 2. **Consultar el pronóstico del clima a 2 días**
**Como usuario**, quiero consultar el pronóstico del clima para los próximos **2 días** para poder planificar mis actividades futuras.

#### Criterios de aceptación:
- El usuario debe poder ingresar el nombre de una ciudad.
- La aplicación debe mostrar:
    - Temperaturas máximas y mínimas.
    - Condiciones climáticas diarias.
- Se debe utilizar **`filter()`** para filtrar los días que cumplan una condición (ej. temperaturas mayores a 25°C).
- Se debe utilizar **`map()`** para transformar los datos en un formato legible.

---

### 3. **Comparar el clima de varias ciudades**
**Como usuario**, quiero comparar el clima de varias ciudades para tomar decisiones sobre viajes o actividades.

#### Criterios de aceptación:
- El usuario debe poder seleccionar varias ciudades.
- La aplicación debe mostrar una comparación de:
    - Temperaturas actuales.
    - Condiciones climáticas.
- Se debe utilizar **`reduce()`** para identificar la ciudad con la temperatura más alta.
- Se debe utilizar **`map()`** para transformar los datos en un formato legible.

---

## Pruebas unitarias
Se implementaron pruebas unitarias para garantizar el correcto funcionamiento de los servicios principales:
- **`WeatherService`**: Pruebas para validar la consulta del clima actual y el pronóstico.
- **`ForecastService`**: Pruebas para validar la comparación de climas entre ciudades.

Las pruebas fueron implementadas utilizando **JUnit 5**.

### Ejecución de pruebas
Para ejecutar las pruebas unitarias, utiliza el siguiente comando:

```bash
mvn test
```

## Instalación y ejecución

### 1. Clonar el repositorio
git clone git@github.com:PinedaS/weather-dashboard-java.git

### 2. Configuración del proyecto

#### API Key de WeatherAPI
- Para usar la API de **WeatherAPI**, necesitas obtener una **API Key**
    - Debes crear una cuenta en https://www.weatherapi.com/ y allí podrás obtener la API Key
- Luego debes configurar la Key dentro de tu aplicación.
    1. Crear un archivo de propiedades config.properties en src/main/resources/ (similar al archivo config-example.properties)
    2. Añadir la clave de la API en el archivo config.properties: weatherapi.key=TU_API_KEY

### 3. Construir el proyecto
Este proyecto utiliza **Maven** para gestionar dependencias. Para construir el proyecto, asegúrate de tener Maven instalado y luego ejecuta:

```bash
mvn clean install
```

### 4. Ejecutar el proyecto
Para ejecutar la aplicación, utiliza el método main() en la clase principal WeatherDashboardApplication. Si usas un IDE como IntelliJ o Eclipse, puedes ejecutarlo directamente desde allí.

Para ejecutarlo desde la línea de comandos:

```bash
mvn exec:java -Dexec.mainClass="com.weatherdashboard.WeatherDashboardApplication"
```

## Uso de Programación Funcional
Este proyecto pone a prueba conceptos clave de **programación funcional** en Java, usando la API de Streams:
- **`Optional`**: Para manejar datos que pueden ser nulos.
- **Streams API**:
    - **`filter()`**: Para seleccionar solo los datos relevantes (ej. días cálidos).
    - **`map()`**: Para transformar los datos en un formato legible para mostrar.
    - **`reduce()`**: Para comparar temperaturas y encontrar la ciudad más cálida.
