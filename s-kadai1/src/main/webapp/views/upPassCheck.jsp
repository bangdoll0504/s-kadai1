<!-- WEB-INF/views/upPassCheck.jsp -->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String userId = (String) session.getAttribute("userId");
    if (userId == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>パスワード確認</title>
</head>
<body>
    <h2>パスワード変更確認</h2>
    <p>新しいパスワードを確認してください。</p>

    <!-- 新しいパスワード（シークレット） -->
    <p>パスワード: ********</p>
    
    <form action="${pageContext.request.contextPath}/upPassComp" method="post">
        <input type="hidden" name="password" value="${password}">
        <input type="submit" value="変更を確定">
    </form>
</body>
</html>
