<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>新月博客</title>
<meta name="keywords" content="原作者：杨青" />
<meta name="description" content="原作者：杨青" />
<link href="./hynBlog/css/base.css" rel="stylesheet">
<link href="./hynBlog/css/msh.css" rel="stylesheet">
<!--[if lt IE 9]>
<script src="./hynBlog/js/modernizr.js"></script>
<![endif]-->
<script src="./hynBlog/js/scrollReveal.js"></script>
</head>
<body>
<header>
  <div class="logo" data-scroll-reveal="enter right over 1s"><a href="/"><img src="images/logo.png"></a></div>
  <nav class="topnav" data-scroll-reveal="enter bottom over 1s after 0.5s"><span>该程序员找不到对象</span></nav>
  <nav class="topnav" data-scroll-reveal="enter bottom over 1s after 0.5s">
  <a href="#" onclick="document.getElementById('subform1').submit();return false">
      <span><form id="subform1" action="Blogindex">我的博客</form></span><span class="en">Home</span></a>
  <a href="hynBlog/myresume.html"><span>我的简历</span><span class="en">my resume</span></a>
  <a href="#" onclick="document.getElementById('subform3').submit();return false">
      <span><form id="subform3" action="hyntopic">我的博文</form></span><span class="en">Topic</span></a>
  <a href="./saying.html"><span>留言</span><span class="en">Saying</span></a></nav>
</header>
<article>
  <div class="container">
    <h2 class="ctitle"><b>文章分类</b></h2>
    <div class="photowall">
      <ul class="wall_a">
      <c:forEach items="${ categoryList }" var="category">
        <li><a href="/"><img src="images/p02.jpg">
          <figcaption>
            <h2>${category.categoryName} </h2>
          </figcaption>
          </a></li>
      </c:forEach> 
      </ul>
    </div>
    <ul class="cbp_tmtimeline">
    <c:forEach items="${ topicList }" var="topic">
      <li>
        <time class="cbp_tmtime"><span>${ topic.topicTitle }</span> <span>${ topic.createTime }</span></time>
        <div class="cbp_tmicon"></div>
        <div class="cbp_tmlabel" data-scroll-reveal="enter right over 1s" >
          <h2>${ topic.topicTitle }</h2>
          <p><span class="blogpic"><a href="/"><img src="images/t03.jpg"></a></span>${ topic.topicText }</p>
          <a href="/" target="_blank" class="readmore">阅读全文&gt;&gt;</a> </div>
      </li>
    </c:forEach>
    </ul>
    <div class="page"><a title="Total record"><b>107</b> </a><b>1</b><a href="/news/index_2.html">2</a><a href="/news/index_3.html">3</a><a href="/news/index_4.html">4</a><a href="/news/index_5.html">5</a><a href="/news/index_2.html">&gt;</a><a href="/news/index_5.html">&gt;&gt;</a></div>
  </div>
  </aside>
</article>
<footer> Design by DanceSmile <a href="/">蜀ICP备11002373号-1</a> </footer>
<script>
  if (!(/msie [6|7|8|9]/i.test(navigator.userAgent))){
    (function(){
      window.scrollReveal = new scrollReveal({reset: true});
    })();
  };
</script>
</body>
</html>
