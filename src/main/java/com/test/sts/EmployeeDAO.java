package com.test.sts;

import java.util.List;
import java.util.Map;

public interface EmployeeDAO {

	// ���� ���  ��ü �� �˻� ��¿� �޼ҵ�
	public List<Employee> employeeList(Map<String, String> map);
	
	// ���� ��ü �ο��� ��� �޼ҵ�
	public int totalCount();
	
	//���� ���� �߰� �޼ҵ�
	public int employeeAdd(Employee emp);
	
	//���� ���� ���� �޼ҵ�
	public int employeeModify(Employee emp);
	
	//���� ���� �߰� �޼ҵ�
	public int pictureAdd(Employee emp);
	
	//���� ���� ���� �޼ҵ�
	public int employeRemove(Employee emp);
	
	//���� ���� ���� �޼ҵ�
	public int pictureModify(Employee emp);
	
	// ���� ���� �˻� ��¿� �޼ҵ�
	public List<Employee> pictureList(Employee emp);
	
	//�α��� �޼ҵ� (������ �Ǵ� �Ϲݻ����)
	public String login(String id, String pw, String admin);
}
