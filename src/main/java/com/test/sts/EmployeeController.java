package com.test.sts;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

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
	
	@Autowired
	private ServletContext context;
	
	/* @RequestMapping ������̼ǿ��� method �Ӽ��� ��û ���(GET or POST)�� �м��� �� ��� */
	/* @RequestMapping ������̼ǰ� ����� �޼ҵ常 ���� ��û�� ���� ���� �޼ҵ尡 �� �� �ִ�. */
	/* ���� �޼ҵ��� �Ű� ���� ������ SpringWebMVC�� ���� �ڵ� �м��Ǳ� ������, �ʿ��� ��ü�� ��û�� �� ����Ѵ�. */
	/*
	 * method = {RequestMethod.GET, RequestMethod.POST}�� GET, POST ��� �� ���� ��� ���� ����
	 */
	// ���� ���  ��ü �� �˻� ��¿� �޼ҵ�
	@RequestMapping(value = "/employeelist.it", method = { RequestMethod.GET, RequestMethod.POST })
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
	
	@RequestMapping(value = "/employeeinsertform.it", method = { RequestMethod.GET, RequestMethod.POST })
	public String employeeinsertform(ModelMap model) {

		// �˻� ��û ������ ���� ó�� -> �������� �ڵ� ���� (�ڷ��� Ŭ���� �غ� or ��� ���� �غ�)
		
		List<Region> regionList = regionDAO.regionList();
		List<Department> departmentList = departmentDAO.departmentList();
		List<Position> positionList = positionDAO.positionList();
		
		model.addAttribute("regionList", regionList);
		model.addAttribute("departmentList", departmentList);
		model.addAttribute("positionList", positionList);
		
		return "employeeinsertform"; // "/WEB-INF/views/employeeinsertform.jsp"
	}
	
	// ���� ���� �߰�
	@RequestMapping(value = "/employeeinsert.it", method = RequestMethod.POST)
	public String employeeinsert(Employee emp) {
		// ���� ��û ������ ���� ó�� -> �������� �ڵ� ���� (�ڷ��� Ŭ���� �غ� or ��� ���� �غ�)
		employeeDAO.employeeAdd(emp);
		
		/* View ������ ��ȯ�ϴ� �κ� */
		return "redirect:employeelist.it";
	}
	
	// ���� ���� ����
	@RequestMapping(value = "/employeeupdateform.it", method = { RequestMethod.GET, RequestMethod.POST })
	public String employeeupdateform(ModelMap model, String employeeId) {
		// ���� ��û ������ ���� ó�� -> �������� �ڵ� ���� (�ڷ��� Ŭ���� �غ� or ��� ���� �غ�)
		List<Employee> list = null;
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("key", "employeeId");
		map.put("value", employeeId);
		
		list = employeeDAO.employeeList(map);
		Employee emp = list.get(0);
		List<Region> regionList = regionDAO.regionList();
		List<Department> departmentList = departmentDAO.departmentList();
		List<Position> positionList = positionDAO.positionList();
		
		model.addAttribute("emp", emp);
		model.addAttribute("regionList", regionList);
		model.addAttribute("departmentList", departmentList);
		model.addAttribute("positionList", positionList);
		
		/* View ������ ��ȯ�ϴ� �κ� */
		return "employeeupdateform";
	}
	
	// ���� ���� �˻� ��¿�
	@RequestMapping(value = "/ajaxpicture.it", method = RequestMethod.POST)
	public String ajaxpicture(ModelMap model, Employee emp) {
		// ���� ��û ������ ���� ó�� -> �������� �ڵ� ���� (�ڷ��� Ŭ���� �غ� or ��� ���� �غ�)
		System.out.println("ajaxpictureȣ��");
		String result = null;
		List<Employee> list = employeeDAO.pictureList(emp);
		System.out.println(list.get(0).getEmployeePicFileName());
		result = list.get(0).getEmployeePicFileName();
		model.addAttribute("result", result);
		
		/* View ������ ��ȯ�ϴ� �κ� */
		return "ajaxpicture";
	}
	
	// ���� ���� �߰�
	@RequestMapping(value = "/employeepictureinsert.it", method = { RequestMethod.GET, RequestMethod.POST })
	public String employeepictureinsert(Employee file, BindingResult result) throws IOException {
		System.out.println("employeepictureinsert �޼ҵ� ȣ��");

		if (result.hasErrors()) {
			System.out.println("validation errors");
			return "redirect:fileuploaderror.it";
		} else {
			System.out.println("file.getFile()="+file.getFile());
			//���ε� ���Ͽ� ���� ��ü ����
			MultipartFile multipartFile = file.getFile();

			System.out.println("multipartFile="+multipartFile);
			// Create a folder picture under WebContent sub-folder.
			// ����) ServletContext ��ü�� �̿��� ��θ� Ȯ�� �ʼ�
			String uploadPath = context.getRealPath("") + "resources/picture" + File.separator;

			// ���� �ߺ� �˻� ���� �߰� or ������ ���ϸ� ���� ���� -> ����� ���� �ۼ�
			String newFileName = FileRenamePolicy.rename(multipartFile.getOriginalFilename());

			// ���� Ÿ�� Ȯ��
			String contentType = multipartFile.getContentType();
			// ���� ������ Ȯ��
			long fileSize = multipartFile.getSize();

			// ���� -> image/jpeg, image/png
			if ((contentType.equals("image/jpeg") || contentType.equals("image/png")) && fileSize <= 1024 * 500) {
				
				// ���� ���ε� �׼�
				FileCopyUtils.copy(multipartFile.getBytes(), new File(uploadPath + newFileName));

				System.out.println("uploadPath="+uploadPath);
				System.out.println("contentType="+contentType);
				System.out.println("oldFileName="+multipartFile.getOriginalFilename());
				System.out.println("newFileName="+newFileName);
				// DB�� ���� ���� ����
				
				System.out.println("file.getEmployeeId()="+file.getEmployeeId());
				System.out.println("file.getEmployeePicFileName()="+file.getEmployeePicFileName());
				
				file.setEmployeePicFileName(newFileName);
				
				employeeDAO.pictureAdd(file);
				
				return "redirect:employeelist.it";// "WEB-INF/source/employeelist.jsp"
				
			} else {
				return "redirect:fileuploaderror.it";
			}

		}
	}
	
	// �ּұ⺻�� �˻�
	@RequestMapping(value = "/ajaxminbasicpay.it", method = RequestMethod.POST)
	public String ajaxminbasicpay(ModelMap model, Position p) {
		// ���� ��û ������ ���� ó�� -> �������� �ڵ� ���� (�ڷ��� Ŭ���� �غ� or ��� ���� �غ�)
		String result = "0";
		result = String.valueOf(positionDAO.getMinBasicPay(p));
		
		model.addAttribute("result", result);
		
		/* View ������ ��ȯ�ϴ� �κ� */
		return "ajaxminbasicpay";
	}
	
	
}