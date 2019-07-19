function Calculadora(){
    this._display = 0;
}
Calculadora.prototype.sumar = function(valor){
    this._display += valor;
}
Calculadora.prototype.restar = function(valor){
    this._display -= valor;
}
Calculadora.prototype.multiplicar = function(valor){
    this._display *= valor;
}
Calculadora.prototype.dividir = function(valor){
    this._display /= valor;
}
Calculadora.prototype.getDisplay = function(){
    return this._display;
}
Calculadora.prototype.reset = function (){
    this._display = 0;
}
Calculadora.prototype.operar = function(operador,valor){
    this._display = eval(this._display + " " + operador + " " + valor);
}
//var calc = new Calculadora();
//calc.sumar(323);
//console.log(calc.getDisplay())
//calc.operar("-",211);
//console.log(calc.getDisplay())
