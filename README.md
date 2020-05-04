# calculadoraSanitas
Calculadora rest de Sanitas

He planteado el problema creando un solo controller con varios métodos y escuchando solo con put, ya que lo que se plantea es realizar una operación sencilla y que nos devuelva un resultado.

El Objeto de entrada llamado Operador se utiliza para introducir los datos que se quieren calcular, tendrá formato simple para una operación y de tipo array para el cálculo, el objeto está compuesto por :

	- operacion  : describe la operación y solo es necesaria en la funcionalidad de cálculo, es de tipo String.
	
	- operador1  : operando principal para realizar la operación, es de tipo BigDecimal.
	
	- operador2  : operando secundario y no necesario para el caso de la raiz y del cálculo, es de tipo BigDecimal.
	
	- resultado  : resultado de la operación, indica el resultado de una operación o del calculo, para los datos de entrada  
				   no es necesario, es de tipo BigDecimal.


Para la lógica y realización de la operación,he creado un solo service para simplificar el problema, se implementa de una interfce y la lógica de todo el microservicio esta en esta capa,si fuera necesaria una bbdd se podria haber hecho una interfce por ejemplo de jpa y que se realizaran las operaciones básicas heredadas y se devolverian al controller.

En la capa de test he implementado un test por cada operación mas uno de errores con un parámetro erróneo, los test utilizan la API Tracer para imprimir el resultado por pantalla.

//Instalación

Para la instalación y ejecución del software es necesario descargarse el fuente de https://github.com/jaamdn/calculadoraSanitas.git y realizar un clean install con maven, las pruebas se pueden realizar como se indican mas abajo en este documento.


// API
Se puede ver el API completo con el servidor arrancado en esta url http://localhost:8080/swagger-ui.html


// Pruebas

Las pruebas se pueden hacer mediante postman con los siguientes parámetros de entrada

#Sumar

http://localhost:8080/Calculadora/sumar

{
	"operacion":"sumar",
	"operador1":"3",
	"operador2":"1",
	"resultado":"0"
}


#Restar

http://localhost:8080/Calculadora/restar

{
	"operacion":"restar",
	"operador1":"3",
	"operador2":"1",
	"resultado":"0"
}
	
#Multiplicar

http://localhost:8080/Calculadora/multiplicar

{
	"operacion":"multiplicar",
	"operador1":"3",
	"operador2":"1",
	"resultado":"0"
}


#Dividir

http://localhost:8080/Calculadora/dividir

{
	"operacion":"dividir",
	"operador1":"3",
	"operador2":"2",
	"resultado":"0"
	}


#Raiz

http://localhost:8080/Calculadora/raiz

{
	"operacion":"raiz",
	"operador1":"3",
	"operador2":"1",
	"resultado":"0"
}

#Calcular

http://localhost:8080/Calculadora/calcular

[
	{
	"operacion":"sumar",
	"operador1":"3",
	"operador2":"1",
	"resultado":"0"
	},
		{
	"operacion":"restar",
	"operador1":"3",
	"operador2":"1",
	"resultado":"0"
	},
		{
	"operacion":"restar",
	"operador1":"3",
	"operador2":"1",
	"resultado":"0"
	},
		{
	"operacion":"multiplicar",
	"operador1":"3",
	"operador2":"1",
	"resultado":"0"
	}
]
