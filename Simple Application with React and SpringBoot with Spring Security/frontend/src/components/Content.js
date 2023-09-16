import React, { Component } from 'react'

import WelcomeContent from '../pages/WelcomeContent'
import AuthContent from '../pages/AuthContent'
import LoginForm from '../pages/LoginForm'
import Buttons from './Buttons'
import { request, setAuthToken } from './axios_helper'

export class Content extends Component {

  constructor(props) {
    super(props);
    this.state={
      componetToShow: "welcome"
    };
  };

  login = () =>{
    this.setState({componetToShow: "login"});
  };

  logout = () =>{
    this.setState({componetToShow: "welcome"});
  };

  onLogin = (e, email, password) =>{
    e.preventDefault();
    request("POST","/login",{email:email,password:password})
    .then((response) => { this.setState({componetToShow: "messages"} ); setAuthToken(response.data.token);})
    .catch((error) => { this.setState({componetToShow: "login"} )});
  };

  onRegister = (e, firstname, lastname, email, password) =>{
    e.preventDefault();
    request("POST","/register",{firstname:firstname,lastname:lastname,email:email,password:password})
    .then((response) => { this.setState({componetToShow: "messages"} ); setAuthToken(response.data.token);})
    .catch((error) => { this.setState({componetToShow: "login"} )});
  };

  render() {
    return (
      <div className='text-center pt-3 text-danger'>
        { this.state.componetToShow==="welcome" && <WelcomeContent /> }
        { this.state.componetToShow==="messages" && <AuthContent /> }
        { this.state.componetToShow==="login" && <LoginForm onLogin={this.onLogin} onRegister={this.onRegister} /> }
        <Buttons login={this.login} logout={this.logout} />
      </div>
    )
  }
}

export default Content
