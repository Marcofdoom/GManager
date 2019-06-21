// Avatar constants
const URL = '35.246.167.88:8888';
// const URL = 'localhost:8080';

const getAllAvatarsConst = { method: "GET", url: `http://${URL}/GManager/api/avatar/getAllAvatars` };
const createAvatarConst = { method: "POST", url: `http://${URL}/GManager/api/avatar/addAvatar` };
const removeAvatarConst = { method: "DELETE", url: `http://${URL}/GManager/api/avatar/deleteAvatar/` };
const updateAvatarConst = { method: "PUT", url: `http://${URL}/GManager/api/avatar/updateAvatar/` };
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

    multi(createAvatarConst.method, createAvatarConst.url, JSON.stringify(avatar)).then(res => {
        console.log(res)
        multi(getAllAvatarsConst.method, getAllAvatarsConst.url).then(res => {
            buildTable(JSON.parse(res), "table_body")
        })
    })
}

function getAllAvatars() {

    let request = new XMLHttpRequest();

    request.onload = function () {
        let movieArray = JSON.parse(request.response);
        console.log(movieArray);
        buildTable(movieArray, "table_body");
    }

    request.open(getAllAvatarsConst.method, getAllAvatarsConst.url);
    request.send();
}

function removeAvatar(id) {

    multi(removeAvatarConst.method, removeAvatarConst.url + id).then(res => {

        console.log(res)
        multi(getAllAvatarsConst.method, getAllAvatarsConst.url).then(res => {
            buildTable(JSON.parse(res), "table_body")
        })
    }
    )
}

function updateAvatar() {

    let avatar = {
        avatarName: document.getElementById("form_avatar_name_update").value,
        className: document.getElementById("form_class_select_update").value,
        avatarLevel: Number(document.getElementById("form_level_update").value)
    }

    console.log(avatar);

    multi(updateAvatarConst.method, updateAvatarConst.url + avatar.avatarName, JSON.stringify(avatar)).then(res => {
        console.log(res)
        multi(getAllAvatarsConst.method, getAllAvatarsConst.url).then(res => {
            buildTable(JSON.parse(res), "table_body")
        })
    })
}

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

function getAvatar() {
    makeRequest(getAvatarConst.method, getAvatarConst.url + document.getElementById('search_bar').value);
}

function buildTable(array, tableId) {

    removeChildren(tableId);
    let parent = document.getElementById(tableId);

    array.forEach(element => {
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
        updateButton.className = "btn btn-secondary";
        updateButton.innerText = 'Update';
        updateButton.id = element.avatarName + '_update';
        updateButton.onclick = populateModalUserDetails;

        updateButton.setAttribute("data-toggle", "modal");
        updateButton.setAttribute("data-target", "#update_modal");

        row.appendChild(cell4);
        cell4.appendChild(updateButton);

        let cell5 = document.createElement('td');
        let removeButton = document.createElement('button');
        removeButton.className = "btn btn-secondary";
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

function populateModalUserDetails() {
    let updateUserName = event.target.id;
    console.log(updateUserName);
    updateUserName = updateUserName.substr(0, updateUserName.indexOf('_'));
    console.log(updateUserName);

    let updateNameBox = document.getElementById('form_avatar_name_update');
    updateNameBox.value = updateUserName;

}

function removeRow() {
    removeAvatar(event.target.id);
}