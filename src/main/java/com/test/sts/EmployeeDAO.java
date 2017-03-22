package com.test.sts;

import java.util.List;
import java.util.Map;

public interface EmployeeDAO {

	// ���� ���  ��ü �� �˻� ��¿� �޼ҵ�
	public List<Employee> employeeList(Map<String, String> map);
	
	// ���� ��ü �ο��� ��� �޼ҵ�
	public int totalCount();
	
	// ���� ���� �߰�
	public int employeeAdd(Employee emp);
	
	// ���� ���� ����
	public int employeeModify(Employee emp);
	
	// ���� ���� �߰�
	public int pictureAdd(Employee emp);
	
	// ���� ���� ����
	public int employeRemove(Employee emp);
	
	// ���� ���� ����
	public int pictureModify(Employee emp);
	
	// ���� ���� �˻� ��¿�
	public List<Employee> pictureList(Employee emp);
	
}
