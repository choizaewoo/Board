<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,javax.sql.*,java.io.*,java.util.List"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="kr.ac.kopo.ctc.kopo42.domain.BoardItem"%>
<%@ page import="kr.ac.kopo.ctc.kopo42.dao.BoardItemDao"%>
<%@ page import="kr.ac.kopo.ctc.kopo42.dao.BoardItemDaoImpl"%>
<%@ page import="kr.ac.kopo.ctc.kopo42.service.BoardItemService"%>
<%@ page import="kr.ac.kopo.ctc.kopo42.service.BoardItemServiceImpl"%>
<%@ page import="kr.ac.kopo.ctc.kopo42.service.dto.Pagination"%>



<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	BoardItem boardItem = new BoardItem();

	pageContext.setAttribute("boardItem", boardItem);
	pageContext.setAttribute("name", "양");

	BoardItemService boardItemService = new BoardItemServiceImpl();
	Pagination pagination = boardItemService.getPagination(1, 15, 50, 1025);
	pageContext.setAttribute("pagination", pagination);
	pageContext.setAttribute("pagination", pagination);

	BoardItemDao boardItemDao = new BoardItemDaoImpl();
	List<BoardItem> boardItems = boardItemDao.selectAll(1, 50);
	pageContext.setAttribute("boardItems", boardItems);

	/* BoardItem boardItem1 = new BoardItem();
	BoardItem boardItem2 = new BoardItem();
	boardItem2.setTitle("bbb");
	boardItem2.setTitle("aaa");
	boardItems.add(boardItem1);
	boardItems.add(boardItem2); */

	pageContext.setAttribute("boardItems", boardItems);
	%>



	<div>${mame}</div>
	<div>${pagination.p}</div>
		<table width=600 cellspacing=0 border=1 cellpadding=1>
	<tr>
		<td>id</td>
		<td>title</td>
		<td>date</td>
		<td>content</td>
	</tr>
	<c:forEach var="item" items="${boardItems}">
<!-- 		<table width=600 cellspacing=0 border=1 cellpadding=1>
 -->			<tr>
				<td>${item.id}</td>
				<td>${item.title}</td>
				<td>${item.date}</td>
				<td>${item.content}</td>
			</tr>
	</c:forEach>
			</table>
	

</body>
</html>



