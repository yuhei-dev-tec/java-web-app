package model;

public class ExecuteLoginBL {
	
	public UserInfoDto executeSelectUserInfo(String inputUserId, String inputPassWord) {

		UserInfoDto dto = new UserInfoDto();  //ユーザーデータ（UserInfoDto型）

		//DAOクラスをインスタンス化＆「user_info」テーブルからユーザーデータを抽出するよう依頼
		UserInfoDao dao = new UserInfoDao();
		dto             = dao.doSelect(inputUserId, inputPassWord);

		//抽出したユーザーデータを戻す
		return dto;
	}

}
