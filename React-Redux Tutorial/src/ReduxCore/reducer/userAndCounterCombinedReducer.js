// reducers.js

const initialState = {
    user: null,
    count: 0,
};

const userReducer = (state = initialState, action) => {
    switch (action.type) {
        case 'SET_USER':
            return {
                ...state,
                user: action.payload,
            };
        case 'INCREMENT':
            return {
                ...state,
                count: state.count + 1,
            };
        case 'DECREMENT':
            return {
                ...state,
                count: state.count - 1,
            };
        default:
            return state;
    }
};

export default userReducer;
