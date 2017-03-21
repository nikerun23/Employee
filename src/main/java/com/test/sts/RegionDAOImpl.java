package com.test.sts;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//DAO ��ü���� @Repository ������̼� ����
@Repository
public class RegionDAOImpl implements RegionDAO {

	/* MyBatis ���� �߰� */
	/* SqlSession ��ü�� ���� �ڵ� �������� */
	@Autowired
	private SqlSession sqlSession;
	
	// ���� ���� ��ü ���
	@Override
	public List<Region> regionList() {
		RegionDAO dao = sqlSession.getMapper(RegionDAO.class);
		List<Region> list = dao.regionList();
		return list;
	}

	// ���� ���� �߰�
	@Override
	public int add(Region r) {
		int result = 0;
		RegionDAO dao = sqlSession.getMapper(RegionDAO.class);
		result = dao.add(r);
		return result;
	}

	// ���� ���� ����
	@Override
	public int remove(Region r) {
		int result = 0;
		RegionDAO dao = sqlSession.getMapper(RegionDAO.class);
		result = dao.remove(r);
		return result;
	}

	// ���� ���� ����
	@Override
	public int modify(Region r) {
		int result = 0;
		RegionDAO dao = sqlSession.getMapper(RegionDAO.class);
		result = dao.modify(r);
		return result;
	}

}
