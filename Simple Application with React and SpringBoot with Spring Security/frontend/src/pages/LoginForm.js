import classNames from 'classnames';
import React, { Component } from 'react'

export default class LoginForm extends Component {

    constructor(props) {
        super(props);
        this.state = {
            firstname: "",
            lastname: "",
            email: "",
            password: "",
            active: 'login',
            onLogin: props.onLogin,
            onRegister: props.onRegister
        };
    }

    onChangeHandler = (e) => {
        let name = e.target.name;
        let value = e.target.value;
        this.setState({ [name]: value });
    };

    onSubmitLogin = (e) => {
        this.state.onLogin(e, this.state.email, this.state.password);
    };

    onSubmitRegister = (e) => {
        this.state.onRegister(e, this.state.firstname, this.state.lastname, this.state.email, this.state.password);
    };

    render() {
        return (
            <>
                <div>
                    <button className={classNames('btn', { 'btn-danger': this.state.active === 'login' })} onClick={()=>this.setState({ active: 'login' })}>Login</button>
                    <button className={classNames('btn', { 'btn-danger': this.state.active === 'register' })} onClick={()=>this.setState({ active: 'register' })}>Register</button>
                </div>

                <div className='w-50 mt-5 mx-auto text-dark'>
                    <div className={classNames({ 'd-block': this.state.active === 'login' },{ 'd-none': this.state.active !== 'login' })}>
                        <form onSubmit={this.onSubmitLogin}>
                            <div>
                                <label className='form-label'>Email</label>
                                <input type='text' name='email' onChange={this.onChangeHandler} className='form-control' />
                            </div>

                            <div>
                                <label className='form-label'>Password</label>
                                <input type='password' name='password' onChange={this.onChangeHandler} className='form-control' />
                            </div>

                            <div>
                                <button className='btn btn-danger my-3 w-100'>Sign in</button>
                            </div>
                        </form>
                    </div>


                    <div className={classNames({ 'd-block': this.state.active === 'register' },{ 'd-none': this.state.active !== 'register' })}>
                        <form onSubmit={this.onSubmitRegister}>
                            <div>
                                <label className='form-label'>First Name</label>
                                <input type='text' name='firstname' onChange={this.onChangeHandler} className='form-control' />
                            </div>

                            <div>
                                <label className='form-label'>Last Name</label>
                                <input type='text' name='lastname' onChange={this.onChangeHandler} className='form-control' />
                            </div>

                            <div>
                                <label className='form-label'>Email</label>
                                <input type='text' name='email' onChange={this.onChangeHandler} className='form-control' />
                            </div>

                            <div>
                                <label className='form-label'>Password</label>
                                <input type='password' name='password' onChange={this.onChangeHandler} className='form-control' />
                            </div>

                            <div>
                                <button className='btn btn-danger my-3 w-100'>Register</button>
                            </div>
                        </form>
                    </div>
                </div>
            </>
        )
    }
}

