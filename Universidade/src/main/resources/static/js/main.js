function GerarMatricula(){
    var txt = "UNI";
    var cod = Math.floor(Math.random() * 1500);
    document.getElementById('matricula').value = (txt + cod);
}