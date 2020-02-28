package jp.co.sample.emp_management.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.emp_management.domain.Employee;
import jp.co.sample.emp_management.repository.EmployeeRepository;

/**
 * 従業員情報を操作するサービス.
 * 
 * @author igamasayuki
 *
 */
@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	/**
	 * 従業員情報を全件取得します.
	 * 
	 * @return　従業員情報一覧
	 */
	public List<Employee> showList() {
		List<Employee> employeeList = employeeRepository.findAll();
		return employeeList;
	}
	
	/**
	 * 従業員情報を取得します.
	 * 
	 * @param id ID
	 * @return 従業員情報
	 * @throws 検索されない場合は例外が発生します
	 */
	public Employee showDetail(Integer id) {
		Employee employee = employeeRepository.load(id);
		return employee;
	}
	
	
	/**
	 * 従業員曖昧検索.
	 * 
	 * @param name 検索フォームに入力された名前
	 * @return 曖昧検索で該当した従業員データのリスト 
	 * 		   nameが空文字の場合全件検索結果表示
	 * 	       検索結果が0件の場合も全件検索結果表示
	 */
	public List <Employee> findByLikeName(String name){
		List <Employee> employeeList = employeeRepository.findByLikeName(name);
		return employeeList;
	}
	
	/**
	 * 従業員情報を更新します.
	 * 
	 * @param employee　更新した従業員情報
	 */
	public void update(Employee employee) {
		employeeRepository.update(employee);
	}
	
	/**
	 * 従業員情報を登録する.
	 * 
	 * @param employee 登録したい従業員オブジェクト
	 */
	public void insert(Employee employee) {
		employeeRepository.insert(employee);
	}
	
	public Page<Employee> showListPaging(int page, int size, List<Employee> employeeList){
		// 表示させたいページを-1しなければうまく動かない
		page--;
		// どの従業員から表示するかというカウント値
		int startItemCount = page * size;
		// 絞りこんだ後の従業員リストが入る変数
		List<Employee> list;
		
		if (employeeList.size() < startItemCount) {
			list = Collections.emptyList();
		} else {
			//　該当ページに表示させる従業員一覧を作成
			int toIndex = Math.min(startItemCount + size , employeeList.size() );
			list = employeeList.subList(startItemCount, toIndex);
		}
		
		// 上記で作成した該当ページに表示させる従業員一覧をページングできる形に変換して返す
		Page<Employee> employeePage
			= new PageImpl<Employee>(list,PageRequest.of(page, size),employeeList.size());
		return employeePage;
	}
	
	
	
	
	
	
	/**
	 * オートコンプリート用にJavaScriptの配列の中身を文字列で作ります.
	 * 
	 * @param employeeList 従業員一覧
	 * @return オートコンプリート用JavaScriptの配列の文字列
	 */
	public StringBuilder getEmployeeListForAutocomplete(List<Employee> employeeList) {
		StringBuilder employeeListForAutocomplete = new StringBuilder();
		for (int i = 0; i < employeeList.size(); i++) {
			if (i != 0) {
				employeeListForAutocomplete.append(",");
			}
			Employee employee = employeeList.get(i);
			employeeListForAutocomplete.append("\"");
			employeeListForAutocomplete.append(employee.getName());
			employeeListForAutocomplete.append("\"");
		}
		return employeeListForAutocomplete;
	}
}
