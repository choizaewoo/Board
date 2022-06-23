package kr.ac.kopo.ctc.kopo42.dao;

import java.util.List;

import kr.ac.kopo.ctc.kopo42.domain.BoardItem;

public interface BoardItemDao {

		void create(BoardItem boardItem);
		BoardItem selectOne(int id) ;
		List<BoardItem> selectAll(int page, int countPerPage);
		void update(BoardItem boardItem);
		void delete(int id);
		int count();
		void deleteAll(BoardItem boardItem);
		
		
}
