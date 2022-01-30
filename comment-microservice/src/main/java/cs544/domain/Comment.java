package cs544.domain;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

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
	@Future
	@Temporal(TemporalType.DATE)
	private Date commentedOn;
	private Boolean active;
	@Positive
	private Integer userId;
	@Positive
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