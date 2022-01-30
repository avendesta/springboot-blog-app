package cs544.domain;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.*;

@Entity(name = "Comment")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Comment {
	@Id
	@GeneratedValue
	private Integer id;
	@NotBlank
	private String content;
	@NotBlank
	@Temporal(TemporalType.DATE)
	private Date commentedOn;
	@NotBlank
	private Boolean active;
	@NotBlank
	private Integer userId;
	@NotBlank
	private Integer postId;

	public Comment(String content, Date postedOn, Boolean active, Integer userId, Integer postId) {
		this(null, content, postedOn, active, userId, postId);
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", postedOn=" + commentedOn + ", active=" + active
				+ ", userId=" + userId + ", postId=" + postId + "]";
	}

}