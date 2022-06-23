package kr.ac.kopo.ctc.kopo42.domain;

import java.util.Date;

public class BoardItem {
	private int id;
	private String title;
	private Date created;
	private String content;
	private int view;
	private String author;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return created;
	}
	public void setDate(Date created) {
		this.created = created;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	

	}


