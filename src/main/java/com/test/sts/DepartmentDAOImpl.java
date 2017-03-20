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
	
	@Override
	public List<Department> departmentList() {
		DepartmentDAO dao = sqlSession.getMapper(DepartmentDAO.class);
		List<Department> list = dao.departmentList();
		return list;
	}

	@Override
	public int add(Department d) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(Department d) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modify(Department d) {
		// TODO Auto-generated method stub
		return 0;
	}

}
