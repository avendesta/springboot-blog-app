package cs544.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

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
	@NotBlank
	@Temporal(TemporalType.DATE)
	private Date postedOn;
	@NotBlank
	private Boolean active;
	@NotBlank
	private Integer userId;

	public Post(String title, String content, Date postedOn, boolean active, Integer user_id) {
		super();
		this.title = title;
		this.content = content;
		this.postedOn = postedOn;
		this.active = active;
		this.userId = user_id;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content + ", postedOn=" + postedOn + ", active="
				+ active + ", user_id=" + userId + "]";
	}
}
