package com.test.sts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/* @Controller ������̼��� ���� Ŭ������ SpringWebMVC�� �����ϴ� ��Ʈ�ѷ��� ����� �� ��� */
@Controller
public class DepartmentController {

	// @Autowired ������̼��� �̿��� �ڵ� ���� ����
	// DAO ��ü�� ���� ���� ����
	@Autowired
	private DepartmentDAO departmentDAO;
	
	/* @RequestMapping ������̼ǿ��� method �Ӽ��� ��û ���(GET or POST)�� �м��� �� ��� */
	/* @RequestMapping ������̼ǰ� ����� �޼ҵ常 ���� ��û�� ���� ���� �޼ҵ尡 �� �� �ִ�. */
	/* ���� �޼ҵ��� �Ű� ���� ������ SpringWebMVC�� ���� �ڵ� �м��Ǳ� ������, �ʿ��� ��ü�� ��û�� �� ����Ѵ�. */
	/*
	 * method = {RequestMethod.GET, RequestMethod.POST}�� GET, POST ��� �� ���� ��� ���� ����
	 */
	// ���� ���� ��ü ���
	@RequestMapping(value = "/departmentlist.it", method = { RequestMethod.GET, RequestMethod.POST })
	public String departmentlist(ModelMap model) {
		
		List<Department> list = null;
		list = departmentDAO.departmentList();
		
		/* ���� �׼��� ����� JSP ������(View)�� �����ϴ� ��� Model ��ü�� ����Ѵ�. */
		model.addAttribute("list",list);
		
		/* View ������ ��ȯ�ϴ� �κ� */
		return "departmentlist"; // "/WEB-INF/views/departmentlist.jsp"
	}
	
	// ���� ���� �߰�
	@RequestMapping(value = "/departmentinsert.it", method = RequestMethod.POST)
	public String departmentinsert(Department d) {
		departmentDAO.add(d);
		/* View ������ ��ȯ�ϴ� �κ� */
		return "redirect:departmentlist.it";
	}
	
	// ���� ���� ����
	@RequestMapping(value = "/departmentdelete.it", method = RequestMethod.POST)
	public String departmentdelete(Department d) {
		departmentDAO.remove(d);
		/* View ������ ��ȯ�ϴ� �κ� */
		return "redirect:departmentlist.it";
	}
	
	// ���� ���� ����
	@RequestMapping(value = "/departmentupdate.it", method = RequestMethod.POST)
	public String departmentupdate(Department d) {
		departmentDAO.modify(d);
		/* View ������ ��ȯ�ϴ� �κ� */
		return "redirect:departmentlist.it";
	}
	
	
}
