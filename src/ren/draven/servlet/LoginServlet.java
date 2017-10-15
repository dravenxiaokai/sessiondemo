/** LoginServlet.java **/
package ren.draven.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// super.doPost(req, res); //下面有跳转，这一行得注释掉，不然启动 tomcat 会报错
		System.out.println("----------doPost----------");

		String userName = req.getParameter("userName");
		String userPwd = req.getParameter("userPwd");

		System.out.println(userName);
		System.out.println(userPwd);

		if ("admin".equals(userName) && "admin123".equals(userPwd)) {
			// 登录成功，把账号保存到 session 中
			HttpSession session = req.getSession();
			session.setAttribute("user", userName);

			req.getRequestDispatcher("/index.jsp").forward(req, res);
		} else {
			req.getRequestDispatcher("/fail.jsp").forward(req, res);
		}
	}

}
