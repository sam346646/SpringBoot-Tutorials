import axios from "axios";

axios.defaults.baseURL= 'http://localhost:8080'
axios.defaults.headers.post["Content-Type"]='application/json'

export const getAuthToken= () => {
    return window.localStorage.getItem("auth_token");
}

export const setAuthToken= (token) => {
    window.localStorage.setItem("auth_token",token);
}

export const request = (method,url,data) =>{

    let headers={};
    let token=getAuthToken();
    if(token !== null && token !== "null") {
        headers={"Authorization":`Bearer ${token}`}
    }

    return axios(
        {
            method:method,
            headers:headers,
            url:url,
            data:data
        });
};