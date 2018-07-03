<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<%-- Java入門 ログイン画面 --%>
<!DOCTYPE html>
<html>
	<head>
		<title>Java入門</title>
		<link href="<c:url value="/css/spring.css" />" rel="stylesheet" />
	</head>
	<body>
		<div class="login_pane">
			<h1>ログイン</h1>
			<p>${input.msg}</p>
			<f:form modelAttribute="input">
				<table class="table_form">
					<tbody>
						<tr>
							<th>ログインID</th>
							<td><f:input path="id"/></td>
						</tr>
						<tr>
							<th>パスワード</th>
							<td><f:password path="password"/></td>
						</tr>
					</tbody>
				</table>
				<input class="common_button" type="submit" value="ログイン"/>
			</f:form>
		</div>
	</body>
</html>