function initialize(){
   var parrafo1 = document.getElementById("parrafo1");
   console.log(parrafo1)
   var parrafo2 = document.querySelector("body p");
   console.log(parrafo2)
   var parrafos = document.getElementsByClassName("titulo")
   console.log(parrafos)
   var vasLIsto = document.getElementsByTagName("li");
   console.log(vasLIsto)
   var inputs = document.getElementsByName("input");
   var parrafosDeVerdad = document.querySelectorAll("body p");
   console.log("Primer elemento : ", parrafosDeVerdad.item(0))
   console.log("Segundo :",parrafosDeVerdad[1])
   for (let index = 0; index < parrafosDeVerdad.length; index++) {
       console.log(parrafosDeVerdad[index].firstChild.textContent)
   }
   
}