
// 获取token
export function getToken() {
    return localStorage.getItem('token');
}

// 设置token
export function setToken(token) {

    localStorage.setItem('token', "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJsb2dpblR5cGUiOiJsb2dpbiIsImxvZ2luSWQiOjEsInJuU3RyIjoiQk1GaVd3eVRGazJaMVJpYTJJU3MzV2NzU2h3b3Z4YVgifQ.LoeT2xWOXMy9e7FClz7UDIgUOb41KYQt1By4iNYT-fs");
}

// 移除token
export function removeToken() {
    localStorage.removeItem('token');
}

// 检查是否已登录
export function isLoggedIn() {
    return !!getToken();
}
