var parameter = function (url) {
    var params = {};
    var parser = document.createElement('a');
    parser.href = url;
    var query = parser.search.substring(1);
    var vars = query.split('&');
    for (var i = 0; i < vars.length; i++) {
        var pair = vars[i].split('=');
        params[pair[0]] = decodeURIComponent(pair[1]);
    }
    return params;
};


function BewonerToevoegen(){
    let formData = new FormData(document.querySelector("#hettoevoegenvanbewoner"));
    let encData = new URLSearchParams(formData.entries());

    // Get parameters from the current URL
    var para = parameter(window.location.href);
    console.log(para.aquarium);


    fetch("/restservices/aquatoevoegen/bewonerToevoegen/" + para.aquarium, {method: 'POST', body: encData, headers:{'Authorization': 'Bearer ' + window.sessionStorage.getItem("JWT")}})
        .then(async response => {
            if(response.status == 200){

                alert("Het toevoegen van de bewoner is gelukt!");

            } else{
                alert("Er is iets misgegaan met het toevoegen van de bewoner, probeer opnieuw!");
            }
        })


}
