package com.test.sts;

import java.util.List;

public interface DepartmentDAO {

	// �μ� ���� ��ü ���
	public List<Department> departmentList();
	
	// �μ� ���� �߰�
	public int add(Department d);
	
	// �μ� ���� ����
	public int remove(Department d);

	// �μ� ���� ����
	public int modify(Department d);

}
