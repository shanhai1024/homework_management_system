
// 获取token
export function getToken() {
    return localStorage.getItem('token');
}

// 设置token
export function setToken(token) {

    localStorage.setItem('token', "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJsb2dpblR5cGUiOiJsb2dpbiIsImxvZ2luSWQiOjEsInJuU3RyIjoiWFFIZU9yMUxFVktTWFdOYnhPeHA2WVZjUHo2VFZTRXMifQ.BS76p-LcPIi1NAKqCOesPRMW0MV84ZnVKxLU0ghUXOA");
}

// 移除token
export function removeToken() {
    localStorage.removeItem('token');
}

// 检查是否已登录
export function isLoggedIn() {
    return !!getToken();
}

export default class router {
}