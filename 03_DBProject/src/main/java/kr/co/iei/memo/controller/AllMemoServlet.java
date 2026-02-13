package kr.co.iei.memo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.iei.memo.model.service.MemoService;
import kr.co.iei.memo.model.vo.Memo;

/**
 * Servlet implementation class AllMemoServlet
 */
@WebServlet("/allMemo")
public class AllMemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllMemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩
		request.setCharacterEncoding("UTF-8");
		// 2. 값추출
		// 서블릿 호출시 전달한 데이터가 없으므로 생략
		// 3. 비즈니스로직(서버가 할일 -> DB에서 메모 전체 조회)
		MemoService service =  new MemoService();
		List<Memo> list = service.selectAllMemo();
		System.out.println(list);
		// 4. 결과처리
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title>전체회원조회</title></head><body>");
		out.println("<h1>전체 메모 조회</h1>");
		for(Memo m : list) {
			out.println("<ul>");
			out.println("<li>메모번호 : " + m.getMemoNo() + "</li>");
			out.println("<li>작성자 : " + m.getMemoWriter() + "</li>");
			out.println("<li>작성일 : " + m.getMemoDate() + "</li>");
			out.println("<li>내용 : " + m.getMemoContent() + "</li>");
			out.println("</ul>");
		}
		out.println("<a href='/'>메인으로</a>");
		out.println("</body></html>");
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
