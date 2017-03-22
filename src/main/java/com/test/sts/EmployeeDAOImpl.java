package com.test.sts;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//DAO ��ü���� @Repository ������̼� ����
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	/* MyBatis ���� �߰� */
	/* SqlSession ��ü�� ���� �ڵ� �������� */
	@Autowired
	private SqlSession sqlSession;
	
	// ���� ���  ��ü �� �˻� ��¿� �޼ҵ�
	// key, value �� ������ ���ؼ� Map ��ü �̿�
	@Override
	public List<Employee> employeeList(Map<String, String> map) {
		EmployeeDAO dao = sqlSession.getMapper(EmployeeDAO.class);
		List<Employee> list = dao.employeeList(map);
		return list;
	}

	// ���� ��ü �ο��� ��� �޼ҵ�
	@Override
	public int totalCount() {
		int result = 0;
		EmployeeDAO dao = sqlSession.getMapper(EmployeeDAO.class);
		result = dao.totalCount();
		return result;
	}

	//���� ���� �߰�
	@Override
	public int employeeAdd(Employee emp) {
		int result = 0;
		EmployeeDAO dao = sqlSession.getMapper(EmployeeDAO.class);
		result = dao.employeeAdd(emp);
		return result;
	}

	// ���� ���� ����
	@Override
	public int employeeModify(Employee emp) {
		// TODO Auto-generated method stub
		return 0;
	}

	// ���� ���� ����
	// �����͸� �ܵ� �������� ����, Grade Ŭ���� �Ǵ� Map Ŭ���� �̿��� ��.
	@Override
	public int employeRemove(Employee emp) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	// ���� ���� �߰�
	@Override
	public int pictureAdd(Employee emp) {
		int result = 0;
		EmployeeDAO dao = sqlSession.getMapper(EmployeeDAO.class);
		dao.pictureAdd(emp);
		return result;
	}

	// ���� ���� ����
	@Override
	public int pictureModify(Employee emp) {
		int result = 0;
		EmployeeDAO dao = sqlSession.getMapper(EmployeeDAO.class);
		dao.pictureModify(emp);
		return result;
	}

	// ���� ���� �˻� ��¿�
	@Override
	public List<Employee> pictureList(Employee emp) {
		EmployeeDAO dao = sqlSession.getMapper(EmployeeDAO.class);
		List<Employee> list = dao.pictureList(emp);
		return list;
	}

}
