window.onload = () => {

//获取底部菜单最大的盒子元素
    let tabbar = document.getElementById("tabbar");
    //获取所有的菜单div
    let tabbardivs = tabbar.querySelectorAll("div");
    // console.log(divs);
    for (let i = 0; i < tabbardivs.length; i++) {
        tabbardivs[i].onclick = function () {
            let url="";
            switch (i + 1) {
                case 1:
                    url="/OrderingFoodForWebMaven/businessHome.do";
                    break;
                case 2:
                    url="/OrderingFoodForWebMaven/order.do";
                    break;
                case 3:
                    url="/OrderingFoodForWebMaven/pages/business/setting.jsp";
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



    let order = document.getElementById("order");
    var divs = order.querySelectorAll("div");
    for (let i = 0; i < divs.length; i++) {
        divs[i].onclick = function () {
            let url = "";
            switch (i + 1) {
                case 1:
                    url="/OrderingFoodForWebMaven/order.do";
                    break
                case 2:
                    url="/OrderingFoodForWebMaven/orderPro.do";
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





}