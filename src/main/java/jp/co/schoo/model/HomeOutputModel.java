package jp.co.schoo.model;

import java.io.Serializable;

/**
 * Java入門 ログイン画面Modelクラス.
 */
public class HomeOutputModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;		// ID
	private String name;	// 名前
	private int age;		// 年齢

	public HomeOutputModel() {
		id   = "";
		name = "";
		age  = 0;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
}