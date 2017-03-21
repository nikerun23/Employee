package com.test.sts;

public class FileRenamePolicy {
	
	public static String rename(String orginalFileName) {
		String result = "";
		
		//�����ϰ� �̸��� �������ִ� ��ƿ Ŭ����
		//���� ���, 18c076fc-d3f3-4189-8fc9-d650df376330 ������ ���ڿ� ������.
		String uniqueFileName = java.util.UUID.randomUUID().toString();

        int dot = orginalFileName.lastIndexOf(".");
        String ext = orginalFileName.substring(dot); // includes "."
        result = uniqueFileName + ext;
        
		return result;
	}

}
