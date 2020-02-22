package jp.co.sample.emp_management.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 従業員登録用フォーム.
 * 
 * @author yuuki
 *
 */
public class InsertEmployeeForm {
	
	/** 従業員名 */
	private String name;
	
	/** 写真 */
	private String image;
	
	/** 性別 */
	private String gender;
	
	/** 入社日 */
	private String hireDateString;
	
	/** メールアドレス */
	private String mailAddress;
	
	/** 郵便番号 */
	private String zipCode;
	
	/** 住所 */
	private String address;
	
	/** 電話番号 */
	private String telephone;
	
	/** 給料 */
	private String salary;
	
	/** 特性 */
	private String characteristics;
	
	/** 扶養人数 */
	private String dependentsCount;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHireDateString() {
		return hireDateString;
	}
	public void setHireDateString(String hireDateString) {
		this.hireDateString = hireDateString;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getCharacteristics() {
		return characteristics;
	}
	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}
	public String getDependentsCount() {
		return dependentsCount;
	}
	public void setDependentsCount(String dependentsCount) {
		this.dependentsCount = dependentsCount;
	}
	
	/**
	 * 給料をInteger型で返す.
	 * 
	 * @return 給料
	 */
	public Integer getIntSalary() {
		return Integer.parseInt(salary);
	}
	
	/**
	 * 扶養人数をInteger型で返す.
	 * 
	 * @return 扶養人数
	 */
	public Integer getIntDependentsCount() {
		return Integer.parseInt(dependentsCount);
	}
	
	
	/**
	 * 入社日をDate型で返す.
	 * 
	 * @return 入社年月日
	 */
	public Date getHireDate() throws ParseException{
		System.out.println(hireDateString);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date formatDate = sdf.parse(hireDateString);
		return formatDate;
	}
	
}
