// // Avatar constants
const URL = '35.246.104.241:8888';

const getAllAvatarsConst = { method: "GET", url: `http://${URL}/GManager/api/avatar/getAllAvatars` };
// const getAvatarConst = { method: "GET", url: "http://localhost:8080/guildmanagertwo/api/avatar/getAvatar/" };
// const removeAvatarConst = { method: "DELETE", url: "http://localhost:8080/guildmanagertwo/api/avatar/removeAvatar/" };
// const updateAvatarConst = { method: "PUT", url: "http://localhost:8080/guildmanagertwo/api/avatar/updateAvatar/" };
// const createAvatarConst = { method: "POST", url: "http://localhost:8080/guildmanagertwo/api/avatar/addAvatar" };

// // Player constants
// const getAllPlayersConst = { method: "GET", url: "http://localhost:8080/guildmanagertwo/api/player/getAllPlayers" };
// const getPlayerConst = { method: "GET", url: "http://localhost:8080/guildmanagertwo/api/player/getPlayer/" };
// const createPlayerConst = { method: "POST", url: "http://localhost:8080/guildmanagertwo/api/player/addPlayer" };
// const removePlayerConst = { method: "DELETE", url: "http://localhost:8080/guildmanagertwo/api/player/removePlayer/" };

// // Avatar CRUD functions
// // CREATE
// function addAvatar() {
//     let avatar = {
//         avatarName: document.getElementById("form_avatar_name").value,
//         className: document.getElementById("form_class_select").value,
//         avatarLevel: document.getElementById("form_level").value
//     }

//     makeRequest(createAvatarConst.method, createAvatarConst.url, JSON.stringify(avatar));
// }

// // READ
function getAllAvatars() {

    let request = new XMLHttpRequest();

    request.onload = function () {
        movieArray = JSON.parse(request.response);
        console.log(movieArray);
        // buildTable(movieArray, "table_body");
    }

    request.open(getAllAvatarsConst.method, getAllAvatarsConst.url);
    request.send();

    // makeRequest(getAllAvatarsConst.method, getAllAvatarsConst.url);
}

function getAvatar() {
    makeRequest(getAvatarConst.method, getAvatarConst.url + document.getElementById('search_bar').value);
}

// // UPDATE
// function updateAvatar() {
//     let avatar = {
//         avatarName: document.getElementById("form_avatar_name").value,
//         className: document.getElementById("form_class_select").value,
//         avatarLevel: document.getElementById("form_level").value
//     }

//     makeRequest(updateAvatarConst.method, updateAvatarConst.url + document.getElementById('search_bar').value, JSON.stringify(avatar));
// }

// // DELETE
// function removeAvatar() {
//     makeRequest(removeAvatarConst.method, removeAvatarConst.url + document.getElementById('search_bar').value);
// }

// // Player CRUD functions
// // CREATE
// function addPlayer() {
//     let player = {
//         playerFirstName: document.getElementById("form_player_first_name").value,
//         playerLastName: document.getElementById("form_player_last_name").value,
//         playerDKP: document.getElementById("form_player_dkp").value
//     }

//     makeRequest(createPlayerConst.method, createPlayerConst.url, JSON.stringify(player));
// }

// // READ
// function getAllPlayers() {
//     let request = new XMLHttpRequest();

//     request.onload = function () {
//         movieArray = JSON.parse(request.response);
//         console.log(movieArray);
//         buildTable(movieArray, "table_player");
//     }

//     request.open(getAllPlayersConst.method, getAllPlayersConst.url);
//     request.send();

//     // makeRequest(getAllPlayersConst.method, getAllPlayersConst.url);
// }

// function getPlayer() {
//     makeRequest(getPlayerConst.method, getPlayerConst.url + document.getElementById('form_avatar_player').value);
// }

// // UPDATE
// function updatePlayer() {
//     let player = {
//         playerFirstName: document.getElementById("form_player_first_name").value,
//         playerLastName: document.getElementById("form_player_last_name").value,
//         playerDKP: document.getElementById("form_player_dkp").value
//     }

//     makeRequest(updateAvatarConst.method, updateAvatarConst.url + document.getElementById('search_bar').value, JSON.stringify(player));
// }

// // DELETE
// function removePlayer() {
//     makeRequest(removePlayerConst.method, removePlayerConst.url + document.getElementById('form_avatar_player').value);
// }

// // UTIL
// function makeRequest(method, url, body) {

//     let request = new XMLHttpRequest();

//     request.onload = function () {
//         let response = JSON.parse(request.responseText);
//         console.log(response);
//     }

//     request.open(method, url);
//     request.send(body);
// }

// function buildTable(movieArray, tableId) {

//     removeChildren(tableId);
//     let parent = document.getElementById(tableId);

//     movieArray.forEach(element => {
//         let row = document.createElement('tr');
//         parent.appendChild(row);

//         let cell1 = document.createElement('td');
//         cell1.innerText = element.avatarName;
//         row.appendChild(cell1);

//         let cell2 = document.createElement('td');
//         cell2.innerText = element.className;
//         row.appendChild(cell2);

//         let cell3 = document.createElement('td');
//         cell3.innerText = element.avatarLevel;
//         row.appendChild(cell3);
//     });
// }

// function populateDescription() {
//     const x = event.target.id;

//     let paragraph = document.getElementById('description');
//     paragraph.innerText = JSON.stringify(movieArray.Search[x], null, 2);
// }

// function removeChildren(element_id) {
//     let myNode = document.getElementById(element_id);
//     while (myNode.firstChild) {
//         myNode.removeChild(myNode.firstChild);
//     }
// }