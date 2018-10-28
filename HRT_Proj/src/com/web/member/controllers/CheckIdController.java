package com.web.member.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.web.dao.MemberDAO;

@WebServlet("/member/CheckId.do")
public class CheckIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String mid = (String) request.getParameter("mid");
		System.out.println("mid �� : " + mid);//���� ���� ���� �� ��ҹ��� üũ �����
		int cnt = 0;
		MemberDAO dao = new MemberDAO();
		cnt = dao.getMember(mid);
		Gson gson = new Gson();
		String cntgson = gson.toJson(cnt);
		response.getWriter().print(cntgson);
	}
}