package kr.ac.kopo.ctc.kopo42.service;

import java.util.List;

import kr.ac.kopo.ctc.kopo42.dao.BoardItemDao;
import kr.ac.kopo.ctc.kopo42.dao.BoardItemDaoImpl;
import kr.ac.kopo.ctc.kopo42.domain.BoardItem;
import kr.ac.kopo.ctc.kopo42.service.dto.Pagination;

public class BoardItemServiceImpl implements BoardItemService {

	private BoardItemDao boardItemDao = new BoardItemDaoImpl();

	// Parameter : cPage : 현재 페이지 , countPerPage : 한 페이지에 나올 숫자 목록, pageSize : 한 페이지
	// 게시글 수, totalCount : 전체 게시글 수
	// 결과값 : Pp : 첫 페이지, p: 이전 쪽, n : 다음 쪽, nn: 끝페이지, c:현재 페이지
	@Override
	public Pagination getPagination(int c, int pageSize, int countPerPage, int totalCount) {

		Pagination pagination = new Pagination();

//		pagination.setPp(1);
//		pagination.setP(1);
//		pagination.setN(31);
//		pagination.setNn(67071);
//		pagination.setC(23);
//		pagination.setStart(16);
//		pagination.setEnd(30);

		int nn = (int) Math.ceil(totalCount / countPerPage);


		if (totalCount % countPerPage != 0) {
			nn += 1;
		}
		if (c < 1) {
			c = 1;
		}

		

		if (c > nn) {
			c = nn;
		}
		int start = c - (c % pageSize) + 1;
		int end = start + pageSize - 1;
		


		int p = c - pageSize;
		int n = start + pageSize;

		if (p < 1) {
			p = 1;
		}

		if (n > nn) {
			n = nn - (nn % pageSize) + 1;
		}

		if (end > nn) {
			end = nn;
		}

		pagination.setC(c);
		pagination.setStart(start);
		pagination.setEnd(end);
		pagination.setPp(1);
		pagination.setNn(nn);
		pagination.setP(p);
		pagination.setN(n);

		return pagination;
	}

	@Override
	
	public void create(BoardItem boardItem) {
		// TODO Auto-generated method stub
//		return boardItemDao.create(boardItem);
	}

	@Override
	public BoardItem selectOne(int id) {
		// TODO Auto-generated method stub
		return boardItemDao.selectOne(id);
	}

	@Override
	public List<BoardItem> selectAll(int page, int countPerPage) {
		// TODO Auto-generated method stub
		return boardItemDao.selectAll(page, countPerPage);
	}

	@Override
	public void update(BoardItem boardItem) {
		// TODO Auto-generated method stub
//		return boardItemDao.update(boardItem);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
//		return boardItemDao.delete(id);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardItemDaoImpl create(BoardItemDaoImpl boardItem) {
		// TODO Auto-generated method stub
		return null;
	}

}
