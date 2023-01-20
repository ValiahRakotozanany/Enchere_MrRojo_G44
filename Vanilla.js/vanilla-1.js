/*const constlistvehicule = document.querySelector(".listvehicule");

constlistvehicule.addEventListener('click', createvehicule);*/

function createvehicule() {
	console.log('test vanilla js create vehicule ok!');

	

	var http = new XMLHttpRequest();
    http.onreadystatechange = function(){
    	console.log('status ok');
        if(this.readyState == 4  && this.status == 200){
            var data = JSON.parse(this.responseText);
           	for(var i=0; i<data.length; i++) {
           		const constvehicule = document.getElementById('vehicule');
           		const completedbouton = document.createElement('button');
				completedbouton.innerText = data[i].nom;
				completedbouton.classList.add("complete-btn");
				completedbouton.addEventListener('click',() => {
					var bouton = document.querySelector("button").id.length;
					detailvehicule(bouton)});
				constvehicule.appendChild(completedbouton);// detailvehicule(event,data[i].id)							
           		console.log('idvehicule: '+data[i].idvehicule);
	            console.log('datekilometrage: '+data[i].datekilometrage);
	            console.log('debutkilometrage: '+data[i].debutkilometrage);
	            console.log('finkilometrage: '+data[i].finkilometrage);								
           	}
			   //completedbouton.addEventListener('click',locat(event,data));	
        }
    }
    http.open("GET", "http://localhost:8081/gestionflotte/vehicules", true);
	http.send();

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
	testdiv.appendChild(newtest);*/
}

function locat(data) {
	console.log('tafiditra akato raha ty');
	location.href = 'vehicule.html?data='+data;
}

function detailvehicule(idvehicule) {
	console.log('tafiditra akato raha ty');

	var http = new XMLHttpRequest();
    http.onreadystatechange = function(){
    	console.log('status ok');
        if(this.readyState == 4  && this.status == 200){
            var data = JSON.parse(this.responseText);
           		const constdetailvehicule = document.getElementById('detailvehicule');
           		const detailidvehicule = document.createElement('p');
				detailidvehicule.textContent = data.nom;
				console.log(data.nom+" nom ")
				const detaildatekilometrage = document.createElement('p');
			/*	detaildatekilometrage.textContent = data[0].datekilometrage;
				const detaildebutkilometrage = document.createElement('p');
				detaildebutkilometrage.textContent = data[0].debutkilometrage;
				const detailfinkilometrage = document.createElement('p');
				detailfinkilometrage.textContent = data[0].finkilometrage;*/
				constdetailvehicule.appendChild(detailidvehicule);
			//	constdetailvehicule.appendChild(detaildatekilometrage);
			//	constdetailvehicule.appendChild(detaildebutkilometrage);
			//	constdetailvehicule.appendChild(detailfinkilometrage);

        }
    }
    http.open("GET", "http://localhost:8081/gestionflotte/vehicules/"+idvehicule, true);
	http.send();
}
createvehicule();
