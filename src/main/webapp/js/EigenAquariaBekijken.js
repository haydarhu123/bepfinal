function EigenAquariaBekijken() {
    fetch("/restservices/Aquarium/EigenAquariaBekijken", {method: 'GET',  headers:{'Authorization': 'Bearer ' + window.sessionStorage.getItem("JWT")}})
        .then(response => response.json())
        .then(function (myJson) {

            alert('gereed!');

            console.log(myJson);

            myJson.forEach( (element) =>
            {
                var tableRef = document.getElementById('aquariaTable').getElementsByTagName('tbody')[0];

                // Insert a row in the table at row index 0
                var newRow   = tableRef.insertRow(tableRef.rows.length);

                // Insert a cell in the row at index 0
                var newCell  = newRow.insertCell(-1);
                // Append a text node to the cell
                var newText  = document.createTextNode(element.naam)
                newCell.appendChild(newText);

                // var newCell2  = newRow.insertCell(-1);
                // // Append a text node to the cell
                // newCell2.innerHTML = element.bewoners.length + " <a href=\"/aquarium/BekijkBewoners.html?aquarium=" + element.naam + "\">Bekijk bewoners</a>";

                // var newText7  = document.createTextNode(element.bewoners.length);
                // newCell7.appendChild(newText7);
                // newcell7.

                var newCell3  = newRow.insertCell(-1);
                // Append a text node to the cell
                var newText3  = document.createTextNode(element.lengte)
                newCell3.appendChild(newText3);

                var newCell4  = newRow.insertCell(-1);
                // Append a text node to the cell
                var newText4  = document.createTextNode(element.breedte)
                newCell4.appendChild(newText4);

                var newCell5  = newRow.insertCell(-1);
                // Append a text node to the cell
                var newText5  = document.createTextNode(element.hoogte)
                newCell5.appendChild(newText5);

                var newCell6  = newRow.insertCell(-1);
                // Append a text node to the cell
                var newText6  = document.createTextNode(element.bodemsoort)
                newCell6.appendChild(newText6);

                var newCell8  = newRow.insertCell(-1);
                // Append a text node to the cell
                var newText8  = document.createTextNode(element.watersoort)
                newCell8.appendChild(newText8);

                // var newCell9  = newRow.insertCell(-1);
                // // Append a text node to the cell
                // newCell9.innerHTML = element.toebehoren.length + " <a href=\"/aquarium/BekijkToebehoren.html?aquarium=" + element.naam + "\">zie toebehoren</a>";
                //
                //
                // var newCell10  = newRow.insertCell(-1);
                // // Append a text node to the cell
                // newCell10.innerHTML = element.ornaments.length + " <a href=\"/aquarium/BekijkOrnaments.html?aquarium=" + element.naam + "\">zie ornaments</a>";
                //
                //
                // var newCell7  = newRow.insertCell(-1);
                // // Append a text node to the cell
                // newCell7.innerHTML = " <input type=\"button\" class=\"btn btn-primary\" onclick=\"verwijderenAquariaAquarium('" + element.naam + "')\" value=\"verwijderAquariumToe\" id=\"verwijderAquariumToeButton\"> ";
                // console.log(element);

            } );

        }).catch(function() {
        console.log("error");


    });


}

var getParams = function (url) {
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
}