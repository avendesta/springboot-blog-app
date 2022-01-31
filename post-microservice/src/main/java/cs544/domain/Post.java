package cs544.domain;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Post {
	@Id
	@GeneratedValue
	private Integer id;
	@NotBlank
	private String title;
	@NotBlank
	private String content;
	private Date postedOn;
	private Boolean active;
	@Positive
	@NotNull
	private Integer userId;

	public Post(String title, String content, Date postedOn, boolean active, Integer user_id) {
		super();
		this.title = title;
		this.content = content;
		this.postedOn = postedOn;
		this.active = active;
		this.userId = user_id;
	}

	@PrePersist
	protected void prePersist() {
		postedOn = new Date(); active=true;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content + ", postedOn=" + postedOn + ", active="
				+ active + ", user_id=" + userId + "]";
	}
}
