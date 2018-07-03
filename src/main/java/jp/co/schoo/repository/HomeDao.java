package jp.co.schoo.repository;

import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.schoo.model.HomeOutputModel;

/**
 * Java入門 ログイン機能DAOクラス.
 */
@Repository
public class HomeDao {
	
	@Autowired
	JdbcTemplate data;	// Spring JDBCのテンプレートクラス
	
	/** ユーザ検索用のSQL文 */
	private final String SELECT_USER_QUERY = 
			"select name, age from user where id = ? and pass = ?";
	
	/**
	 * ユーザ検索処理.
	 * @param id		ログインユーザID
	 * @param password	ログインパスワード
	 * @return	ユーザ画面用のModelクラス
	 */
	public HomeOutputModel selectUser(String id, String password) {
		
		List<Map<String, Object>> list = null;	// DB検索結果を格納するリスト
		HomeOutputModel outputModel = null;		// ユーザ画面用のModelクラス
		
		try {
			// ユーザ検索処理を実行
			list = data.queryForList(SELECT_USER_QUERY, new Object[]{id, password});
			
			// 検索結果が空でないことをチェック
			if(!list.isEmpty()) {
				
				// Modelクラスのインスタンスを生成して検索結果の情報をセット
				outputModel = new HomeOutputModel();
				
				for(Map<String, Object> map : list) {

					outputModel.setId(id);
					outputModel.setName((String)map.get("name"));
					outputModel.setAge((Integer)map.get("age"));
				}
			}
			
		} catch(DataAccessException dae) {
			// 例外が発生した場合はModelクラスを空にして処理を終了させる
			outputModel = null;
		}
		
		return outputModel;
	}
}