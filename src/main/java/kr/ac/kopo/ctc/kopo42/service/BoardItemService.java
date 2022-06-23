package kr.ac.kopo.ctc.kopo42.service;

import java.util.List;

import kr.ac.kopo.ctc.kopo42.domain.BoardItem;
import kr.ac.kopo.ctc.kopo42.dao.BoardItemDaoImpl;
import kr.ac.kopo.ctc.kopo42.service.dto.Pagination;

public interface BoardItemService {
	
	Pagination getPagination(int c, int pageSize, int counterPerPage, int totalCount);
	BoardItemDaoImpl create(BoardItemDaoImpl boardItem);
	BoardItem selectOne(int id);
	List<BoardItem> selectAll(int page, int countPerPage);
	void update(BoardItem boardItem);
	void delete(int id);
	int count();
	void create(BoardItem boardItem);
}
