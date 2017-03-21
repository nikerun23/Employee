package com.test.sts;

import java.util.List;

public interface PositionDAO {

	// ���� ���� ��ü ���
	public List<Position> positionList();
	
	// ���� ���� �߰�
	public int add(Position p);
	
	// ���� ���� ����
	public int remove(Position p);
	
	// ���� ���� ����
	public int modify(Position p);
	
	// �ּұ⺻�� �˻� ���� �޼ҵ�
	public int getMinBasicPay(Position p);
	
}
