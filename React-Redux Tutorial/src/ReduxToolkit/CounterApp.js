import React from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { decrement, increment } from './counterReducer';

function CounterApp() {

  const counter = useSelector(state => state.counter.value);
  const dispatch=useDispatch()

  return (
    <div style={{textAlign:"center",marginTop:"40px"}}>
        <h2 style={{color:"red"}}>COUNTER APP</h2>

        <button style={{background:"#222",color:"white",padding:"20px"}} onClick={() => dispatch(decrement())}>-</button>
        &emsp;&emsp;{counter}&emsp;&emsp;
        <button style={{background:"#222",color:"white",padding:"20px"}} onClick={() => dispatch(increment())}>+</button>
    </div>
  )
}

export default CounterApp
