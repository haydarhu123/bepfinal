function Accountaanmaken(){
    let formData = new FormData(document.querySelector("#hetmakenvaneennieuweaccount"));
    let encData = new URLSearchParams(formData.entries());
    fetch("/restservices/account/register", { method: 'POST', body: encData })
        .then(async response => {
            if(response.status == 200){
                json = await response.json();
                alert("Het aanmaken van een account is gelukt!");

            } else{
                alert("Het aanmaken van een account is niet gelukt, probeer opnieuw.");
            }
        })
}
