function ingelogd(){
    let formData = new FormData(document.querySelector("#inloggenvangebruiker"));
    let encData = new URLSearchParams(formData.entries());
    fetch("/restservices/authentication", { method: 'POST', body: encData })
        .then(async response => {
            if(response.status == 200){
                json = await response.json();

                window.sessionStorage.setItem('JWT', json.JWT);


                alert("U bent ingelogd!");
                window.location.href = '../EigenAquariaBekijken.html';
            } else{
                alert("De ingevoerde Email en wachtwoord komen niet overeen, probeer opnieuw!");
            }
        })


}



