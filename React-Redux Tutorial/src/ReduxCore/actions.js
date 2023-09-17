//counter
export const increment = () => {
    return {
        type: 'INCREMENT',
    };
};
export const decrement = () => {
    return {
        type: 'DECREMENT',
    };
};

// userActions.js
export const setUser = (user) => {
    return {
        type: 'SET_USER',
        payload: user,
    };
};
