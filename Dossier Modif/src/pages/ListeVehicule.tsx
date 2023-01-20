import React, { useEffect, useState } from 'react';
import { IonCol, IonGrid, IonRow, IonPage, IonHeader, IonToolbar, IonTitle,IonButton, IonContent } from '@ionic/react';

const ListeVehicule: React.FC = () => {

  const token = sessionStorage.getItem('token');
  const [vehicule, setVehicule] = useState<any>([]);
  if (token == null) {
    window.location.replace('/login');
  } else {
    // useEffect(()=>{
    //   fetch("http://localhost:8081/gestionflotte/vehicules", {
    //     method: "GET"
    //   })
    //     .then(res => res.json())
    //     .then((result) => {
    //       setVehicule(result);
    //     })
    // },[]);
  }

  return (
    <IonPage>
      <IonHeader>
        <IonToolbar>
          <IonTitle>Liste vehicule</IonTitle>
        </IonToolbar>
      </IonHeader>
      <IonContent className="ion-padding">
        <IonGrid>
          <IonRow>
            <IonCol offset='3' size='2'><strong>id</strong></IonCol>
            <IonCol size='2'><strong>matricule</strong></IonCol>
            <IonCol size='2'><strong>nom</strong></IonCol>
          </IonRow>
          {
            vehicule.map((veh:any)=>
              <IonRow>
                <IonCol offset='3' size='2'>{veh.id}</IonCol>
                <IonCol size='2'>{veh.nom}</IonCol>
                <IonCol size='2'>{veh.matricule}</IonCol>
                <IonCol size='2'><IonButton>details</IonButton></IonCol>
              </IonRow>
            )
          }
        </IonGrid>
      </IonContent>
    </IonPage>
  );
};

export default ListeVehicule;
