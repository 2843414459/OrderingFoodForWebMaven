window.onload = () => {




    let setting = document.getElementById("setting");
    var settings = setting.querySelectorAll("div");
    for (let i = 0; i < settings.length; i++) {
        settings[i].onclick = function () {
            let url = "";
            switch (i + 1) {
                case 1:
                    url="/OrderingFoodForWebMaven/setting.do";
                    break
                case 2:
                    url="/OrderingFoodForWebMaven/offSetting.do";
                    break
                case 3:
                    url="/OrderingFoodForWebMaven/orderComplete.do";
                    break
                default:
                    break
            }
            location.href=url;
        }

    }

//获取底部菜单最大的盒子元素
    let tabbar = document.getElementById("tabbar");
    //获取所有的菜单div
    let divs = tabbar.querySelectorAll("div");
    // console.log(divs);
    for (let i = 0; i < divs.length; i++) {
        divs[i].onclick = function () {
            let url="";
            switch (i + 1) {
                case 1:
                    url="/OrderingFoodForWebMaven/businessHome.do";
                    break;
                case 2:
                    url="/OrderingFoodForWebMaven/order.do";
                    break;
                case 3:
                    url="/OrderingFoodForWebMaven/setting.do";
                    break;
                case 4:
                    url="/OrderingFoodForWebMaven/pages/business/about.jsp";
                    break;
                default:
                    break
            }
            // req.getRequestDispatcher(url).forward(req,resp);
            location.href=url;
        }
    }

}

function del(orderId){
    console.log(orderId)
    $.ajax({
        url:"/OrderingFoodForWebMaven/onOffsetting.do",
        type:"post",
        data:{
            orderId:orderId
        },
        dataType:"json",//响应回来的数据格式
        success:function (resp) {
            //成功的回调
            // console.log(resp);
            // let res = JSON.parse(resp);
            if (resp.code == 200) {
                //页面刷新
                location.reload();
            }else {
                alert(resp.message)
            }

        }, error:function (){
            //失败的回调
            alert("服务器异常！")
        }
    })
}

function add(orderId){
    console.log(orderId)
    $.ajax({
        url:"/OrderingFoodForWebMaven/onAddSetting.do",
        type:"post",
        data:{
            orderId:orderId
        },
        dataType:"json",//响应回来的数据格式
        success:function (resp) {
            //成功的回调
            // console.log(resp);
            // let res = JSON.parse(resp);
            if (resp.code == 200) {
                //页面刷新
                location.reload();
            }else {
                alert(resp.message)
            }

        }, error:function (){
            //失败的回调
            alert("服务器异常！")
        }
    })
}