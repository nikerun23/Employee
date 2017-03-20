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
	
	// key, value �� ������ ���ؼ� Map ��ü �̿�
	@Override
	public List<Employee> employeeList(Map<String, String> map) {
		EmployeeDAO dao = sqlSession.getMapper(EmployeeDAO.class);
		List<Employee> list = dao.employeeList(map);
		return list;
	}

	@Override
	public int totalCount() {
		int result = 0;
		EmployeeDAO dao = sqlSession.getMapper(EmployeeDAO.class);
		result = dao.totalCount();
		return result;
	}

	@Override
	public int employeeAdd(Employee emp) {
		int result = 0;
		EmployeeDAO dao = sqlSession.getMapper(EmployeeDAO.class);
		result = dao.employeeAdd(emp);
		return result;
	}

	@Override
	public int employeeModify(Employee emp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int pictureAdd(Employee emp) {
		int result = 0;
		EmployeeDAO dao = sqlSession.getMapper(EmployeeDAO.class);
		dao.employeeAdd(emp);
		return result;
	}

	// �����͸� �ܵ� �������� ����, Grade Ŭ���� �Ǵ� Map Ŭ���� �̿��� ��.
	@Override
	public int employeRemove(Employee emp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int pictureModify(Employee emp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Employee> pictureList(Employee emp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String login(String id, String pw, String admin) {
		// TODO Auto-generated method stub
		return null;
	}

}
