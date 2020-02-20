package jp.co.sample.emp_management.form;

/**
 * @author yuuki
 *
 */
public class FindByLikeNameForm {
	
	/** 名前 */
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "FindByLikeName [name=" + name + "]";
	}
	
}
