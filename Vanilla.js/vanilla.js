/*const consttestinput = document.querySelector(".testinput");
const consttestbuton = document.querySelector(".testbouton");
const consttestlist = document.querySelector(".testlist");

consttestbuton.addEventListener('click', testvanillajs);

function testvanillajs(event) {
	console.log('test vanilla js ok!');

	event.preventDefault();

	const testdiv = document.createElement('div');
	testdiv.classList.add("test");

	const newtest = document.createElement('li');
	newtest.innerText = consttestinput.value;
	newtest.classList.add("todo-item");
	testdiv.appendChild(newtest);

	const completedbouton = document.createElement('button');
	completedbouton.innerText = '+';
	completedbouton.classList.add("complete-btn");
	testdiv.appendChild(completedbouton);

	const trashbouton = document.createElement('button');
	trashbouton.innerText= '-';
	trashbouton.classList.add("complete-btn");
	testdiv.appendChild(trashbouton);
	
	consttestlist.appendChild(testdiv);

	consttestinput.value="";
}*/

/**
 * Connexion
 * */
const email = document.querySelector('.email');
const mdp = document.querySelector('.mdp');
const button = document.querySelector(".button");

button.addEventListener('click', connexion);

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

		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				if (xhr.status == 200) {
					var token = JSON.parse(xhr.responseText);
					alert(token.id);
					sessionStorage.setItem('token',JSON.stringify(token));
					location.href = 'listvehicule.html';
				} else {
					document.dyn = "Error code " + xhr.status;
				}
			}
		};

function connexion(e) {
	console.log('connexion tafiditra');
	event.preventDefault();

	console.log(email.value);
	console.log(mdp.value);

    xhr.open("POST", "http://localhost:8081/gestionflotte/admins/login/"+email.value+"/"+mdp.value,true);
	xhr.send(null);

	console.log(location.href);
	 
	// location.href = 'listvehicule.html';

}

/**
 * vanilla js du projet gestion de vehicule
 * */
/*const constnomvehicule = document.querySelector(".nomvehicule");
const constmatriculevehicule = document.querySelector(".matriculevehicule");

const constinsertvehicule = document.querySelector(".insertvehicule");

constinsertvehicule.addEventListener('click', createvehicule);

function createvehicule(event) {
	console.log('test vanilla js create vehicule ok!');

	event.preventDefault();

    var list = document.getElementById("listvehicule");
    console.log('document');

	/*var http = new XMLHttpRequest();
    http.onreadystatechange = function(){
    	console.log('status ok');
        if(this.readyState == 4  && this.status == 200){
            var data = JSON.parse(this.responseText);
            for(var i=0; i<data.length; i++){
                var detailvehicule = document.createElement('div');  
	            detailvehicule.innerText = data[i].idvehicule;
	            detailvehicule.innerText = data[i].datekilometrage;
	            detailvehicule.innerText = data[i].debutkilometrage;
	            detailvehicule.innerText = data[i].finkilometrage;
	            list.appendChild(selectOlona);
	            console.log(data[i].idvehicule);
            console.log(data[i].datekilometrage);
            console.log(data[i].debutkilometrage);
            console.log(data[i].finkilometrage);
            }  
            console.log('okok XMLHttpRequest');
        }
    }
    http.open("GET", "http://localhost:8082/kilometrage", true);
	http.send();*/

	/*var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState !== 4) return;
		if (xhr.status >= 200 && xhr.status < 300) {
			console.log(this.responseText);
		} else {
			console.log('The request failed!');
		}
		console.log('This always runs...');

	};
	xhr.open('GET', 'http://localhost:8082/kilometrage', true);
	xhr.send();

	/*const newtest = document.createElement('li');
	newtest.innerText = consttestinput.value;
	newtest.classList.add("todo-item");
	testdiv.appendChild(newtest);
}*/
