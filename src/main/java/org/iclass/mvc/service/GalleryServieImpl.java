package org.iclass.mvc.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.iclass.mvc.dao.GalleryMapper;
import org.iclass.mvc.dto.Gallery;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GalleryServieImpl implements GalleryService {
	
	// 의존성 주입 : 필드 주입은 사용하지 않습니다.
	private GalleryMapper dao;

	// @Autowired 생략(생성자 주입)
	public GalleryServieImpl(GalleryMapper dao) {
		this.dao=dao;
	}

	public List<Gallery> getlist() {
		return dao.getlist();
	}

	@Override
	public int save(Gallery dto) {		// controller 에서 넘어온 parameter 값들로 insert + fileUpload
		String path = "D:\\i_Class1020\\uploads";
		// 파일 업로드
		for(MultipartFile f : dto.getPics()) {
			if(f.getSize()!=0) {								// getSize() : 첨부파일의 크기
				String ofilename = f.getOriginalFilename();		// 원래 파일명 (파일이름.확장자)
				
				// 원래파일명을 사용할 경우 파일이름이 길어질까봐 주석처리함. 
//				String prefix = ofilename.substring(0, ofilename.lastIndexOf(".")); // 파일이름
				
				String postfix = ofilename.substring(ofilename.lastIndexOf("."));	// 확장자
				StringBuilder newfile = new StringBuilder("gallert_")
				//		.append(prefix)			// 원래파일명
						.append(UUID.randomUUID().toString().substring(0,8))
						.append(postfix);		// 확장자
				
				// path 경로에 newfile 새로운 파일명으로 File 객체 생성해서 저장
				File file = new File(path+"\\"+newfile);		
				
				// 저장
				try {
					f.transferTo(file);
				} catch (IOException e) {	}
				
			}
		}
		return 0;
	}

	@Override
	public List<Gallery> getOne(String writer) {
		return dao.getOne(writer);
	}

	@Override
	public int hearts(int idx) {
		return dao.hearts(idx);
	}

	
}
