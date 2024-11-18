<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>エラーページ</title>
</head>
<body>
	<h2>間違っています</h2>
	<p>ユーザーIDまたはパスワードが間違っています。</p>

	<!-- 戻るボタン -->
	<form action="${pageContext.request.contextPath}/view/index.jsp"
		method="get">
		<button type="submit">戻る</button>
	</form>

</body>
</html>
