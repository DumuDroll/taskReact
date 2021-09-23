
let currentUser = new User(userName);

let classroom = new WebSocket("ws://localhost:8080/classroomEndpoint");

function onClickHandAction() {

    let content = userName + " - rose hand up";
    let userHand = users.find((user) => user.name === currentUser.name).hand_up;
    if (userHand) {
        content = userName + " - put hand down";
    }
    userHand = !userHand;
    let json = JSON.stringify({
        "user": userName,
        "action": "hand_state",
        "content": content,
        "hand_state":  userHand,
        "users": null
    });
    classroom.send(json);
}

function connect() {
    classroom.onopen = function () {
        let json = JSON.stringify({
            "user": userName,
            "action": "connect",
            "content": userName + " – connected",
            "hand_state": false,
            "users": null
        });
        classroom.send(json)
    };
}

function messageHandler(event) {
    let message = JSON.parse(event.data);
    users = message.users;

    let handTextStatus;

    let hand_state =users.find((user) => user.name === currentUser.name).hand_up;

    if (hand_state === false) {
        handTextStatus = "Raise hand up";
    } else {
        handTextStatus = "Put hand down";
    }

    if (currentUser.name !== message.user) {
        alert(message.content);
    }

    ReactDOM.render(React.createElement(Members, null),
        document.getElementById('users'));

    ReactDOM.render(React.createElement("div", null, handTextStatus),
        document.getElementById('hand-item'));
}

$(document).ready(connect());

classroom.onmessage = function (event) {
    messageHandler(event);
};

function logout() {
    let json = JSON.stringify({
        "user": userName,
        "action": "disconnect",
        "content": userName + " - disconnected",
        "hand_state": false,
        "users": null
    });
    classroom.send(json)
}

classroom.onclose = logout;