package kr.co.iei;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendData3Servlet
 */
@WebServlet("/sendData3")
public class SendData3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendData3Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//문자열
		String str = request.getParameter("str");
		Object integer;
		
		//숫자(정수)
		//클라이언트에서 보낸 데이터는 무조건 문자열
		//숫자로 사용하고 싶다면 -> 형변환 -> wrapper class(Boolean,Integer,Double 등)
		String numString = request.getParameter("num");
		int num = Integer.parseInt(numString);
		
		//radio : 라디오중 raido의 value값
		String gender = request.getParameter("gender");
		
		//checkbox : 체크된 값들이 배열로 값을 전달
		// -> 동일한 name으로 여러개가 선택가능
		// -> 동일한 name으로 전송되는 문자열이 여러개 -> String[] 배열로 받아야함
		// -> request.getParameter("name"); -> String을 리턴
		// -> request.getParameterValues("name"); -> 문자열 배열 리턴
		
		String[] hobbys = request.getParameterValues("hobby");
		
		//select : selcet태그의 name으로 선택한	 option태그의 value값이 전달
		String age = request.getParameter("age");
		
		//textarea : 서버에서는 input과 동일
		String comment = request.getParameter("comment");
		
		//hidden : html화면에서 노출이 안될뿐 input 전송과 동일
		String hidden = request.getParameter("hiddenData");
		
		//readonly : html화면에서 노출이 안될뿐 input 전송과 동일
		String readonly = request.getParameter("input1");
		
		//disabled : disabled된 input태그는 전송되지 않음
		String disabled = request.getParameter("input2");
		
		//div : input, select, textarea가 아니므로 전송되지 않음
		String div = request.getParameter("div");
		
		System.out.println("str : " + str);
		System.out.println("num : " + num);
		System.out.println("gender :" + gender);
		for(int i=0; i<hobbys.length; i++) {
			System.out.println("hobby : " +hobbys[i]);
		}
		System.out.println("age : " + age);
		System.out.println("comment : " + comment);
		System.out.println("hidden : " + hidden);
		System.out.println("readonly : " + readonly);
		System.out.println("disabled : " + disabled);
		System.out.println("div : " + div);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
