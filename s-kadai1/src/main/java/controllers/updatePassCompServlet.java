package controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import models.UserDAO;

/**
 * Servlet implementation class updatePassCompServlet
 */
@WebServlet("/upPassComp")
public class updatePassCompServlet extends HttpServlet {
	private UserDAO userDAO = new UserDAO();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// レスポンスのエンコーディングを設定
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

        String userId = (String) request.getSession().getAttribute("userId");
        String newPassword = request.getParameter("password");

        if (userDAO.updatePassword(userId, newPassword)) {
            request.setAttribute("message", "パスワード変更が完了しました。");
            request.getRequestDispatcher("views/mainPage.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "データベースに登録できませんでした。");
            request.getRequestDispatcher("views/updatePass.jsp").forward(request, response);
        }
    }
}
