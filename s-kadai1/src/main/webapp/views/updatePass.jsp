<!-- WEB-INF/views/updatePass.jsp -->
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
    <title>パスワード変更</title>
</head>
<body>
    <h2>パスワード変更</h2>

    <!-- エラーメッセージ -->
    <c:if test="${not empty errorMessage}">
        <p style="color: red;">${errorMessage}</p>
    </c:if>

    <form action="${pageContext.request.contextPath}/upPassCheck" method="post">
        <label for="password1">新しいパスワード:</label>
        <input type="password" id="password1" name="password1" required><br><br>
        
        <label for="password2">パスワード確認:</label>
        <input type="password" id="password2" name="password2" required><br><br>
        
        <input type="submit" value="変更を確認する">
    </form>
</body>
</html>
