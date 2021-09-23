let webSocket = new WebSocket("ws://localhost:8080/loginEndpoint");

let flag = false;

webSocket.onmessage = function (event) {
    let message = JSON.parse(event.data);
    users = message.users;

    let name = $("#name");
    let isConnected = users.find((user) => user.name === name.val());
    if (typeof isConnected != "undefined") {
        alert("User with this name is already connected");
        window.location.reload(true);
    } else if (flag === false) {
        flag = true;
    }
};

function checkName() {

    let json = JSON.stringify({
        "user": null,
        "action": null,
        "content": null,
        "hand_state": null,
        "users": null
    });

    webSocket.send(json);
}


