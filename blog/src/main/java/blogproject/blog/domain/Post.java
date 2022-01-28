package blogproject.blog.domain;

import java.util.Date;

public class Post {
	private Integer id;
	private String title;
	private String content;
	private Date postedOn;
	private Boolean active;
	private Integer user_id;

	public Post() {
		
	}
	
	public Post(String title, String content, Date postedOn, boolean active, Integer user_id) {
		super();
		this.title = title;
		this.content = content;
		this.postedOn = postedOn;
		this.active = active;
		this.user_id = user_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content + ", postedOn=" + postedOn + ", active="
				+ active + ", user_id=" + user_id + "]";
	}
}
