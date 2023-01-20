import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar,IonRow,IonCol,IonGrid  } from '@ionic/react';
import ExploreContainer from '../components/ExploreContainer';
import React,{useEffect ,useState} from 'react';
import './Tab3.css';

const Tab3: React.FC = () => {
  


  const [assurance,setAssurance] =useState<any>([]);
	const getAssurance = () => {
		const url1="http://localhost:8081/assurance/Assurance3";
		fetch(url1, {
	        method: "post",
	        headers: {"Content-type": "application/json"},
	    })
	    .then(response =>{
			return response.json();
		} )
		.then((data) =>{
			//window.location.replace('/Tab1/'+id);
			console.log(data)
			setAssurance(data);	
		});
	}

	useEffect(()=>{
		getAssurance()
		
	},[])




  return (
    <IonPage>
    <IonHeader>
      <IonToolbar>
        <IonTitle> 3 mois :Assurance expiré  </IonTitle>
      </IonToolbar>
    </IonHeader>
    <IonContent>
    <IonGrid>
          <IonRow>
            <IonCol ><strong>Vehicule</strong></IonCol>
            <IonCol ><strong>numero </strong></IonCol>
            <IonCol ><strong>Debut</strong></IonCol>
            <IonCol ><strong>Expiration le : </strong></IonCol>
			<IonCol ><strong>Fin Km</strong></IonCol>
			</IonRow>
		{
            	
              assurance.map((dvehicule:any)=>
                  <IonRow>
                    <IonCol >{dvehicule.vehicule}</IonCol>
                    <IonCol>{dvehicule.numero}</IonCol>                    
                    <IonCol>{dvehicule.date_debut}</IonCol>
                    <IonCol>{dvehicule.date_fin}</IonCol>
					<IonCol>{dvehicule.kmfin}</IonCol>
                  </IonRow>
                )
                
}	</IonGrid>
</IonContent>
		</IonPage> 
  );
};

export default Tab3;
