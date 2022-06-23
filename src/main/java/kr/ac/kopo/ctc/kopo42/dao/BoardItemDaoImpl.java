package kr.ac.kopo.ctc.kopo42.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.ctc.kopo42.domain.BoardItem;

public class BoardItemDaoImpl implements BoardItemDao {

	@Override
	public void create(BoardItem boardItem) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sql = "";
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.110:33061/kopoctc", "rooot",
					"kopo42");
			Statement stmt = conn.createStatement();
//			sql = "insert into gongji(title,date,content) values('공지사항6',date(now()),'공지사항내용55');";

			sql = "insert into gongi(title,date,content) values('" + boardItem.getTitle() + "',content ='"
					+ boardItem.getContent() + "' where id = " + boardItem.getId() + ";";
			stmt.execute(sql);
			sql = "select * from gongji;";
			ResultSet rset = stmt.executeQuery(sql);
			while (rset.next()) {

				boardItem.setId(rset.getInt(1));
				boardItem.setTitle(rset.getString(2));

			}
			rset.close();
			stmt.close();
			conn.close();

		} catch (Exception e) {
			// TODO: handle exception

		}
//		return boardItem;
	}

	@Override
	public BoardItem selectOne(int id) {
		BoardItem boardItem = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.110:33061/kopoctc", "rooot",
					"kopo42");
			Statement stmt = conn.createStatement();
			String sql = "";
			sql = "select * from gongji where id = " + id + ";";
			ResultSet rset = stmt.executeQuery(sql); // 쿼리문을 실행하고 반환한 값을 저장.
			while (rset.next()) {
				boardItem = new BoardItem();
				boardItem.setId(rset.getInt(1));
				boardItem.setTitle(rset.getString(2));
				boardItem.setDate(rset.getDate(3));
				boardItem.setContent(rset.getString(4));
			}
			rset.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return boardItem;
	}

	@Override
	public List<BoardItem> selectAll(int page, int countPerPage) {
		String sql = "";
		List<BoardItem> boardItems = new ArrayList<BoardItem>();
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.110:33061/kopoctc", "rooot",
					"kopo42");
			Statement stmt = conn.createStatement();

			sql = "select * from gongji limit " + countPerPage * (page - 1) + "," + countPerPage + ";";
			ResultSet rset = stmt.executeQuery(sql); // 쿼리문을 실행하고 반환한 값을 저장.

			while (rset.next()) {
				BoardItem boardItem = new BoardItem();
				boardItem.setId(rset.getInt(1));
				boardItem.setTitle(rset.getString(2));
				boardItem.setDate(rset.getDate(3));
				boardItem.setContent(rset.getString(4));
				boardItems.add(boardItem);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return boardItems;
	}

	@Override
	public void update(BoardItem boardItem) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sql = "";
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.110:33061/kopoctc", "rooot",
					"kopo42");
			Statement stmt = conn.createStatement();
			sql = "update gongji set title ='" + boardItem.getTitle() + "',content ='" + boardItem.getContent()
					+ "' where id = " + boardItem.getId() + ";";
			stmt.execute(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void delete(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String sql = "";
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.110:33061/kopoctc", "rooot",
					"kopo42");
			Statement stmt = conn.createStatement();
			sql = "delete from gongji where id = " + id + ";";
			stmt.execute(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public int count() {
		int totalCounts = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.110:33061/kopoctc", "rooot",
					"kopo42");
			Statement stmt = conn.createStatement();

			String sql = "";
			sql = "select count(*) from gongji;";
			ResultSet rset = stmt.executeQuery(sql); // 쿼리문을 실행하고 반환한 값을 저장.
			rset.next();
			totalCounts = rset.getInt(1);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return totalCounts;
	}

	@Override
	public void deleteAll(BoardItem boardItem) {
		// TODO Auto-generated method stub

	}

//	@Override
//	public void deleteAll() throws ClassNotFoundException, SQLException {
//		// TODO Auto-generated method stub
//
//	}

//	@Override
//	public void deleteAll(BoardItem boardItem) throws ClassNotFoundException, SQLException {
//		Class.forName("com.mysql.jdbc.Driver");
//		String sql = "";
//		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.110:33061/kopoctc", "rooot", "kopo42");
//		Statement stmt = conn.createStatement();
//		sql = "delete from gongji;";
//		stmt.execute(sql);
//
//	}

}