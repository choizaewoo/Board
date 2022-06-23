package kr.ac.kopo.ctc.kopo42.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.extensions.TestSetup;
import kr.ac.kopo.ctc.kopo42.domain.BoardItem;

class BoardItemDaoTest {
	public BoardItemDao boardItemDao = new BoardItemDaoImpl();
	private BoardItem boardItem1;
	private BoardItem boardItem2;

//	@BeforeEach
//	void setUp() throws Exception {
//		boardItemDao.deleteAll();
//
//		boardItem1 = new BoardItem();
//		boardItem1.setId(1);
//		boardItem1.setTitle("title");
//		boardItemDao.create(boardItem1);
//
////	}
//
//	@AfterEach
//	void tearDown() throws Exception {

//	}

	@Test
	void deleteAll() throws ClassNotFoundException, SQLException {
		boardItemDao.deleteAll(boardItem1);

	}

	@Test
	void create() {
		BoardItem boardItem = new BoardItem();
//		BoardItem boardItem = boardItemDao.selectOne(1);
		boardItemDao.create(boardItem1);
		assertEquals(boardItem.getId(), 0);
		assertEquals(boardItem.getTitle(), null);

	}

	@Test
	void selectOne() {
//		BoardItem boardItem = boardItemDao.selectOne(1);
		BoardItem boardItem = new BoardItem();
		boardItemDao.selectOne(1);
		assertEquals(boardItem.getId(), 0);
		assertEquals(boardItem.getTitle(), null);
		assertEquals(boardItem.getDate(), null);
		assertEquals(boardItem.getContent(), null);

	}

	@Test
	void selectAll() {
//		BoardItem boardItem = boardItemDao.selectOne(1);
		BoardItem boardItem = new BoardItem();
		boardItemDao.selectAll(1, 2);
		assertEquals(boardItem.getId(), 0);
		assertEquals(boardItem.getTitle(), null);
		assertEquals(boardItem.getDate(), null);
		assertEquals(boardItem.getContent(), null);

	}

	@Test
	void update() {
		BoardItem boardItem = new BoardItem();
//		BoardItem boardItem = boardItemDao.selectOne(1);

		boardItem1 = new BoardItem();

		boardItem1.setId(3);
		boardItem1.setTitle("공지사항맞냐?");
		boardItem1.setContent("맞다");

		boardItem2 = new BoardItem();
		boardItem2.setId(4);
		boardItem2.setTitle("아아알알겠따.");
		boardItem2.setContent("거짓");

		boardItemDao.update(boardItem1);
		boardItemDao.update(boardItem2);

		boardItem = boardItemDao.selectOne(3);
		


		assertEquals(boardItem.getId(), 3);
		assertEquals(boardItem.getTitle(), "공지사항맞냐?");
		assertEquals(boardItem.getContent(), "맞다");

		boardItem = boardItemDao.selectOne(4);
		assertEquals(boardItem.getId(), 4);
		assertEquals(boardItem.getTitle(), "아아알알겠따.");
		assertEquals(boardItem.getContent(), "거짓");

	}

	@Test
	void delete() {
		BoardItem boardItem = new BoardItem();
//		BoardItem boardItem = boardItemDao.selectOne(1);
		boardItemDao.delete(2);
		assertEquals(boardItem.getId(), 0);
		assertEquals(boardItem.getTitle(), null);
		assertEquals(boardItem.getDate(), null);
		assertEquals(boardItem.getContent(), null);
	}

	@Test
	void count() {
		BoardItem boardItem = new BoardItem();
//		BoardItem boardItem = boardItemDao.selectOne(1);
		boardItemDao.count();
		assertEquals(boardItem.getId(), 0);
		assertEquals(boardItem.getTitle(), null);
		assertEquals(boardItem.getDate(), null);
		assertEquals(boardItem.getContent(), null);
	}

}