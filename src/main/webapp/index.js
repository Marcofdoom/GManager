// Avatar constants
const URL = '35.246.167.88:8888';
// const URL = 'localhost:8080';

const getAllAvatarsConst = { method: "GET", url: `http://${URL}/GManager/api/avatar/getAllAvatars` };
const createAvatarConst = { method: "POST", url: `http://${URL}/GManager/api/avatar/addAvatar` };
const removeAvatarConst = { method: "DELETE", url: `http://${URL}/GManager/api/avatar/deleteAvatar/` };
// const getAvatarConst = { method: "GET", url: "http://localhost:8080/guildmanagertwo/api/avatar/getAvatar/" };
// const removeAvatarConst = { method: "DELETE", url: "http://localhost:8080/guildmanagertwo/api/avatar/removeAvatar/" };
// const updateAvatarConst = { method: "PUT", url: "http://localhost:8080/guildmanagertwo/api/avatar/updateAvatar/" };
// const createAvatarConst = { method: "POST", url: "http://localhost:8080/guildmanagertwo/api/avatar/addAvatar" };

// // Player constants
// const getAllPlayersConst = { method: "GET", url: "http://localhost:8080/guildmanagertwo/api/player/getAllPlayers" };
// const getPlayerConst = { method: "GET", url: "http://localhost:8080/guildmanagertwo/api/player/getPlayer/" };
// const createPlayerConst = { method: "POST", url: "http://localhost:8080/guildmanagertwo/api/player/addPlayer" };
// const removePlayerConst = { method: "DELETE", url: "http://localhost:8080/guildmanagertwo/api/player/removePlayer/" };

// Avatar CRUD functions
// CREATE
function addAvatar() {
    let avatar = {
        avatarName: document.getElementById("form_avatar_name").value,
        className: document.getElementById("form_class_select").value,
        avatarLevel: Number(document.getElementById("form_level").value)
    }
    console.log(avatar);
    let request = new XMLHttpRequest();

    request.onload = function () {
        let movieArray = JSON.parse(request.response);
        console.log(movieArray);
    }

    request.open(createAvatarConst.method, createAvatarConst.url);
    request.send(JSON.stringify(avatar));

    // makeRequest(createAvatarConst.method, createAvatarConst.url, JSON.stringify(avatar));
}

// READ
function getAllAvatars() {

    let request = new XMLHttpRequest();

    request.onload = function () {
        let movieArray = JSON.parse(request.response);
        console.log(movieArray);
        buildTable(movieArray, "table_body");
    }

    request.open(getAllAvatarsConst.method, getAllAvatarsConst.url);
    request.send();

    // makeRequest(getAllAvatarsConst.method, getAllAvatarsConst.url);
}



function removeAvatar(id) {

multi(removeAvatarConst.method, removeAvatarConst.url + id).then(res => {

console.log(res)
    //  getAllAvatars()
    multi(getAllAvatarsConst.method,getAllAvatarsConst.url).then(res => {
    
    // console.log(res)
    buildTable(JSON.parse(res), "table_body")   
    })
}
   
)

    // let request = new XMLHttpRequest();

    // request.onload = function () {
    //     let movieArray = JSON.parse(request.response);
    //     console.log(movieArray);
       
    // }

    // request.open(removeAvatarConst.method, removeAvatarConst.url + id);
    // request.send();
}

//promises and request
const multi = (method, url, body) => {

    return new Promise(

        function (res, rej) {

            const req = new XMLHttpRequest();

            req.onload = () => {

                if (req.status === 200) {
                    res(req.response);
                } else {
                    const reason = new Error('Rejected');
                    rej(reason);
                }

            }

            req.open(method, url)

            req.send(body);

        }
    );

}

// var promise = new Promise(function(resolve, reject) {
//   // do a thing, possibly async, then…

//   if (/* everything turned out fine */) {
//     resolve("Stuff worked!");
//   }
//   else {
//     reject(Error("It broke"));
//   }
// });

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

function buildTable(array, tableId) {

    removeChildren(tableId);
    let parent = document.getElementById(tableId);

    array.forEach(element => {
        // let name = element.avatarName;
        let row = document.createElement('tr');
        parent.appendChild(row);

        let cell1 = document.createElement('td');
        cell1.innerText = element.avatarName;
        row.appendChild(cell1);

        let cell2 = document.createElement('td');
        cell2.innerText = element.className;
        row.appendChild(cell2);

        let cell3 = document.createElement('td');
        cell3.innerText = element.avatarLevel;
        row.appendChild(cell3);

        let cell4 = document.createElement('td');
        let updateButton = document.createElement('button');
        updateButton.innerText = 'Update';
        row.appendChild(cell4);
        cell4.appendChild(updateButton);

        let cell5 = document.createElement('td');
        let removeButton = document.createElement('button');
        removeButton.id = element.avatarName;
        removeButton.innerText = 'Remove';
        removeButton.onclick = removeRow;
        row.appendChild(cell5);
        cell5.appendChild(removeButton);
    });
}

function removeChildren(element_id) {
    let myNode = document.getElementById(element_id);
    while (myNode.firstChild) {
        myNode.removeChild(myNode.firstChild);
    }
}

function removeRow() {
    removeAvatar(event.target.id);
    // getAllAvatars();
}