package com.test.sts;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/* @Controller ������̼��� ���� Ŭ������ SpringWebMVC�� �����ϴ� ��Ʈ�ѷ��� ����� �� ��� */
@Controller
public class PositionController {

	// @Autowired ������̼��� �̿��� �ڵ� ���� ����
	// DAO ��ü�� ���� ���� ����
	@Autowired
	private PositionDAO positionDAO;
	
	/* @RequestMapping ������̼ǿ��� method �Ӽ��� ��û ���(GET or POST)�� �м��� �� ��� */
	/* @RequestMapping ������̼ǰ� ����� �޼ҵ常 ���� ��û�� ���� ���� �޼ҵ尡 �� �� �ִ�. */
	/* ���� �޼ҵ��� �Ű� ���� ������ SpringWebMVC�� ���� �ڵ� �м��Ǳ� ������, �ʿ��� ��ü�� ��û�� �� ����Ѵ�. */
	/*
	 * method = {RequestMethod.GET, RequestMethod.POST}�� GET, POST ��� �� ���� ��� ���� ����
	 */
	// ���� ���� ��ü ���
	@RequestMapping(value = "/positionlist.it", method = { RequestMethod.GET, RequestMethod.POST })
	public String positionlist(ModelMap model) {
		
		List<Position> list = null;
		
		list = positionDAO.positionList();
		
		/* ���� �׼��� ����� JSP ������(View)�� �����ϴ� ��� Model ��ü�� ����Ѵ�. */
		model.addAttribute("list",list);
		
		/* View ������ ��ȯ�ϴ� �κ� */
		return "positionlist"; // "/WEB-INF/views/departmentlist.jsp"
	}
	
	// ���� ���� �߰�
	@RequestMapping(value = "/positioninsert.it", method = RequestMethod.POST)
	public String positioninsert(Position p) {
		// ���� ��û ������ ���� ó�� -> �������� �ڵ� ���� (�ڷ��� Ŭ���� �غ� or ��� ���� �غ�)
		positionDAO.add(p);
		/* View ������ ��ȯ�ϴ� �κ� */
		return "redirect:positionlist.it";
	}
	
	// ���� ���� ����
	@RequestMapping(value = "/positiondelete.it", method = RequestMethod.POST)
	public String positiondelete(Position p) {
		// ���� ��û ������ ���� ó�� -> �������� �ڵ� ���� (�ڷ��� Ŭ���� �غ� or ��� ���� �غ�)
		positionDAO.remove(p);
		/* View ������ ��ȯ�ϴ� �κ� */
		return "redirect:positionlist.it";
	}
	
	// ���� ���� ����
	@RequestMapping(value = "/positionupdate.it", method = RequestMethod.POST)
	public String positionupdate(Position p) {
		// ���� ��û ������ ���� ó�� -> �������� �ڵ� ���� (�ڷ��� Ŭ���� �غ� or ��� ���� �غ�)
		positionDAO.modify(p);
		/* View ������ ��ȯ�ϴ� �κ� */
		return "redirect:positionlist.it";
	}

}
