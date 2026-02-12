package kr.co.iei;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PlusServlet
 */
@WebServlet("/plus")
public class PlusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		// -> utf-8로 인코딩 설정(한글처리)
		request.setCharacterEncoding("utf-8");
		//2.값 추출(클라이언트가 서블릿 요청시 보내준 데이터를 추출하는 작업 -> 자바 변수에 저장)
		String num1Str = request.getParameter("num1");
		int num1 = Integer.parseInt(num1Str);
		int num2 = Integer.parseInt(request.getParameter("num2"));
		//3.비즈니스로직(해당 서블릿이 처리해야하는 작업) -> 더하기 서블릿이므로 사용자가 보내준 숫자를 더하는 연산
		int sum = num1 + num2;
		//4.사용자 화면 처리
		// -> 사용자에게 볼 화면을 생성(html을 생성)
		//4.1 응답형식 지정 및 문자셋 세팅
		response.setContentType("text/html; charset=UTF-8");
		//4.2 HTML문서 작성할 수 있는 객체 생성 
		PrintWriter out = response.getWriter();
		//4.3 HTML 생성
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title>더하기 결과</title></head>");
		out.println("<body>");
		out.println("<h1>더하기 결과</h1>");
		out.println("<h3>" + num1 + " + " + num2 + " = " + sum + "</h3>");
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
