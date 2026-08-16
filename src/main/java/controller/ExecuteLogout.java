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

/**
 * Servlet implementation class ExecuteLogout
 */
@WebServlet("/ExecuteLogout")//
public class ExecuteLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecuteLogout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//レスポンス（出力データ）の文字コードを設定
						//セッションからユーザーデータを取得
				HttpSession session           = request.getSession();
				UserInfoDto userInfoOnSession = (UserInfoDto)session.getAttribute("LOGIN_INFO");

				//ログイン状態によって表示画面を振り分ける
				// ※ログイン状態はセッション上からユーザーデータを取得できたか否かで判断
				//    ユーザーデータを取得できた　　　→既にログインされている
				//    ユーザーデータを取得できなかった→まだログインされていない
				if (userInfoOnSession != null) {
					//ログイン済：ログアウト処理を実施

					//ログアウトに伴いセッション情報を破棄
					session.invalidate();

					//アンケートリストをリクエストスコープに保存
					request.setAttribute( "LOGOUT" , userInfoOnSession );

					//Viewにフォワード（フォワード先：show_survey_by_satisfaction_level.jsp）
					RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/view/logout.jsp");
					dispatch.forward(request, response);

					
				} else {
					//未ログイン：ログイン画面へ転送
					response.sendRedirect("Login");
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
