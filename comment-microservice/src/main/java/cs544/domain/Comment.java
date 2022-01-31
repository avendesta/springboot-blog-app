package cs544.domain;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.*;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;

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
	private Date commentedOn;
	private Boolean active;
	@Positive
	@NotNull
	private Integer userId;
	@Positive
	@NotNull
	private Integer postId;

	public Comment(String content, Date postedOn, Boolean active, Integer userId, Integer postId) {
		this(null, content, postedOn, active, userId, postId);
	}

	@PrePersist
	protected void prePersist() {
		commentedOn = new Date();
		active = true;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", postedOn=" + commentedOn + ", active=" + active
				+ ", userId=" + userId + ", postId=" + postId + "]";
	}
}