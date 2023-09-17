import { createSlice } from "@reduxjs/toolkit";

export const counterSlice=createSlice({
    name: 'counter',
    initialState: {
        value:0
    },
    reducers: {
        increment: state => { state.value += 1 },
        decrement: state => { state.value -= 1 },
        customIncrement: (state,action) => { state.value += action.payload }
    }
})
export const { increment, decrement, customIncrement } = counterSlice.actions
export const { counterReducer }= counterSlice.reducer

export const postSlice=createSlice({
    name: 'post',
    initialState: {
        posts: [{"name":"Nature","place":"mangalore"}, {"name":"Falls","place":"adyar"}]
    },
    reducers: {
        add: (state,action) => { state.posts.push(action.payload) }
    }
})
export const { add } = postSlice.actions
export const { postReducer }= postSlice.reducer