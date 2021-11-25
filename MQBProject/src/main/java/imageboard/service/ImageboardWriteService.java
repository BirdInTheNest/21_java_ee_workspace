package imageboard.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import imageboard.bean.ImageboardDTO;
import imageboard.dao.ImageboardDAO;

public class ImageboardWriteService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//실제폴더 D:\java_ee\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\MQBProject\storage
		String realFolder = request.getServletContext().getRealPath("/storage");
		System.out.println(realFolder);
		
		//업로드 - 같은 파일을 올려도 DefaultFileRenamePolicy()가 있으면 파일명을 변경한다, 잘 안 씀
		MultipartRequest multi = new MultipartRequest(request
													, realFolder
													, 5*1024*1024 //5MB 최대용량
													, "UTF-8"
													, new DefaultFileRenamePolicy());
		
		//데이터 - 업로드하면 데이터를 불러오는 모든 권한이 HttpServletRequest에서 MultipartRequest로 변한다
		String imageId = multi.getParameter("imageId");
		String imageName = multi.getParameter("imageName");
		int imagePrice = Integer.parseInt(multi.getParameter("imagePrice"));
		int imageQty = Integer.parseInt(multi.getParameter("imageQty"));
		String imageContent = multi.getParameter("imageContent");
		
		String image1 = multi.getOriginalFileName("image1"); //원본 파일명
		//String image1 = multi.getFilesystemName("image1"); //변경된 파일명
		
		ImageboardDTO imageboardDTO = new ImageboardDTO();
		imageboardDTO.setImageId(imageId);
		imageboardDTO.setImageName(imageName);
		imageboardDTO.setImagePrice(imagePrice);
		imageboardDTO.setImageQty(imageQty);
		imageboardDTO.setImageContent(imageContent);
		imageboardDTO.setImage1(image1); //파일명만 싣는다
		
		//DB
		ImageboardDAO imageboardDAO = ImageboardDAO.getInstance();
		imageboardDAO.imageboardWrite(imageboardDTO);
		
		//응답
		request.setAttribute("display", "/imageboard/imageboardWrite.jsp");
		return "/index.jsp";
	}
}