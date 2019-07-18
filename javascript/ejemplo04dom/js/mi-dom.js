function initialize(){
    var miH1 = document.createElement("h1");// <h1></h1>
    var miTxt = document.createTextNode("Un texto muy mono"); //<>Un texto muy mono<>
    miH1.appendChild(miTxt); //<h1>Un texto muy mono!</h1>
    var miBody = document.body; // <body>...</body>
    miBody.appendChild(miH1); // <body><h1>texto que sea</h1></body>
}