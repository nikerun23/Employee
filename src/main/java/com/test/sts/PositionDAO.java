package com.test.sts;

import java.util.List;
import java.util.Map;

public interface PositionDAO {

	public List<Position> positionList();
	
	public int add(Position p);
	
	public int remove(Position p);
	
	//�ּұ⺻�� �˻� ���� �޼ҵ�
	public int getMinBasicPay(Position p);
	
	public int modify(Position p);
		
}
