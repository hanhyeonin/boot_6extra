package org.iclass.mvc.service;

import java.util.List;

import org.iclass.mvc.dto.Gallery;

public interface GalleryService {		// 서비스를 인터페이스로 하는 이유는?
	// 같은 기능을 여러가지 방법으로 구현해서 테스트 또는 업그레이드할 때 기존과 호환시키기 위해서 합니다.
	
	List<Gallery> getlist();
	int save(Gallery dto);
	List<Gallery> getOne(String writer);		// writer 가 작성한 글들 가져오기
	int hearts(int idx);						// 특정 글의 좋아요 갯수

}
