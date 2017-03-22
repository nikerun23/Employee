package com.test.sts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/* @Controller ������̼��� ���� Ŭ������ SpringWebMVC�� �����ϴ� ��Ʈ�ѷ��� ����� �� ��� */
@Controller
public class RegionController {

	// @Autowired ������̼��� �̿��� �ڵ� ���� ����
	// DAO ��ü�� ���� ���� ����
	@Autowired
	private RegionDAO regionDAO;
	
	/* @RequestMapping ������̼ǿ��� method �Ӽ��� ��û ���(GET or POST)�� �м��� �� ��� */
	/* @RequestMapping ������̼ǰ� ����� �޼ҵ常 ���� ��û�� ���� ���� �޼ҵ尡 �� �� �ִ�. */
	/* ���� �޼ҵ��� �Ű� ���� ������ SpringWebMVC�� ���� �ڵ� �м��Ǳ� ������, �ʿ��� ��ü�� ��û�� �� ����Ѵ�. */
	/*
	 * method = {RequestMethod.GET, RequestMethod.POST}�� GET, POST ��� �� ���� ��� ���� ����
	 */
	// ���� ���� ��ü ���
	@RequestMapping(value = "/regionlist.it", method = { RequestMethod.GET, RequestMethod.POST })
	public String regionlist(ModelMap model) {
		
		List<Region> list = null;
		list = regionDAO.regionList();
		
		/* ���� �׼��� ����� JSP ������(View)�� �����ϴ� ��� Model ��ü�� ����Ѵ�. */
		model.addAttribute("list",list);
		
		/* View ������ ��ȯ�ϴ� �κ� */
		return "regionlist"; // "/WEB-INF/views/regionlist.jsp"
	}
	
	// ���� ���� �߰�
	@RequestMapping(value = "/regioninsert.it", method = RequestMethod.POST)
	public String regioninsert(Region r) {
		regionDAO.add(r);
		/* View ������ ��ȯ�ϴ� �κ� */
		return "redirect:regionlist.it";
	}
	
	// ���� ���� ����
	@RequestMapping(value = "/regiondelete.it", method = RequestMethod.POST)
	public String regiondelete(Region r) {
		regionDAO.remove(r);
		/* View ������ ��ȯ�ϴ� �κ� */
		return "redirect:regionlist.it";
	}
	
	// ���� ���� ����
	@RequestMapping(value = "/regionupdate.it", method = RequestMethod.POST)
	public String regionupdate(Region r) {
		regionDAO.modify(r);
		/* View ������ ��ȯ�ϴ� �κ� */
		return "redirect:regionlist.it";
	}
	
	
}
