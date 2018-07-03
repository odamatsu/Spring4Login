package jp.co.schoo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Java入門 ログイン機能Aspectクラス.
 */
@Aspect
@Component
public class HomeAspect {

	/**
	 * コンソールにアドバイスの対象メソッド名を通知します.</br>
	 * このアドバイスは対象メソッドの実行前に処理されます.
	 * @param point	ジョインポイント
	 */
	@Before("execution(* jp.co.schoo.HomeController.*(..))")
	public void outMsgBefore(JoinPoint point) {
		System.out.println("■■■■■" + point.toString() + "のBefore処理を実行します. ■■■■■");
	}
	
	/**
	 * コンソールにアドバイスの対象メソッド名を通知します.</br>
	 * このアドバイスは対象メソッドの実行後に処理されます.
	 * @param point	ジョインポイント
	 */
	@After("execution(* jp.co.schoo.HomeController.*(..))")
	public void outMsgAfter(JoinPoint point) {
		System.out.println("■■■■■" + point.toString() + "のAfter処理を実行します. ■■■■■");
	}
}