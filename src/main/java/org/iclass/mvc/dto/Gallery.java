package org.iclass.mvc.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Gallery {		// POJO : bean 생성이 안되는 일반적인 자바 객체

	private int idx;
	private String title;
	private String filename;		// 파일명 여러개를 , 로 구분해서 사용
	private LocalDateTime createAt;
	private String writer;
	private int hearts;
	
	// 테이블 컬럼에는 없고, 파일업로드에 사용합니다
	private List<MultipartFile> pics;		// html에 pics
	
}
