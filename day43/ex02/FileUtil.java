package ex02;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

public class FileUtil {
	private static FileUtil instance = new FileUtil();
	public static FileUtil getInstance() {
		return instance;
	}
	
	private FileUtil() {}
	
	
	// 파일처리에 관련된 필드
	
	private String saveDirectory = null;
	private int maxPostSize = 1024*1024*20;
	private String encoding = "UTF-8";
	private FileRenamePolicy policy = new DefaultFileRenamePolicy();
	
	// request를 전달받아서, 파일 및 다른 데이터를 DTO에 담아서 반환하는 함수
	public Ex02DTO getDTO(HttpServletRequest request) throws IOException, ParseException {
		Ex02DTO dto = null;
		
		// 1)저장할 디렉토리가 없으면 새로 생성해야한다
		if(saveDirectory == null) {
			ServletContext application = request.getServletContext();
			saveDirectory = application.getRealPath("/upload");
			File dir = new File(saveDirectory);
			dir.mkdirs();
			
			System.out.println(saveDirectory);
		}
		
		// 2)request를 이용하여 MultipartRequest 객체를 생성한다
		// 이때, 첨부파일은 saveDirectory위치에 자동으로 생성된다 (업로드된다)
		MultipartRequest mpRequest = new MultipartRequest(request, saveDirectory,maxPostSize,encoding, policy);
		
		// 3) 일반 문자열 파라미터는 getParameter(Stirng name)으로 받는다
		String title = mpRequest.getParameter("title");
		
		// 4) 첨부파일은 getFile(String name)으로 받는다
		File image = mpRequest.getFile("image");
		
		//5) java.sql.Date는 new java.sql.Date(new java.util.Date().getTime())로 받는다
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String inputDate = mpRequest.getParameter("eventDate");
		java.util.Date d1 = sdf.parse(inputDate);
		java.sql.Date d2 = new java.sql.Date(d1.getTime());
		
		// 6) 준비된 값을 dto에 모두 세팅한다
		dto = new Ex02DTO();
		dto.setTitle(title);
		dto.setImage(image.getName());
		dto.setEventDate(d2);
		
		return dto;
	}
	
	public String[] getFileNames() {
		String[] arr = null;
		if(saveDirectory!= null) {
			File dir = new File(saveDirectory);
			arr = dir.list();
		}
		return arr;
	}
}
