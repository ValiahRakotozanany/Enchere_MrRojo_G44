import {
	IonPage,
	IonHeader,
	IonToolbar,
	IonTitle,
	IonContent,
	IonMenuToggle,
	IonItem,
	IonButton,
	IonRow,
	IonCol

} from '@ionic/react'
import React,{useState,useEffect} from 'react';

const Page1: React.FC = () => {
	const url = "http://localhost:8081/gestionflotte/vehicules";
    const [vehicule,setIdvehicule] = useState<any>([]);
	const getIdvehicule = () => {
		fetch(url, {
	        method: "get",
	        headers: {"Content-type": "application/json"},
	    })
	    .then(response => response.json())
		.then((data) =>{
			
			console.log(data)
			setIdvehicule(data);	
		});
	}

	
	const [detail,setDetail] =useState<any>([]);
	const getdetail = (id: any) => {
		const url1="http://localhost:8081/gestionflotte/kylometrages/"+id;
		fetch(url1, {
	        method: "get",
	        headers: {"Content-type": "application/json"},
	    })
	    .then(response =>{
			return response.json();
		} )
		.then((data) =>{
			window.location.replace('/Tab1/'+id);
			console.log(data)
			setDetail(data);	
		});
	}




	const get1mois = () => {
		const url1="http://localhost:8081/gestionflotte/kylometrages/";
		fetch(url1, {
	        method: "get",
	        headers: {"Content-type": "application/json"},
	    })
	    .then(response =>{
			return response.json();
		} )
		.then((data) =>{
			window.location.replace('/Tab2/');
			console.log(data)
			setDetail(data);	
		});
	}

	const get3mois = () => {
		const url1="http://localhost:8081/gestionflotte/kylometrages/";
		fetch(url1, {
	        method: "get",
	        headers: {"Content-type": "application/json"},
	    })
	    .then(response =>{
			return response.json();
		} )
		.then((data) =>{
			window.location.replace('/Tab3/');
			console.log(data)
			setDetail(data);	
		});
	}


	useEffect(()=>{
		getIdvehicule()
		
	},[])

	return (
		<IonPage>
			<IonHeader>
				<IonToolbar>
					<IonTitle>Les Vehicules </IonTitle>
				</IonToolbar>
			</IonHeader>
			<IonContent className="ion-padding">

			
			{
            vehicule.map((dvehicule:any)=>
              <IonRow>
                <IonCol offset='3' size='2'>{dvehicule.id}</IonCol>
                <IonCol size='2'>{dvehicule.nom}</IonCol>
                <IonCol size='2'>{dvehicule.matricule}</IonCol>
                <IonCol size='2'><IonButton href='/Tab1' onClick={() => getdetail(dvehicule.id)} >Details</IonButton></IonCol>
              </IonRow>
            )
			}
			<IonTitle>Assurance Expiré dans : </IonTitle>
			
			<IonButton href='/Tab2' onClick={() => get1mois()} >1 Mois</IonButton> 
			<IonButton href='/Tab3' onClick={() => get3mois()} >3 Mois</IonButton>          

				{	
						// <table border={1}>
						// 	<tr>
						// 		<th>idvehicule</th>
						// 		<th>dates</th>
						// 		<th>kmdebut</th>
						// 		<th>kmfin</th>
						// 	</tr>
						// 	{
						// 		detail.map((det: any)=>{
						// 			if(det.vehicule.id==etat){
						// 				return(
						// 					<tr>
						// 						<td>{det.vehicule.id}</td>
						// 						<td>{det.dates}</td>
						// 						<td>{det.kmdebut}</td>
						// 						<td>{det.kmfin}</td>
						// 					</tr>
						// 				)
						// 			}
						// 		})
						// 	}
						// </table>
					
				}
				
			</IonContent>
		</IonPage>
	)
}

export default Page1
