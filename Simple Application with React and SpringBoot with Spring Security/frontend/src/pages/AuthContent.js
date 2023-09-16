import React, { useEffect, useState } from 'react'
import { request } from '../components/axios_helper'

function AuthContent() {

    const [messages,setMessages]=useState();

    useEffect(()=>{
        request("GET","/messages",{})
        .then((response)=>{setMessages(response.data);});
    },[])

    return (
        <div className='card my-3 w-25 mx-auto'>
            <div className="card-body">
                <h3 className='text-secondary'>Backend Response</h3>
                {
                    messages && messages.map((msg)=><p>{msg}</p>)
                }
            </div>
        </div>
    )
}

export default AuthContent
