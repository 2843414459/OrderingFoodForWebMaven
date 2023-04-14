//接单函数
function takeOrder(orderId){
    //发送异步请求
    $.ajax({
        url:"/OrderingFoodForWebMaven/takeOrder.do",//请求地址
        type:"get",//请求方式
        data:{
            orderId:orderId
        },//请求参数
        // dataType:"json",//响应回来的数据格式
        success:function (resp) {
            //成功的回调
            console.log(resp);
            let res = JSON.parse(resp);
            if (res.code == 200) {
                //页面刷新
                location.reload();
            }else {
                alert(res.message)
            }

        },
        error:function (){
            //失败的回调
            alert("服务器异常！")
        }
    })
}