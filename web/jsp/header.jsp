﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>XXX网络商城</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
	</head>

	<body>
		<div class="container-fluid">

			<!--
            	描述：菜单栏
            -->
			<div class="container-fluid">
				<div class="col-md-4">
					<img src="${pageContext.request.contextPath}/img/logo2.png" />
				</div>
				<div class="col-md-5">
					<img src="${pageContext.request.contextPath}/img/header.png" />
				</div>
				<div class="col-md-3" style="padding-top:20px">
					<ol class="list-inline">

						<c:if test="${empty loginUser}">
						<li><a href="${pageContext.request.contextPath}/userServlet?method=loginUI">登录</a></li>
						<li><a href="${pageContext.request.contextPath}/userServlet?method=registUI">注册</a></li>
						</c:if>
						<c:if test="${not empty loginUser}">

						<li>欢迎 ${loginUser.username}</li>
						<li><a href="${pageContext.request.contextPath}/userServlet?method=userLogout">退出</a></li>
						</c:if>
						<li><a href="${pageContext.request.contextPath}/jsp/cart.jsp">购物车</a></li>
						<li><a href="${pageContext.request.contextPath}/orderServlet?method=findMyOrdersWithPage&num=1">我的订单</a></li>
					</ol>
				</div>
			</div>


			<!--
                            描述：导航条
                        -->
			<div class="container-fluid">
				<nav class="navbar navbar-inverse">
					<div class="container-fluid">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="#">首页</a>
						</div>

						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav" id="myURL">
								<%--<li class="active"><a href="${pageContext.request.contextPath}/jsp/product_list.jsp">手机数码<span class="sr-only">(current)</span></a></li>--%>
								<%--<c:forEach items="${allCats}" var="c">--%>
									<%--<li><a href="#">${c.cname}</a></li>--%>

								<%--</c:forEach>--%>
							</ul>
							<form class="navbar-form navbar-right" role="search">
								<div class="form-group">
									<input type="text" class="form-control" placeholder="Search">
								</div>
								<button type="submit" class="btn btn-default">Submit</button>
							</form>

						</div>
						<!-- /.navbar-collapse -->
					</div>
					<!-- /.container-fluid -->
				</nav>
			</div>


		</div>
	</body>

<script>
    $(function () {
        //如果用户频繁的访问, 那总访问db效率太低
        //像服务端CategoryServlet _getAllCategory 发起请求,服务端经过处理将所有分类信息返回json,获取所有分类并绑定
            var url = "/categoryServlet"
            var object = {"method":"getAllCats"}
            $.post(url,object,function (data){
                // alert(data)
				//获取服务端相应回的数据,data存放的是数组
				//遍历数组 动态显示分类区
				$.each(data,function (i, obj) {
                    var li = "<li><a href='/productServlet?method=findProductsByCidWithPage&num=1&cid=" + obj.cid + "'>" + obj.cname + " </a></li>"
					$("#myURL").append(li)
                }
                )
            },"json")
        }
        
    )


</script>

</html>