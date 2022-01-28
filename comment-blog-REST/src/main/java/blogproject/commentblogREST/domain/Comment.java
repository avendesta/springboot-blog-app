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
	private Date postedOn;
	private Boolean active;
	private Integer user_id;
	private Integer post_id;
	
//	public Comment(String content, Date postedOn, Boolean active, Integer user_id, Integer post_id) {
//		super();
//		this.content = content;
//		this.postedOn = postedOn;
//		this.active = active;
//		this.user_id = user_id;
//		this.post_id = post_id;
//	}
	public Comment(String content, Date postedOn, Boolean active, Integer user_id, Integer post_id) {
		this(null, content, postedOn, active, user_id, post_id);
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", postedOn=" + postedOn + ", active="
				+ active + ", user_id=" + user_id + ", post_id=" + post_id + "]";
	}

}