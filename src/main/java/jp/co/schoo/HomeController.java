package jp.co.schoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.schoo.model.HomeInputModel;
import jp.co.schoo.model.HomeOutputModel;
import jp.co.schoo.repository.HomeDao;

/**
 * Java入門 ログイン機能Controllerクラス.
 */
@Controller
public class HomeController {
	
	@Autowired
	HomeDao dao;	// DAOクラス
	
	/**
	 * ログインページアクセス時の処理.
	 * @param	model JSP画面と共有するためのModelクラス
	 * @return	次画面を示す文字列
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		// アクセス時に新しいログイン画面用Modelクラスのインスタンスを作成
		HomeInputModel inputModel = new HomeInputModel();
		// ログイン画面に表示するメッセージを設定
		inputModel.setMsg("IDとパスワードを入力してください.");
		// Modelクラスに設定
		model.addAttribute("input", inputModel);
		
		// ログイン画面を表示
		return "login";
	}
	
	/**
	 * ログイン処理.</br>
	 * ログイン成功時はユーザ画面、失敗時はログイン画面に移動.
	 * @param input	ログイン画面の入力値を格納したModelクラス
	 * @param model	JSP画面と共有するためのModelクラス
	 * @return	次画面を示す文字列
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String login(@ModelAttribute HomeInputModel input, Model model) {
		
		String nextpage = "login";	// 戻り値（次画面を示す文字列）
		
		// DAOクラスでログインユーザ検索を実行
		HomeOutputModel outputModel = 
				dao.selectUser(input.getId(), input.getPassword());
		
		// DAOクラスの戻り値が空でなければユーザ画面に移動
		if(outputModel != null) {
			
			// Modelクラスに値を設定
			model.addAttribute("output", outputModel);
			// 次画面をユーザ画面に変更
			nextpage = "user";
			
		} else {
			
			// ログインに失敗している場合は入力画面用のModelクラスを新たに設定
			HomeInputModel inputModel = new HomeInputModel();
			// ログイン画面に表示するメッセージを設定
			inputModel.setMsg("ログインできませんでした...");
			// Modelクラスに設定
			model.addAttribute("input", inputModel);
		}
		
		return nextpage;
	}
}