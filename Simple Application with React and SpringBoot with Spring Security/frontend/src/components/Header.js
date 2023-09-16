import React from 'react'
import logo from '../logo.svg'

function Header({title}) {
  return (
    <div className='text-center App-header'>
        <img src={logo} className="App-logo" alt="logo not found" /> <br/>
        <h1>{title}</h1>
    </div>
  )
}

export default Header
