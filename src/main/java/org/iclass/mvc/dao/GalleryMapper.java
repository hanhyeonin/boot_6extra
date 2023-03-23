package org.iclass.mvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.iclass.mvc.dto.Gallery;

@Mapper
public interface GalleryMapper {

	List<Gallery> getlist();
	int save(Gallery dto);
	List<Gallery> getOne(String writer);		
	int hearts(int idx);
}
