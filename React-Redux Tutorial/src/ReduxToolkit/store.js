import { configureStore } from "@reduxjs/toolkit";

import { counterReducer, postReducer } from './counterReducer'

export default configureStore({
    reducer: {
        counter: counterReducer,
        post: postReducer,
    }
})