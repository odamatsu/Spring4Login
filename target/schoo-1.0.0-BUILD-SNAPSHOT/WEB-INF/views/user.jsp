<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- Java入門 ユーザ画面 --%>
<!DOCTYPE html>
<html>
	<head>
		<title>Java入門</title>
		<link href="<c:url value="/css/spring.css" />" rel="stylesheet" />
	</head> 
	<body>
		<div class="login_pane">
			<h1>ログインに成功しました！</h1>
			<table class="table_list">
				<tbody>
					<tr>
						<th>id</th><td>${output.id}</td>
					</tr>
					<tr>
						<th>名前</th><td>${output.name}</td>
					</tr>
					<tr>
						<th>年齢</th><td>${output.age}</td>
					</tr>
				</tbody>
			</table>
			<form action="/schoo">
				<input class="common_button" type="submit" value="戻る">
			</form>
		</div>
	</body>
</html>