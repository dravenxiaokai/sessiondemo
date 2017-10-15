package ren.draven.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class LoginFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {
		// 获取 HttpServletRequest
		HttpServletRequest req2 = (HttpServletRequest) req;
		// 获取 session
		HttpSession session = req2.getSession();

		String user = (String) session.getAttribute("user");
		// 获取请求的地址
		String uri = req2.getRequestURI();
		System.out.println(uri);

		if (user != null) {
			filterChain.doFilter(req2, res);
		} else if (uri.contains("/login")) {
			filterChain.doFilter(req2, res);
		} else {
			req2.getRequestDispatcher("/login.jsp").forward(req, res);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
