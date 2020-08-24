function aquariumToevoegen(){
    let formData = new FormData(document.querySelector("#hettoevoegenvanaquarium"));
    let encData = new URLSearchParams(formData.entries());

    // Get parameters from the current URL



    fetch("/restservices/aquatoevoegen/aquariumToevoegen", {method: 'POST', body: encData, headers:{'Authorization': 'Bearer ' + window.sessionStorage.getItem("JWT")}})
        .then(async response => {
            if(response.status == 200){

                alert("Aquarium is met succes toegevoegd");

            } else{
                alert("Er is iets fout gegaan met het toevoegen van het aquarium, probeer opnieuw");
            }
        })
}