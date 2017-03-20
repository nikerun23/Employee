package com.test.sts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/* @Controller ������̼��� ���� Ŭ������ SpringWebMVC�� �����ϴ� ��Ʈ�ѷ��� ����� �� ��� */
@Controller
public class EmployeeController {

	// @Autowired ������̼��� �̿��� �ڵ� ���� ����
	// DAO ��ü�� ���� ���� ����
	@Autowired
	private EmployeeDAO employeeDAO;
	@Autowired
	private RegionDAO regionDAO;
	@Autowired
	private DepartmentDAO departmentDAO;
	@Autowired
	private PositionDAO positionDAO;
	
	/* @RequestMapping ������̼ǿ��� method �Ӽ��� ��û ���(GET or POST)�� �м��� �� ��� */
	/* @RequestMapping ������̼ǰ� ����� �޼ҵ常 ���� ��û�� ���� ���� �޼ҵ尡 �� �� �ִ�. */
	/* ���� �޼ҵ��� �Ű� ���� ������ SpringWebMVC�� ���� �ڵ� �м��Ǳ� ������, �ʿ��� ��ü�� ��û�� �� ����Ѵ�. */
	/*
	 * method = {RequestMethod.GET, RequestMethod.POST}�� GET, POST ��� �� ���� ��� ���� ����
	 */
	@RequestMapping(value = "/employeelist", method = { RequestMethod.GET, RequestMethod.POST })
	public String employeelist(ModelMap model, String skey, String svalue) {

		// �˻� ��û ������ ���� ó�� -> �������� �ڵ� ���� (�ڷ��� Ŭ���� �غ� or ��� ���� �غ�)

		List<Employee> list = null;
		int totalcount = 0;
		int count = 0;

		if (skey == null) {
			skey = "all";
			svalue = "";
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("key", skey);
		map.put("value", svalue);
		
		list = employeeDAO.employeeList(map);
		totalcount = employeeDAO.totalCount();
		count = list.size();
		
		/* ���� �׼��� ����� JSP ������(View)�� �����ϴ� ��� Model ��ü�� ����Ѵ�. */
		model.addAttribute("list", list);
		model.addAttribute("totalcount", totalcount);
		model.addAttribute("count", count);
		model.addAttribute("skey", skey);
		model.addAttribute("svalue", svalue);
		
		/* View ������ ��ȯ�ϴ� �κ� */
		return "employeelist"; // "/WEB-INF/views/employeelist.jsp"
	}
	
	@RequestMapping(value = "/employeeinsertform", method = { RequestMethod.GET, RequestMethod.POST })
	public String employeeinsertform(ModelMap model) {

		// �˻� ��û ������ ���� ó�� -> �������� �ڵ� ���� (�ڷ��� Ŭ���� �غ� or ��� ���� �غ�)
		
		List<Region> regionList = regionDAO.regionList();
		List<Department> departmentList = departmentDAO.departmentList();
		
		Map<String, String> map = null;
		List<Position> positionList = positionDAO.positionList(map);
		
		model.addAttribute("regionList", regionList);
		model.addAttribute("departmentList", departmentList);
		model.addAttribute("positionList", positionList);
		
		return "employeeinsertform"; // "/WEB-INF/views/employeeinsertform.jsp"
	}
	
	@RequestMapping(value = "/employeeinsert", method = RequestMethod.POST)
	public String employeeinsert(Employee emp) {
		// ���� ��û ������ ���� ó�� -> �������� �ڵ� ���� (�ڷ��� Ŭ���� �غ� or ��� ���� �غ�)
		employeeDAO.employeeAdd(emp);
		
		/* View ������ ��ȯ�ϴ� �κ� */
		return "redirect:employeelist";
		
	}
	
	
	
}