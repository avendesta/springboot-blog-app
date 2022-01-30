package cs544.domain;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Post {
	private Integer id;
	private String title;
	private String content;
	private Date postedOn;
	private Boolean active;
	private Integer user_id;
	
	public Post(String title, String content, Date postedOn, Boolean active, Integer user_id) {
		super();
		this.title = title;
		this.content = content;
		this.postedOn = postedOn;
		this.active = active;
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content + ", postedOn=" + postedOn + ", active="
				+ active + ", user_id=" + user_id + "]";
	}
}
