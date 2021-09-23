class Members extends React.Component {

    constructor(props) {
        super(props);
    }

    render() {


        this.listItems = users.map((user) => {
            console.log(user)
            console.log(user.hand_up)
            if (user.hand_up) {
                return React.createElement("div", {key: user.id}, user.name,
                    React.createElement("img", {src: "/core/images/raised-hand-icon.png", width: "15", height: "15"}));
            } else {
                return React.createElement("div", {key: user.id}, user.name);
            }
        });

        return React.createElement("div", null, this.listItems);
    }
}