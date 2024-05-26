
// 获取token
export function getToken() {
    return localStorage.getItem('token');
}

// 设置token
export function setToken(token) {

    localStorage.setItem('token', token);
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