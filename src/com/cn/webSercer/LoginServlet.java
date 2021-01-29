package com.cn.webSercer;

import com.cn.webSercer.core.Request;
import com.cn.webSercer.core.Response;
import com.cn.webSercer.core.Servlet;

public class LoginServlet implements Servlet {

	@Override
	public void service(Request request, Response response) {
		response.print("<html>");
		response.print("<head>");
		response.print("<title>");
		response.print("第一个servlet");
		response.print("</title>");
		response.print("</head>");
		response.print("<body>");
		response.print("欢迎回来了。"+request.getParameter("uname"));
		response.print("</body>");
		response.print("</html>");
	}

	@Override
	public void doGET() {

	}


}
