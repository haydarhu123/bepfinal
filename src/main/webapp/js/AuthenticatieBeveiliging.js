function ingelogd(){


    if(window.sessionStorage.getItem("JWT") != null){

        //alert("je bent ingelogd");
        // window.location.href = 'home.html';
    }
    else{
        alert("log in om op de pagina te komen");
        window.location.href = '/index.html';
    }
}

function gaanuitloggen(){
    window.sessionStorage.removeItem('JWT');
    window.location.href = '/index.html'
}
function getRole() {
    fetch("/restservices/Aquarium/getRole", {method: 'POST',  headers:{'Authorization': 'Bearer ' + window.sessionStorage.getItem("JWT")}})
        .then(response => response.json())
        .then(function (myJson) {

            console.log(myJson[0]);

            if(myJson[0] == 'beheerder')
            {
                console.log("true");


            }

        }).catch(function() {
        console.log("error");
    });
}
