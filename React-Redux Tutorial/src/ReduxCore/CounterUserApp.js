// App.js
import React from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { increment, decrement } from './actions/counterActions';
import { setUser } from './actions/userActions';

function App() {
  const count = useSelector((state) => state.counter.count);
  const user = useSelector((state) => state.user.user);
  const dispatch = useDispatch();

  return (
    <div>
      <h1>Counter App</h1>
      <p>Count: {count}</p>
      <button onClick={() => dispatch(increment())}>Increment</button>
      <button onClick={() => dispatch(decrement())}>Decrement</button>

      <h1>User Info</h1>
      <p>User: {user}</p>
      <button onClick={() => dispatch(setUser('John Doe'))}>Set User</button>
    </div>
  );
}

export default App;
