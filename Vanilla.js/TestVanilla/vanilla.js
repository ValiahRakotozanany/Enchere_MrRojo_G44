
/*var xhr;
try {
    xhr = new ActiveXObject('Msxml2.XMLHTTP');
} catch (e) {
    try {
        xhr = new ActiveXObject('Microsoft.XMLHTTP');
    } catch (e2) {
        try {
            xhr = new XMLHttpRequest();
        } catch (e3) {
            xhr = false;
        }
    }
}

xhr.onreadystatechange = function () {
    if (xhr.readyState == 4) {
        if (xhr.status == 200) {
            var token = JSON.parse(xhr.responseText);
            alert(token.id);
            sessionStorage.setItem('token', JSON.stringify(token));
        } else {
            document.dyn = "Error code " + xhr.status;
        }
    }
};*/


/*function getVoiture() {
     var xhr;
      try {
          xhr = new ActiveXObject('Msxml2.XMLHTTP');
      } catch (e) {
          try {
              xhr = new ActiveXObject('Microsoft.XMLHTTP');
          } catch (e2) {
              try {
                  xhr = new XMLHttpRequest();
              } catch (e3) {
                  xhr = false;
              }
          }
      }
      xhr.onreadystatechange  = function()
      {
        if (xhr.readyState == 4) {
            if (xhr.status == 200) {
                  var retour= JSON.parse(xhr.response);
                  var str="<table>";
                  str+="<tr><th>id</th><th>nom</th><th>matricule</th>";
                  for(let index=0; index<retour.length;index++){
                      str+="<tr>"
                      str+="<td>"+retour[index].id+"</td>"
                      str+="<td>"+retour[index].nom+"</td>"
                      str+="<td>"+retour[index].matricule+"</td>"
                      str+="</tr>"
                  }
                  str+="</table>"
                  document.getElementById("vehicule").innerHTML=str
              } else {
                  document.dyn = "Error code " + xhr.status;
              }
          }
    };
    xhr.open("GET", "http://localhost:9000/gestionflotte/vehicules",true);
    xhr.send(null);
}*/
function getVoiture() {
    var xhr= new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if (xhr.readyState == 4) {
            if (xhr.status == 200) {
                  var retour= JSON.parse(xhr.response);
                  var str="<table>";
                  str+="<tr><th>id</th><th>nom</th><th>matricule</th>";
                  for(let index=0; index<retour.length;index++){
                      str+="<tr>"
                      str+="<td>"+retour[index].id+"</td>"
                      str+="<td>"+retour[index].nom+"</td>"
                      str+="<td>"+retour[index].matricule+"</td>"
                      str+="<td><button id='bouton' onclick=detail("+retour[index].id+")>detail</button></td>"
                      str+="</tr>"
                  }
                  str+="</table>"
                  document.getElementById("vehicule").innerHTML=str
              } else {
                  document.dyn = "Error code " + xhr.status;
              }
        }
    }
    xhr.open("GET", "http://localhost:8081/gestionflotte/vehicules",true);
    xhr.send(null);
}
function detail(id) {
    var xhr= new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if (xhr.readyState == 4) {
            if (xhr.status == 200) {
                var retour= JSON.parse(xhr.response);
                var str="<table>";
                console.log(xhr.response);
                str+="<tr><th>id</th><th>vehicule</th><th>dates</th><th>kmdeb</th><th>kmfin</th>";
                console.log(" uu = "+retour.id);
                        str+="<tr>"
                        str+="<td>"+retour.id+"</td>"
                        str+="<td>"+retour.vehicule.nom+"</td>"
                        str+="<td>"+retour.dates+"</td>"
                        str+="<td>"+retour.kmdebut+"</td>"
                        str+="<td>"+retour.kmfin+"</td>"
                        str+="</tr>"
                  //  }                
                str+="</table>"
                document.getElementById("detail").innerHTML=str
            } 
            else {
                document.dyn = "Error code " + xhr.status;
            }
        }
    }
    xhr.open("GET", "http://localhost:8081/gestionflotte/kylometrages/"+id,true);
    xhr.send(null);
}
        
