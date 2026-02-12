package kr.co.iei;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendData1Servlet
 */
@WebServlet("/sendData1")
public class SendData1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendData1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("서버호출완료333");
		//사용자측에서 servlet으로 데이터를 보냄 -> 요청정보에 포함 -> request객체에서 꺼내야함
		//한글이 있는경우 인코딩 수행
		request.setCharacterEncoding("UTF-8");
		//요청정보중에 전달된 데이터를 추출
		// /sendData1?name=이병창&test=abc
		request.getParameter("name"); // 파라미터 키값을 문자열로 넣어줘야함
		String data1 = request.getParameter("name");
		String data2 = request.getParameter("test");
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
