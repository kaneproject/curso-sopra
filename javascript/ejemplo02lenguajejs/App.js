console.log("Mi primer log en nodejs");
variableGlobal = "mi variable global declarada";
var estoTambienEsUnaVariableGlobal = "Otra variable global!";
laFuncionDeIrAlLet()
laFuncionDeIrAlVar()

function laFuncionDeIrAlVar(){
    var variableLoca = "Estoy de mañana!"
    for (var i = 0; i < 10 ; i++){
        console.log("contenido de i " + i)
    }
    console.log("valor de i al final " + i)
}
function laFuncionDeIrAlLet(){
    var otraVariableLocarrl = "Otra variable local!"
    variableDeMierda = "ole ole y ole";
    for (let i = 0; i < 10 ; i++){
        console.log("contenido de i " + i)
    }
    // La i no existe fuera del bucle For, por lo tanto la siguiente linea falla
    //console.log("valor de i al final " + i)
}
console.log("--------------------------------")
console.log("Evaluación de los tipos de datos")
var tipoDeDatoNumerico = 8;
var tipoDeDatoCadena = "Cadenilla"
var tipoDeDatoFecha = new Date();
var referenciaAUnaFecha = tipoDeDatoFecha;
cambiemosLaFecha(tipoDeDatoFecha);
console.log("Fecha original " + tipoDeDatoFecha)
console.log("Fecha de la referencia " + referenciaAUnaFecha)
function cambiemosLaFecha(fecha){
    fecha.setFullYear(1999)
    console.log("Fecha cambiada a " + fecha)
}
console.log("Dime el tipo de la variable con un numero " + typeof tipoDeDatoNumerico)
console.log("Dime el tipo de la variable con una cadena " + typeof tipoDeDatoCadena)
console.log("Dime el tipo de la variable con una fecha " + typeof tipoDeDatoFecha)

operacionesNumericas(1,3,5,7)
operacionesNumericas()
function operacionesNumericas(){
    let miNumero = new Number(3.141592654)
    console.log("Valor almacenado " + miNumero.valueOf());
    console.log("Valor almacenado " + miNumero.toFixed());
    console.log("Valor almacenado " + miNumero.toFixed(4));
}
funcionHiperMegaGuayDeLaMuerte()
funcionHiperMegaGuayDeLaMuerte(1)
funcionHiperMegaGuayDeLaMuerte("mega","guay")
funcionHiperMegaGuayDeLaMuerte(2,3,4,5,6,2,2,1,41,5,51,2,523)
function funcionHiperMegaGuayDeLaMuerte(mega, guay){
    console.log("Numero de parametros recibidos " + arguments.length)
    console.log("Numero de argumentos esperados " + arguments.callee.length)
    if(arguments.length == arguments.callee.length){
        console.log(mega + " " + guay);
    }
    if(arguments.length == 1){
        console.log("Con " + mega +" me conformo")
    }
}
comoMeGustanLasArrayas()
function comoMeGustanLasArrayas(){
    let unArray = new Array(); // []
    unArray[0] = 7
    unArray[1] = "Mis mierdas"
    console.log("El ultimo elemento es " + unArray[unArray.length-1])
    let otroArray = [0,"valor",new Date()]
    let miArrayAsociativo = new Array()
    miArrayAsociativo['clave'] = "valor"
    let persona = new Array()
    persona.nombre = "Ruben"
    persona.apellido1 = "OfTheDead"
    persona.funcioncilla = funcionHiperMegaGuayDeLaMuerte
    persona.funcioncilla("soy","guay")
}

function Cubata(yelosChacho,licorcillo){
    this.losYelos = yelosChacho
    this.licor = licorcillo
    // Sumidero de memoria, crea una funcion por cada uno de los objetos generados
    this.echarUnTrago = function () {
        return this.losYelos + " " + this.licor
    }
}

Cubata.prototype.generameUnString = function(){
    return this.losYelos + " " + this.licor
}

var miCubata = new Cubata("Dos yelos","Roncillo de los de dolor de cabeza")
console.log(miCubata.echarUnTrago())