package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ExecuteLoginBL;
import model.UserInfoDto;

/**
 * Servlet implementation class ExecuteLogin
 */
@WebServlet("/ExecuteLogin")//
public class ExecuteLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecuteLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//レスポンス（出力データ）の文字コードを設定
		response.setContentType("text/html;charset=UTF-8");     //文字コードをUTF-8で設定
		//リクエスト（受信データ）の文字コードを設定
		request.setCharacterEncoding("UTF-8");                  //文字コードをUTF-8で設定

		//セッションからユーザーデータを取得
		HttpSession session           = request.getSession();
		UserInfoDto userInfoOnSession = (UserInfoDto)session.getAttribute("LOGIN_INFO");

		//ログイン状態によって表示画面を振り分ける
		// ※ログイン状態はセッション上からユーザーデータを取得できたか否かで判断
		//    ユーザーデータを取得できた　　　→既にログインされている
		//    ユーザーデータを取得できなかった→まだログインされていない
		if (userInfoOnSession != null) {
			//ログイン済：ホーム画面に転送
			response.sendRedirect("InputSurvey");
		} else {
			//未ログイン：ログイン処理を実施
			
			boolean succesFlg = true;
			
			if (!(validatePrmUserId(request.getParameter("USER_ID"))  &&
					validatePrmPassword(request.getParameter("PASSWORD"))  )) {
				
				succesFlg = false;
				
			}else {
				
				//リクエストパラメータからユーザー入力値を取得
				String userId   = request.getParameter("USER_ID");      //リクエストパラメータ（USER_ID）
				String passWord = request.getParameter("PASSWORD");     //リクエストパラメータ（PASSWORD）

				//「user_info」テーブルからユーザー入力値と合致するユーザーデータ（UserInfoDto型）を抽出
				// ※合致するデータがなかった場合、各フィールドがnullのDTOを得る
				ExecuteLoginBL logic = new ExecuteLoginBL();
				UserInfoDto   dto   = logic.executeSelectUserInfo(userId, passWord);

				//ユーザーデータの抽出成功/失敗に応じて表示させる画面を振り分ける
				if (dto.getUserId() == null) {
					
					succesFlg = false;

		
				} else {
					//DBから抽出したユーザデータをセッションにセット
					session.setAttribute("LOGIN_INFO", dto);

				}
				
			}
			
			if (succesFlg) {
				
				response.sendRedirect("InputSurvey");
				
			}else {
				
				response.sendRedirect("Login");
				
			}

			
		}
	}
	
	private boolean validatePrmUserId(String pr) {
		
		boolean validateResult = true;
		
		if (pr == null || pr.equals("")) {
			
			validateResult = false;
			
		}
		
		return validateResult;
		
	}
	
private boolean validatePrmPassword(String pr) {
		
		boolean validateResult = true;
		
		if (pr == null || pr.equals("")) {
			
			validateResult = false;
			
		}
		
		return validateResult;
		
	}

}
