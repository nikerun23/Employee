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
	
	@Override
	public List<Region> regionList() {
		RegionDAO dao = sqlSession.getMapper(RegionDAO.class);
		List<Region> list = dao.regionList();
		return list;
	}

	@Override
	public int add(Region r) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(Region r) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modify(Region r) {
		// TODO Auto-generated method stub
		return 0;
	}

}
