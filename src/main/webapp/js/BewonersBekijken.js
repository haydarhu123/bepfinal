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

function haalallebewonerop() {
    // Get parameters from the current URL
    var params = parameter(window.location.href);
    console.log(params.aquarium);
    fetch("/restservices/Aquarium/bekijkBewoners/" + params.aquarium,{
        method: 'POST',
        headers: {'Authorization': 'Bearer ' + window.sessionStorage.getItem("JWT")}
    })
        .then(response => response.json())
        .then(function (myJson) {

            alert('klaar');

            console.log(myJson);
            //   var d1 = document.getElementById('one');

            // var htmlLink = '<a href="BewonerToevoegen.html?aquarium=' + params.aquarium + '" class="btn btn-info" role="button">Voeg bewoner toe</a>'
            //  d1.insertAdjacentHTML('afterend', htmlLink);

            myJson.forEach((element) => {
                var tableRef = document.getElementById('bewonerTable').getElementsByTagName('tbody')[0];

                // Insert a row in the table at row index 0
                var newRow = tableRef.insertRow(tableRef.rows.length);


                var newCell3 = newRow.insertCell(-1);
                // Append a text node to the cell
                var newText3 = document.createTextNode(element.soortnaam)
                newCell3.appendChild(newText3);

                var newCell4 = newRow.insertCell(-1);
                // Append a text node to the cell
                var newText4 = document.createTextNode(element.kleurnaam)
                newCell4.appendChild(newText4);

                var newCell6 = newRow.insertCell(-1);
                // Append a text node to the cell
                var newText6 = document.createTextNode(element.aantal)
                newCell6.appendChild(newText6);


                console.log(element);
            });


        }).catch(function() {
        console.log("error");



    });
}
