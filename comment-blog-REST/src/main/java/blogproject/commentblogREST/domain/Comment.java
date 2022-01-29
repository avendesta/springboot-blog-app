package blogproject.commentblogREST.domain;
import java.util.Date;

import javax.persistence.*;
import lombok.*;

@Entity(name="Comments")
@NoArgsConstructor @Getter @Setter
@AllArgsConstructor
public class Comment {
	@Id
	@GeneratedValue
	private Integer id;
	private String content;	
	@Temporal(TemporalType.DATE)
	private Date commentedOn;
	private Boolean active;
	private Integer userId;
	private Integer postId;
	
//	public Comment(String content, Date postedOn, Boolean active, Integer userId, Integer postId) {
//		super();
//		this.content = content;
//		this.postedOn = postedOn;
//		this.active = active;
//		this.userId = userId;
//		this.postId = postId;
//	}
	public Comment(String content, Date postedOn, Boolean active, Integer userId, Integer postId) {
		this(null, content, postedOn, active, userId, postId);
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", postedOn=" + commentedOn + ", active="
				+ active + ", userId=" + userId + ", postId=" + postId + "]";
	}

}