//获取XMLHttpRequest对象(解决浏览器兼容问题)
function getXMLHttpRequest()
{
  try
  {
    //解决大多数浏览器兼容问题
    return new XMLHttpRequest();
  }
  catch (e)
  {
    try
    {
      //解决IE6浏览器兼容问题
      return new ActiveXObject('Msxml2.XMLHTTP');
    }
    catch (e)
    {
      try
      {
        //解决IE5.5及以下版本兼容问题
        return new ActiveXObject('Mcrosoft.XMLHTTP');
      }
      catch (e)
      {
        console.log("你用的啥浏览器");
      }
    }
  }
}

function sendHandler()
{
  //1.获得XMLHttpRequest对象
  var xhr = getXMLHttpRequest();
  //2.和服务器进行连接
  xhr.open('GET', '${pageContext.request.contextPath}/text', true);
  //3.发送请求数据
  xhr.send(null);
  //4.接受服务器响应
  xhr.onreadystatechange = function()
  {
    //交互成功
    if(xhr.status == 200 && xhr.readyState == 4)
    {
      //获取服务器返回字符串
      let data = xhr.responseText;
      //控制台打印输出字符串
      console.log(data);
    }
  }
}