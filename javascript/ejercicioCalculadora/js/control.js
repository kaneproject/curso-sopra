
function initialize(){
    // Variables globales disponibles
    calculadora = new Calculadora();
    display = document.getElementById("display");
    resetDisplay = false;
    operador = "";
    ultimoValor = 0;
}
function agregaADisplay(numero){
    if(resetDisplay){
        display.value = "";
        resetDisplay = false;
    }
    display.value = new Number(display.value + numero);
}
function pulsarSuma(){
    if(!resetDisplay){
        calculadora.sumar(new Number(display.value))
        operador = "+";
        ultimoValor = new Number(display.value);
    }
    display.value = calculadora.getDisplay()
    resetDisplay = true;
}
function pulsarIgual(){
    if(!resetDisplay){
        ultimoValor = new Number(display.value);
    }
    if(operador == "+"){
        calculadora.sumar(ultimoValor)
        display.value = calculadora.getDisplay()
        resetDisplay = true;
    }
    
}
