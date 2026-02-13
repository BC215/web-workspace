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
 * Servlet implementation class SearchWriterServlet
 */
@WebServlet("/searchWriter")
public class SearchWriterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchWriterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    String memoWriter = request.getParameter("memoWriter");
	    
	    // 3. 비즈니스로직: 리턴 타입을 List<Memo>로 변경
	    MemoService service = new MemoService();
	    java.util.List<Memo> list = (List<Memo>) service.searchWriter(memoWriter); 
	    
	    // 4. 결과처리
	    response.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    out.println("<!DOCTYPE html><html><head><title>작성자로 조회</title></head><body>");
	    out.println("<h1>메모 조회 결과</h1>");

	    if(!list.isEmpty()) { // 리스트가 비어있지 않은 경우
	        for(Memo m : list) {
	            out.println("<ul>");
	            out.println("<li>메모번호 : " + m.getMemoNo() + "</li>");
	            out.println("<li>작성자 : " + m.getMemoWriter() + "</li>");
	            out.println("<li>작성일 : " + m.getMemoDate() + "</li>");
	            out.println("<li>내용 : " + m.getMemoContent() + "</li>");
	            out.println("</ul><hr>"); // 구분선 추가
	        }
	    } else {
	        out.println("<h2>조회된 메모가 없습니다.</h2>");
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
