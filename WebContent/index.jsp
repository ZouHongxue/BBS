
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="JDBC.News" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>BBS主页</title>
<style type="text/css">
	.footer{
	width:100%;
	height:100px;
	background: gray;
	height:50px;position:fixed;bottom:0px;left:0px;
	margin-top:50px;
	}
	.container{position:relative;width:100%;min-height:100%;}
	.body{padding-bottom:80px;}
	.d1{
			width: 50px;
			height: 50px;
			position: absolute;
			right: 0px;
			top: 200px;
			background: burlywood;
			line-height:50px;
			color:white;
		}
		.d1:hover{
			background: chartreuse;
		}
</style>
<script src="js/jquery3.min.js"></script>
<script type="text/javascript">

	$(function(){
		$("h3").click(function(){
			//alert($(this).attr('id'));
			var id = $(this).attr('id');
			$.ajax({  
	            type:"POST",  
	            url:"count", 
	            data: {
	            	id:id
	            } ,  
	            success:function(data,status){  
	               		alert(status); 
	               		window.location.reload(); 
	            }  
	        });  
	});
	});
	

</script>
</head>
<body style="text-align: center;">
	<%int c= 0; %>
	<div class="container">
		<div style="height:auto;"><%@ include file="pages/header.html" %></div>
		<div style="height:auto; margin:30px;">
			<div style="float:left;">
				<img id="i1" src="img/a.gif"/>
					<ul>
						<li>.NET技术</li>
						<li>编程语言</li>
						<li>软件设计</li>
						<li>Web前端</li>
						<li>企业信息化</li>
						<li>手机开发</li>
						<li>软件工程</li>
						<li>数据库技术</li>
						<li>操作系统</li>
						<li>其他分类</li>
						<li>软件工程</li>
						<li>数据库技术</li>
						<li>操作系统</li>
						<li>其他分类</li>
					</ul>
			</div>
			<% News get = new News();
				ResultSet rs = get.search();
			%>
			<div style="float:left;margin-bottom:200px;margin-left:100px">
					<table id="tb"  height="600" width="600" style="text-align:left;border-collapse:separate; border-spacing:0px 20px;">
					<%
					int[] id = new int[100];
					int i = 0;
					while(rs.next()){ %>
						<!--1-->
						<tr height="20" style="margin-top:20px;">
							<th width="550">
								<%id[i] = rs.getInt("id");
								%>
								<% out.print(rs.getString("title"));%>
							</th>
							<th>
								<h3 style="color:red;" id="<%=id[i]%>">赞</h3>
								<% 
								i++;
								%>
							</th>
						</tr>
						<tr height="50" style="">
							<th>
								<span style="font-size: small;"><% out.print(rs.getString("content"));%></span>
							</th>
							<th>
								<% out.print(rs.getString("count"));%>

							</th>
							
						</tr>
						<%} %>
						<hr/>
						<tr></tr>
					</table>
					
			</div>

		</div>
	
	<div class="d1" ><a href="login.html" target="_blank">管理</a></div>
	
	
	
		<div class="footer" style="height:auto;">
				<span>北京创新乐知信息技术有限公司 版权所有  |  江苏知之为计算机有限公司  江苏乐知网络技术有限公司 提供商务支持</span><br/>
				<span>京ICP证09002463号　京公网安备号：110105000969　京网文[2014]0452-102号</span><br/>
				<span>电信业务审批[2007]字第380号　电信与信息服务业务经营许可证070598号</span><br/>
				<span>Copyright © 1999-2017, CSDN.NET, All Rights Reserved</span>
		</div>
	</div>
	
	
</body>
</html>