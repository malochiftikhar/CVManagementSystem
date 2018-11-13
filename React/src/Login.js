import React, {Component} from 'react';

class Login extends Component {
    constructor(props) {
        super(props);
        this.state = {
            email: "iftikharkhana44@gmail.com",
            password: "password",
        };
    }

    componentDidMount() {
        this.login();
    }

    login(){
        const{email, password} = this.state;
    	fetch('http://localhost:8080/api/login', {
            crossDomain:true,
    		method: 'POST',
            body: JSON.stringify({email, password})
    	}).then(response => console.log("This is: " + response))
    }

    render() {
        return ( 
        	<div></div>
        )
    }
}

export default Login;