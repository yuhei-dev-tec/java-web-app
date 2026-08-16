package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserInfoDto;

/**----------------------------------------------------------------------*
 *■■■InputSurveyクラス■■■
 *概要：サーブレット
 *詳細：HTML文書（回答入力画面）を出力する。
 *----------------------------------------------------------------------**/
@WebServlet("/InputSurvey")//
public class InputSurvey extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InputSurvey() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		HttpSession session           = request.getSession();
		UserInfoDto userInfoOnSession = (UserInfoDto)session.getAttribute("LOGIN_INFO");

		if (userInfoOnSession != null) {

			//Viewにフォワード（フォワード先：show_survey_by_satisfaction_level.jsp）
			RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/view/input_survey.jsp");
			dispatch.forward(request, response);

			
		}else {
			
			response.sendRedirect("Login");
			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
