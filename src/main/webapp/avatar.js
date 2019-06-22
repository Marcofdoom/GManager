// URL CONSTANTS
const URL = '35.246.167.88:8888';
// const URL = 'localhost:8080';

// AVATAR CONSTANTS
const getAllAvatarsConst = { method: "GET", url: `http://${URL}/GManager/api/avatar/getAllAvatars` };
const getAvatarConst = { method: "GET", url: `http://${URL}/GManager/api/avatar/getAvatar/` };
const createAvatarConst = { method: "POST", url: `http://${URL}/GManager/api/avatar/addAvatar` };
const removeAvatarConst = { method: "DELETE", url: `http://${URL}/GManager/api/avatar/deleteAvatar/` };
const updateAvatarConst = { method: "PUT", url: `http://${URL}/GManager/api/avatar/updateAvatar/` };

// AVATAR CRUD FUNCTIONS
// CREATE
function addAvatar() {
    let avatar = {
        avatarName: document.getElementById("form_avatar_name").value,
        className: document.getElementById("form_class_select").value,
        avatarLevel: Number(document.getElementById("form_level").value)
    }

    if (avatar.avatarName.length == 0) {
        return;
    }

    if (avatar.className.length == 0) {
        return;
    }

    multi(createAvatarConst.method, createAvatarConst.url, JSON.stringify(avatar)).then(res => {
        console.log(res)
        multi(getAllAvatarsConst.method, getAllAvatarsConst.url).then(res => {
            buildAvatarTable(JSON.parse(res), "table_avatar_body")
        })
    })
}

// GET ALL AVATARS
function getAllAvatars() {
    let request = new XMLHttpRequest();

    request.onload = function () {
        let avatarArray = JSON.parse(request.response);
        console.log(avatarArray);
        buildAvatarTable(avatarArray, "table_avatar_body");
    }

    request.open(getAllAvatarsConst.method, getAllAvatarsConst.url);
    request.send();
}

// REMOVE AVATAR
function removeAvatar(id) {
    multi(removeAvatarConst.method, removeAvatarConst.url + id).then(res => {

        console.log(res)
        multi(getAllAvatarsConst.method, getAllAvatarsConst.url).then(res => {
            buildAvatarTable(JSON.parse(res), "table_avatar_body")
        })
    }
    )
}

// UPDATE AVATAR
function updateAvatar() {
    let avatar = {
        avatarName: document.getElementById("form_avatar_name_update").value,
        className: document.getElementById("form_class_select_update").value,
        avatarLevel: Number(document.getElementById("form_level_update").value)
    }

    if (avatar.avatarName.length == 0) {
        return;
    }

    if (avatar.className.length == 0) {
        return;
    }

    if (avatar.avatarLevel == 0) {
        return;
    }

    console.log(avatar);

    multi(updateAvatarConst.method, updateAvatarConst.url + avatar.avatarName, JSON.stringify(avatar)).then(res => {
        console.log(res)
        multi(getAllAvatarsConst.method, getAllAvatarsConst.url).then(res => {
            buildAvatarTable(JSON.parse(res), "table_avatar_body")
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

// AVATAR TABLE
function buildAvatarTable(array, tableId) {
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
        updateButton.onclick = populateModalAvatarDetails;
        updateButton.setAttribute("data-toggle", "modal");
        updateButton.setAttribute("data-target", "#update_modal");

        row.appendChild(cell4);
        cell4.appendChild(updateButton);

        let cell5 = document.createElement('td');
        let removeButton = document.createElement('button');
        removeButton.className = "btn btn-secondary";
        removeButton.id = element.avatarName + '_remove';
        removeButton.innerText = 'Remove';
        removeButton.onclick = removeAvatarRow;
        row.appendChild(cell5);
        cell5.appendChild(removeButton);
    });
}

// UTIL FUNCTIONS
function removeChildren(element_id) {
    let myNode = document.getElementById(element_id);
    while (myNode.firstChild) {
        myNode.removeChild(myNode.firstChild);
    }
}

function populateModalAvatarDetails() {
    let updateUserName = event.target.id;
    updateUserName = updateUserName.substr(0, updateUserName.indexOf('_'));

    let request = new XMLHttpRequest();

    request.onload = function () {
        let avatarObject = JSON.parse(request.response);

        document.getElementById('form_avatar_name_update').value = avatarObject.avatarName;
        document.getElementById('form_class_select_update').value = avatarObject.className;
        document.getElementById('form_level_update').value = avatarObject.avatarLevel;
    }

    request.open(getAvatarConst.method, getAvatarConst.url + updateUserName);
    request.send();
}

function removeAvatarRow() {
    let avatar_remove_button_id = event.target.id;
    avatar_remove_button_id = avatar_remove_button_id.substr(0, avatar_remove_button_id.indexOf('_'));

    removeAvatar(avatar_remove_button_id);
}