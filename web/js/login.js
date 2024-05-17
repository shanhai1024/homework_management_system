window.onload = unit => {
    let tl = gsap.timeline();


    document.getElementById("switchRegisterPageButton")
        .addEventListener('click', unit=>{
            tl.to(".round", {duration: 1, x: '200vw', rotation: 360}, 0)
                .to("main", {duration: 1, x: '-100vw'},0);
            tl.play()

        })



    document.getElementById("switchLoginPageButton")
        .addEventListener('click', unit=>{

            tl.reverse(); // 反向播放动画，回到初始状态
        })

}