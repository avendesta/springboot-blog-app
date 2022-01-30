package cs544.domain;
import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @Getter @Setter
public class Comment {
	private Integer id;
	private String content;	
	private Date commentedOn;
	private Boolean active;
	private Integer userId;
	private Integer postId;
	
	public Comment(String content, Date commentedOn, Boolean active, Integer user_id, Integer post_id) {
		this.content = content;
		this.commentedOn = commentedOn;
		this.active = active;
		this.userId = user_id;
		this.postId = post_id;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", postedOn=" + commentedOn + ", active="
				+ active + ", user_id=" + userId + ", post_id=" + postId + "]";
	}

}