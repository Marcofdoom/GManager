// URL CONSTANTS
const URL = '35.246.167.88:8888';
// const URL = 'localhost:8080';

// PLAYER CONSTANTS
const getAllPlayersConst = { method: "GET", url: `http://${URL}/GManager/api/player/getAllPlayers` };
const getPlayerConst = { method: "GET", url: `http://${URL}/GManager/api/player/getPlayer/` };
const createPlayerConst = { method: "POST", url: `http://${URL}/GManager/api/player/addPlayer` };
const removePlayerConst = { method: "DELETE", url: `http://${URL}/GManager/api/player/deletePlayer/` };
const updatePlayerConst = { method: "PUT", url: `http://${URL}/GManager/api/player/updatePlayer/` };

// PLAYER CRUD FUNCTIONS
// REMOVE PLAYER
function removePlayer(id) {
    multi(removePlayerConst.method, removePlayerConst.url + id).then(res => {

        console.log(res)
        multi(getAllPlayersConst.method, getAllPlayersConst.url).then(res => {
            buildPlayerTable(JSON.parse(res), "table_player_body")
        })
    }
    )
}

// UPDATE PLAYER
function updatePlayer() {
    let player = {
        playerFirstName: document.getElementById("form_first_name_update").value,
        playerLastName: document.getElementById("form_last_name_update").value,
        playerDKP: Number(document.getElementById("form_dkp_update").value)
    }

    if (player.playerFirstName.length == 0) {
        return;
    }

    if (player.playerLastName.length == 0) {
        return;
    }

    console.log(player);
    let id = Number(document.getElementById('form_player_id').value);
    console.log(updatePlayerConst.url + id);

    multi(updatePlayerConst.method, updatePlayerConst.url + id, JSON.stringify(player)).then(res => {
        console.log(res)
        multi(getAllPlayersConst.method, getAllPlayersConst.url).then(res => {
            buildPlayerTable(JSON.parse(res), "table_player_body")
        })
    })
}

// GET ALL PLAYERS
function getAllPlayers() {
    let request = new XMLHttpRequest();

    request.onload = function () {
        let playerArray = JSON.parse(request.response);
        console.log(playerArray);
        buildPlayerTable(playerArray, "table_player_body");
    }

    request.open(getAllPlayersConst.method, getAllPlayersConst.url);
    request.send();
}

// ADD PLAYER
function addPlayer() {
    let player = {
        playerFirstName: document.getElementById("form_first_name").value,
        playerLastName: document.getElementById("form_last_name").value,
        playerDKP: Number(document.getElementById("form_dkp").value)
    }

    if (player.playerFirstName.length == 0) {
        return;
    }

    if (player.playerLastName.length == 0) {
        return;
    }

    multi(createPlayerConst.method, createPlayerConst.url, JSON.stringify(player)).then(res => {
        console.log(res)
        multi(getAllPlayersConst.method, getAllPlayersConst.url).then(res => {
            buildPlayerTable(JSON.parse(res), "table_player_body")
        })
    })
}

// PROMISE
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

// TABLE BUILDERS
// PLAYER TABLE
function buildPlayerTable(array, tableId) {
    removeChildren(tableId);
    let parent = document.getElementById(tableId);

    array.forEach(element => {
        let row = document.createElement('tr');
        parent.appendChild(row);

        let cell1 = document.createElement('td');
        cell1.innerText = element.playerId;
        row.appendChild(cell1);

        let cell2 = document.createElement('td');
        cell2.innerText = element.playerFirstName;
        row.appendChild(cell2);

        let cell3 = document.createElement('td');
        cell3.innerText = element.playerLastName;
        row.appendChild(cell3);

        let cell4 = document.createElement('td');
        cell4.innerText = element.playerDKP;
        row.appendChild(cell4);

        let cell5 = document.createElement('td');
        let updateButton = document.createElement('button');
        updateButton.className = "btn btn-secondary";
        updateButton.innerText = 'Update';
        updateButton.id = element.playerId + '_update';
        updateButton.onclick = populateModalPlayerDetails;

        updateButton.setAttribute("data-toggle", "modal");
        updateButton.setAttribute("data-target", "#player_update_modal");

        row.appendChild(cell5);
        cell5.appendChild(updateButton);

        let cell6 = document.createElement('td');
        let removeButton = document.createElement('button');
        removeButton.className = "btn btn-secondary";
        removeButton.id = element.playerId + '_remove';
        removeButton.innerText = 'Remove';
        removeButton.onclick = removePlayerRow;
        row.appendChild(cell6);
        cell6.appendChild(removeButton);
    });
}

// UTIL FUNCTIONS
function removeChildren(element_id) {
    let myNode = document.getElementById(element_id);
    while (myNode.firstChild) {
        myNode.removeChild(myNode.firstChild);
    }
}

function populateModalPlayerDetails() {
    let updateUserName = event.target.id;
    updateUserName = updateUserName.substr(0, updateUserName.indexOf('_'));

    let request = new XMLHttpRequest();

    request.onload = function () {
        let playerObject = JSON.parse(request.response);

        document.getElementById('form_player_id').value = playerObject.playerId;
        document.getElementById('form_first_name_update').value = playerObject.playerFirstName;
        document.getElementById('form_last_name_update').value = playerObject.playerLastName;
        document.getElementById('form_dkp_update').value = playerObject.playerDKP;
    }

    request.open(getPlayerConst.method, getPlayerConst.url + updateUserName);
    request.send();
}

function removePlayerRow() {
    let player_remove_button_id = event.target.id;
    player_remove_button_id = player_remove_button_id.substr(0, player_remove_button_id.indexOf('_'));

    removePlayer(player_remove_button_id);
}