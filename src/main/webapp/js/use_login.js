function register() {
    document.getElementsByClassName("register")[0].style.display="block";
    document.getElementsByClassName("login_box")[0].style.display="none";
}
function login() {
    document.getElementsByClassName("login_box")[0].style.display="block";
    document.getElementsByClassName("register")[0].style.display="none";
}
//XHLHttpRequest是js中专门用来发送请求的一个工具
var xhr = new XMLHttpRequest();
//1.获取id为userName的input框的值
let userNameDOM = document.getElementById("userName");
//显示错误提示的span标签
let userNameMsgDOM = document.getElementById("userNameMsg");
function checkUserName() {
    //获取userName输入框的值
    let userNameValue = userNameDOM.value;
    //当用户名为空的时候，显示错误的提示信息 （用户名不能为空）
    if (userNameValue == "" || userNameValue == null) {
        //用js显示提示文字
        userNameMsgDOM.innerText = "用户名不能为空";
    } else {
        //userNameMsgDOM.innerText="";
        //发送一个请求到后端服务器，校验用户名是否重复  异步请求
        xhr.open("get","http://localhost:8080/OerDingFoodForWeb/busCheckUserName.do?userName="+userNameValue);
        xhr.onreadystatechange=callBack;
        xhr.send(null);
    }
}

//回调函数
function callBack(){
    if (xhr.readyState==4 && xhr.status==200){
        var responseText = xhr.responseText;
        if (responseText==-1){
            userNameMsgDOM
        }
    }
}
