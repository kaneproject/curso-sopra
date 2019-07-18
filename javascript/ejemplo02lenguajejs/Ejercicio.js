console.log("Ejercicio")
console.log("Funcion que suma elementos de los atributos con minimo de dos elementos")
function sumar(numero1,numero2){
    if(arguments.length >= 2){
        let resultado = 0;
        for (let index = 0; index < arguments.length; index++) {
            resultado += arguments[index];
        }
        return resultado
    }
}
console.log(sumar())
console.log(sumar(1))
console.log(sumar(1,2))
console.log(sumar(1,4,6,2,51,2,52,243,5,2))
console.log("Ejercicio 2: Agregar a un array la funcion construida")
Array.prototype.funcionQueSuma = sumar
var miArray = new Array(7,15,12)
console.log(miArray.funcionQueSuma(3,5,7))
var otroArray = [3,5,7]
console.log(otroArray.funcionQueSuma(4,5,6))
console.log("Agregra una funcion a mi array que concatene su contenido")
function concatenarContenidoDeMiObjetoArray(){
    let concatenacion = ""
    for (let index = 0; index < this.length; index++) {
        concatenacion += this[index];  
    }
    return concatenacion
}
Array.prototype.concatena = concatenarContenidoDeMiObjetoArray
console.log(miArray.concatena())
console.log(otroArray.concatena())

let hombreObjeto = {}
let cartaDeCubatas = [
    {
        yelos: 2,
        licor: "Whiskey"
    },{
        yelos: 5,
        licor: "Ya no importa"
    },{
        yelos: 2,
        licor: "Cerveza"
    }
]
console.log(cartaDeCubatas[2].licor)
JSON.parse