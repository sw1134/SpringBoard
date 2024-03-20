package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardMapper {
	//@Select("select * from tbl_board where bno > 0") // 어노테이션 방식
	// select
	public List<BoardVO> getList();
	
	// insert
	public void insert(BoardVO board);
	public void insertSelectKey(BoardVO board);
	
	// read
	public BoardVO read(Long bno);
	
	// delete
	public int delete(Long bno);
	
	// update
	public int update(BoardVO board);
}
