# LlanquihueTour - Sistema de Gestión de Agencia de Turismo

## Autor del proyecto

* **Nombre completo:** Sebastián Alejandro Reinoso Ortega
* **Sección:** DESARROLLO ORIENTADO A OBJETOS I_001A
* **Carrera:** ANALISTA PROGRAMADOR COMPUTACIONAL
* **Sede:** Online

---

## Descripción general del sistema

Este proyecto corresponde al **Trabajo Final** de la asignatura **Desarrollo Orientado a Objetos I**. Se trata de una aplicación desarrollada en **Java** que simula la gestión de una agencia turística, permitiendo administrar tanto el personal como los clientes y consultar el catálogo de servicios turísticos disponibles.

El sistema implementa una jerarquía de clases donde `Persona` actúa como clase base para las distintas entidades del sistema: `GuiaTuristico`, `OperadorTransporte`, `ColaboradorExterno` y `Cliente`. Todas estas clases implementan la interfaz `Informable`, la cual define el método `mostrarDetalles()` para presentar la información de cada registro utilizando **polimorfismo**.

Los datos de las personas son almacenados en una colección dinámica de tipo `ArrayList<Persona>`, mientras que los servicios turísticos son cargados automáticamente desde un archivo de texto mediante la clase `ArchivoServicios`. Además, la aplicación permite guardar y recuperar la información registrada utilizando archivos de texto, manteniendo la persistencia de los datos entre ejecuciones.

La interacción con el usuario se realiza mediante un menú gráfico desarrollado con **JOptionPane**, desde el cual es posible registrar personas, consultar los servicios turísticos, filtrar registros según su categoría y generar un reporte completo del sistema.

El objetivo principal del proyecto es integrar los contenidos desarrollados durante la asignatura, aplicando conceptos como **herencia, interfaces, polimorfismo, encapsulamiento, colecciones dinámicas, manejo de archivos, manejo de excepciones y organización modular del código**.

---

## Estructura general del proyecto

📁 src/

├── 📁 ui/                  # Clase principal del programa (`Main.java`)

├── 📁 data/                # Gestión de datos y archivos

│   ├── 📄 GestorTurismo.java

│   ├── 📄 ArchivoTurismo.java

│   └── 📄 ArchivoServicios.java

└── 📁 model/               # Clases del dominio del sistema

```
├── 📄 Persona.java

├── 📄 Informable.java

├── 📄 GuiaTuristico.java

├── 📄 OperadorTransporte.java

├── 📄 ColaboradorExterno.java

├── 📄 Cliente.java

├── 📄 ServicioTuristico.java

├── 📄 RutaGastronomica.java

├── 📄 ExcursionCultural.java

├── 📄 PaseoLacustre.java

└── 📄 TourGenerico.java
```

---

## Instrucciones para ejecutar el proyecto

1. Clonar el repositorio o descargar el proyecto.

2. Abrir el proyecto en **IntelliJ IDEA** o **Apache NetBeans**.

3. Verificar que el proyecto compile correctamente.

4. Ejecutar el archivo `Main.java` ubicado en el paquete `ui`.

5. Utilizar el menú para registrar guías turísticos, operadores de transporte, colaboradores externos y clientes.

6. Consultar los servicios turísticos disponibles, filtrar personas por categoría y generar el reporte general del sistema.

---

## Funcionalidades principales

* Registro de guías turísticos.
* Registro de operadores de transporte.
* Registro de colaboradores externos.
* Registro de clientes.
* Validación para evitar registros con RUT duplicado.
* Generación automática de códigos para cada tipo de persona.
* Lectura automática de servicios turísticos desde un archivo de texto.
* Almacenamiento y recuperación de personas mediante archivos de texto.
* Consulta del catálogo de servicios turísticos.
* Filtrado de personas según su categoría.
* Generación de un reporte general del sistema.
* Uso de polimorfismo mediante el método `mostrarDetalles()`.

---

## Tecnologías utilizadas

* **Java**
* **Programación Orientada a Objetos**
* **Herencia**
* **Interfaces**
* **Polimorfismo**
* **Sobrescritura de métodos**
* **Encapsulamiento**
* **Colecciones (`ArrayList`)**
* **Manejo de archivos de texto**
* **Manejo de excepciones**
* **JOptionPane**
* **Organización modular mediante paquetes**

---

## Repositorio GitHub

https://github.com/Balmaseba/Semana_9_Final

**Fecha de entrega:** 19/07/2026
