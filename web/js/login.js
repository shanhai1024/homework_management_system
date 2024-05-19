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

    // 获取验证码
    document.getElementById('getLoginSMSButton').addEventListener('click', getSMSCode(true));
    document.getElementById('getRegisterSMSButton').addEventListener('click', getSMSCode(false));

    // 用户注册
    document.getElementById('registerButton').addEventListener('click', register);

};


// 用户登陆
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
            if (JSON.stringify(response.data.code)==200){
                alert("登录成功")
            }
            else {
                Dreamer.success(JSON.stringify(response.data.msg));
            }
        })
        .catch(error => {
            console.log(error);
        });
}

// 注册用户
function register(){

    let phoneNumber = document.getElementById("registerPhone").value;
    let loginSMSCode = document.getElementById("registerSMSCode").value;
    let loginPassword = document.getElementById("registerPassword").value;


    let data = JSON.stringify({
        "phoneNumber": phoneNumber,
        "password": loginPassword,
        "smsCode": loginSMSCode
    });

    let config = {
        method: 'post',
        maxBodyLength: Infinity,
        url: '127.0.0.1:8080/api/v1/register',
        headers: {
            'Content-Type': 'application/json'
        },
        data : data
    };

    axios.request(config)
        .then((response) => {
            console.log(JSON.stringify(response.data));
        })
        .catch((error) => {
            console.log(error);
        });



}

// 获取短信验证码
function getSMSCode(islogin) {
    let phoneNumber
    if(islogin){
        phoneNumber = document.getElementById("phoneNumber").value;
    }else {
        phoneNumber = document.getElementById("registerSMSCode").value;
    }


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

            Dreamer.success(JSON.stringify(response.data.msg));
        })
        .catch(error => {
            console.log(error);
            Dreamer.error(error)
        });
}
