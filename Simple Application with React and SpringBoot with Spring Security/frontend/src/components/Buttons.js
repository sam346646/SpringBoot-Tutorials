import React from 'react'

function Buttons(props) {
    return (
        <div className='my-3'>
            <button className='btn btn-secondary me-3' onClick={props.login}>LOGIN</button>
            <button className='btn btn-light me-3' onClick={props.logout}>LOGOUT</button>
        </div>
    )
}

export default Buttons
