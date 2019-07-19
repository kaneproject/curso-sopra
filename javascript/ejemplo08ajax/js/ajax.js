dameLoMio()
guardoUnArma()
function dameLoMio(){
    var ajax = new XMLHttpRequest();
    ajax.open("GET","data.json");//http://localhost/data.json
    ajax.onreadystatechange = function (){
        if(ajax.status == 200 && ajax.readyState == 4){
            var datos = JSON.parse(ajax.response);
            console.log(datos);
        }
    }
    ajax.send()
}

function dameMisArmas(){
    var ajax = new XMLHttpRequest();
    ajax.open("GET","http://localhost:8082/armas");//http://localhost/data.json
    ajax.onreadystatechange = function (){
        if(ajax.status == 200 && ajax.readyState == 4){
            var datos = JSON.parse(ajax.response);
            console.log(datos);
            actualizoUnArma()
        }
    }
    ajax.send()
}

function guardoUnArma(){
    var ajax = new XMLHttpRequest();
    ajax.open("POST","http://localhost:8082/armas/");//http://localhost/data.json
    ajax.setRequestHeader(
        'Content-Type','application/json;charset=UTF-8'
    )
    ajax.onreadystatechange = function (){
        if(ajax.status == 200 && ajax.readyState == 4){
            var datos = JSON.parse(ajax.response);
            console.log(datos);
            dameMisArmas()
        }
    }
    ajax.send(
        JSON.stringify(
            { 
                nombre: "ajax",
                calibre: "Calibrao"
            }
        )
    )
}

function actualizoUnArma(){
    var ajax = new XMLHttpRequest();
    ajax.open("PUT","http://localhost:8082/armas/6");//http://localhost/data.json
    ajax.setRequestHeader(
        'Content-Type','application/json;charset=UTF-8'
    )
    ajax.onreadystatechange = function (){
        if(ajax.status == 200 && ajax.readyState == 4){
            var datos = JSON.parse(ajax.response);
            console.log(datos);
            vendoUnArma();
        }
    }
    ajax.send(
        JSON.stringify(
            { 
                nombre: "AJAX",
                calibre: "CALIBRAO"
            }
        )
    )
}

function vendoArma(){
    var ajax = new XMLHttpRequest();
    ajax.open("DELETE","http://localhost:8082/armas/6");//http://localhost/data.json
    ajax.onreadystatechange = function (){
        if(ajax.status == 200 && ajax.readyState == 4){
            console.log("Vendido!")
        }
    }
    ajax.send()
}
