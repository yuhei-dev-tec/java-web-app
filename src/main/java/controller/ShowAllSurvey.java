package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ShowAllSurveyBL;
import model.SurveyDto;
import model.UserInfoDto;

/**
 * Servlet implementation class ShowAllSurvey
 */
@WebServlet("/ShowAllSurvey")//
public class ShowAllSurvey extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowAllSurvey() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		UserInfoDto userInfoOnSession = (UserInfoDto) session.getAttribute("LOGIN_INFO");

		if (userInfoOnSession != null) {
			
			ShowAllSurveyBL bl = new ShowAllSurveyBL();
			List<SurveyDto> dtoList = bl.doSelectBL();
			
			//アンケートリストをリクエストスコープに保存
			request.setAttribute( "ALL_SURVEY_LIST" , dtoList );

			//Viewにフォワード（フォワード先：show_survey_by_satisfaction_level.jsp）
			RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/view/show_all_survey.jsp");
			dispatch.forward(request, response);


			
		}else {
			
			response.sendRedirect("Login");
			
		}
	}
}
