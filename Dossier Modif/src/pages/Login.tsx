import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar, IonItem, IonLabel, IonInput, IonTabButton, IonList,IonButton } from '@ionic/react';
import { navigate } from 'ionicons/icons';
import React, { useEffect, useState } from 'react';
import { Redirect } from 'react-router';



const Login: React.FC = () => {

  const [email,setEmail] = useState<any | null>(null)
  const [password,setPassword] = useState<any | null>(null)
  const [token,setAdmin] = useState<any | null>(null)
  const connection=(e:any)=>{
    e.preventDefault()
    fetch("http://localhost:8081/gestionflotte/admins/login/" + email + "/" + password,{
      method:"POST"
    })
    .then(res=>res.json())
    .then((result)=>{
      setAdmin(result);
      if (token == null) {  
        alert("admin does not exist");
      } else{
        sessionStorage.setItem('token',JSON.stringify(token));  
        //window.location.replace('/listevehicule');
        window.location.replace('/Page1');

      }
    })
  }

  return (
    <IonPage>
      <IonHeader>
        <IonToolbar>
          <IonTitle>Login</IonTitle>
        </IonToolbar>
      </IonHeader>
      <IonContent>
        <IonList>
          <IonItem>
            <IonLabel position='floating'>Email </IonLabel>
            <IonInput value={email} onIonChange={(e)=>setEmail(e.target.value)} placeholder="entrer votre email"></IonInput>
          </IonItem>

          <IonItem>
            <IonLabel position='floating'>Mot de passe </IonLabel>
            <IonInput value={password} onIonChange={(e)=>setPassword(e.target.value)} type="password" placeholder="mot de passe"></IonInput>
          </IonItem>

          <IonButton href='/listevehicule' onClick={connection} >Login</IonButton>
          
        </IonList>
      </IonContent>
    </IonPage>
  );
};

export default Login;