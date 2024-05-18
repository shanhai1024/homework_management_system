window.onload = () => {
    let tl = gsap.timeline({ paused: true });

    document.getElementById("switchRegisterPageButton").addEventListener('click', () => {
        tl.to(".round", { duration: 1, x: '200vw', rotation: 360 }, 0)
            .to("main", { duration: 1, x: '-100vw' }, 0);
        tl.play();
    });

    document.getElementById("switchLoginPageButton").addEventListener('click', () => {
        tl.reverse(); // 反向播放动画，回到初始状态
    });

    // 用户登录
    document.getElementById('loginButton').addEventListener('click', login);

    document.getElementById('getLoginSMSButton').addEventListener('click', getSMSCode);
};

function login() {
    let phoneNumber = document.getElementById("phoneNumber").value;
    let loginSMSCode = document.getElementById("loginSMS").value;
    let loginPassword = document.getElementById("loginPassword").value;

    let data = JSON.stringify({
        "phoneNumber": phoneNumber,
        "password": loginPassword,
        "smsCode": loginSMSCode
    });

    let config = {
        method: 'post',
        maxBodyLength: Infinity,
        url: 'http://127.0.0.1:8080/api/v1/login',
        headers: {
            'Content-Type': 'application/json'
        },
        data: data
    };

    axios.request(config)
        .then(response => {
            console.log(JSON.stringify(response.data));
        })
        .catch(error => {
            console.log(error);
        });
}

function getSMSCode() {
    let phoneNumber = document.getElementById("phoneNumber").value;

    let data = JSON.stringify({
        "phoneNumber": phoneNumber
    });

    let config = {
        method: 'post',
        maxBodyLength: Infinity,
        url: 'http://127.0.0.1:8080/api/v1/getSMSCode',
        headers: {
            'Content-Type': 'application/json'
        },
        data: data
    };

    axios.request(config)
        .then(response => {
            console.log(JSON.stringify(response.data));
        })
        .catch(error => {
            console.log(error);
        });
}
