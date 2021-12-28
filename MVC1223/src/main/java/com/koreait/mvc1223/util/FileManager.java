package com.koreait.mvc1223.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.koreait.mvc1223.domain.Notice;
import com.koreait.mvc1223.exception.UploadException;

//파일 처리와 관련된 다양한 업무를 처리해주는 전담자 클래스
public class FileManager {

	
	
	//파일 저장(웹으로 전달된...)
	public static String saveAsFile(HttpServletRequest request, Notice notice)throws UploadException {
		boolean result = false;
		MultipartFile multi= notice.getMyFile();
		String filename =null;
		System.out.println("getName():" + multi.getName()); //html name
		System.out.println("getFilename():" + multi.getOriginalFilename());
		
		//아직 컴포넌트 상태에서 파일이 메모리에 올라와 있기만 하므로, 실제 서버의 하드디스크에 저장해보자!!
		//jsp였다면 application 내장객체로 해결가능하겠으나, 현재는 그냥 스프링의 컨트롤러 일뿐이다..
		//해결책?? request - HttpServletRequest, session - HttpSession, application - ServletContext
		try {
			ServletContext application =request.getServletContext() ;
			String saveDir= application.getRealPath("/resources/data");
			System.out.println("realPath" + saveDir);
			filename= createFilename(multi.getOriginalFilename());
			File file = new File(saveDir+"/"+filename);//full path
			multi.transferTo(file);
			result=true;
		} catch (IllegalStateException e) {
			e.printStackTrace();
			result=false;
		} catch (IOException e) {
			e.printStackTrace();
			result=false;
		}
		if(result==false) {
			throw new UploadException("업로드 실패");
		}
		return filename;
	}
	
	
	
	//파일명 생성
	public static String createFilename(String path) {
		long time = System.currentTimeMillis();
		String ext= getExt(path);
		return time+ext;
	}
	
	//확장자 추출
	public static String getExt(String path) {
		int index= path.lastIndexOf(".");
		return path.substring(index+1,path.length());
		
	}
	
	public static void main(String[] args) {
		System.out.println(createFilename("sldkfjsf.sleifkes.slkfj.jpg"));
	}
}
