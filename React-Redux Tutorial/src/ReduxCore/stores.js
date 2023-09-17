// store.js
import { createStore, combineReducers } from 'redux';
import counterReducer from './reducers/counterReducer';
import userReducer from './reducers/userReducer';

const rootReducer = combineReducers({
  counter: counterReducer,
  user: userReducer,
});

const store = createStore(rootReducer);

export default store;
