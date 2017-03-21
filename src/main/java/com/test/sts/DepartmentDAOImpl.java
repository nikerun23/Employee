package com.test.sts;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//DAO ��ü���� @Repository ������̼� ����
@Repository
public class DepartmentDAOImpl implements DepartmentDAO {

	/* MyBatis ���� �߰� */
	/* SqlSession ��ü�� ���� �ڵ� �������� */
	@Autowired
	private SqlSession sqlSession;
	
	// �μ� ���� ��ü ���
	@Override
	public List<Department> departmentList() {
		DepartmentDAO dao = sqlSession.getMapper(DepartmentDAO.class);
		List<Department> list = dao.departmentList();
		return list;
	}

	// �μ� ���� �߰�
	@Override
	public int add(Department d) {
		int result = 0;
		DepartmentDAO dao = sqlSession.getMapper(DepartmentDAO.class);
		result = dao.add(d);
		return result;
	}

	// �μ� ���� ����
	@Override
	public int remove(Department d) {
		int result = 0;
		DepartmentDAO dao = sqlSession.getMapper(DepartmentDAO.class);
		result = dao.remove(d);
		return result;
	}

	// �μ� ���� ����
	@Override
	public int modify(Department d) {
		int result = 0;
		DepartmentDAO dao = sqlSession.getMapper(DepartmentDAO.class);
		result = dao.modify(d);
		return result;
	}

}
