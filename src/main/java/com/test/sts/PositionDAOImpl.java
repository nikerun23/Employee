package com.test.sts;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//DAO ��ü���� @Repository ������̼� ����
@Repository
public class PositionDAOImpl implements PositionDAO {

	@Autowired
	private SqlSession sqlSession;
	
	// ���� ���� ��ü ���
	@Override
	public List<Position> positionList() {
		PositionDAO dao = sqlSession.getMapper(PositionDAO.class);
		List<Position> list = dao.positionList();
		return list;
	}

	// ���� ���� �߰�
	@Override
	public int add(Position p) {
		int result = 0;
		PositionDAO dao = sqlSession.getMapper(PositionDAO.class);
		dao.add(p);
		return result;
	}

	// ���� ���� ����
	@Override
	public int remove(Position p) {
		int result = 0;
		PositionDAO dao = sqlSession.getMapper(PositionDAO.class);
		dao.remove(p);
		return result;
	}

	// ���� ���� ����
	@Override
	public int modify(Position p) {
		int result = 0;
		PositionDAO dao = sqlSession.getMapper(PositionDAO.class);
		dao.modify(p);
		return result;
	}
	
	// �ּұ⺻�� �˻�
	@Override
	public int getMinBasicPay(Position p) {
		int result = 0;
		PositionDAO dao = sqlSession.getMapper(PositionDAO.class);
		result = dao.getMinBasicPay(p);
		return result;
	}


}
