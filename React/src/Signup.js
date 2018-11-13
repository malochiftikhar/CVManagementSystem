import React, {Component} from 'react';


class Signup extends Component {
    constructor(){
        super();
        this.state = {
            fName: '',
            lName: '',
            userType: '',
            email: '',
            userName: '',
            password: ''
        };
    }

    render() {
        return (
        <div className="FormCenter">
            <form className="formfields">
                <label className="label">First Name</label>
                <input className="input" placeholder="First Name"/>
                <label className="label">Last Name</label>
                <input className="input"/>
                <label className="label">Role</label>
                <input className="input"/>
                <label className="label">Email</label>
                <input className="input"/>
                <label className="label">Username</label>
                <input className="input"/>
                <label className="label">Password</label>
                <input className="input"/>
            </form>
          </div>
        );
    }
}
export default Signup;