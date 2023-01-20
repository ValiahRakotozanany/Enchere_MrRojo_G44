import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar,IonButton ,IonRow,IonCol,IonGrid} from '@ionic/react';
import React,{useEffect ,useState} from 'react';
import { useParams } from 'react-router';
import ExploreContainer from '../components/ExploreContainer';
import './Tab1.css';

const Tab1: React.FC = () => {
  const { id } = useParams<{ id: any}>();
  
	const [detail,setDetail] =useState<any>([]);
	const getdetail = () => {
		const url1="http://localhost:8081/gestionflotte/kylometrages/"+id;
		fetch(url1, {
	        method: "get",
	        headers: {"Content-type": "application/json"},
	    })
	    .then(response =>{
			return response.json();
		} )
		.then((data) =>{
			//window.location.replace('/Tab1/'+id);
			console.log(data)
			setDetail(data);	
		});
	}

	useEffect(()=>{
		getdetail()
		
	},[])

  return (
    <IonPage>
    <IonHeader>
      <IonToolbar>
        <IonTitle>Kilometrage</IonTitle>
      </IonToolbar>
    </IonHeader>
    <IonContent>
	<IonGrid>
          <IonRow>
            <IonCol ><strong>id</strong></IonCol>
            <IonCol ><strong>Date </strong></IonCol>
            <IonCol ><strong>Debut Km</strong></IonCol>
			<IonCol ><strong>Fin Km</strong></IonCol>
			</IonRow>
		{
            	
                detail.map((dvehicule:any)=>
                  <IonRow>
                    <IonCol >{dvehicule.id}</IonCol>
                    <IonCol>{dvehicule.dates}</IonCol>
                    <IonCol>{dvehicule.kmdebut}</IonCol>
					<IonCol>{dvehicule.kmfin}</IonCol>
                  </IonRow>
                )
                
}				

            {/* {	
						<table border={1}>
							<tr>
								<th>idvehicule</th>
								<th>dates</th>
								<th>kmdebut</th>
								<th>kmfin</th>
							</tr>
							{
								detail.map((det: any)=>{
										return(
											<tr>
												<td>{det.vehicule}</td>
												<td>{det.dates}</td>
												<td>{det.kmdebut}</td>
												<td>{det.kmfin}</td>
											</tr>
										)
									}
								)
							}
						</table>				
				} */}
				<IonButton href='/Page1' >
				retour
				</IonButton>
</IonGrid>
</IonContent>
		</IonPage>
  );
};

export default Tab1;
