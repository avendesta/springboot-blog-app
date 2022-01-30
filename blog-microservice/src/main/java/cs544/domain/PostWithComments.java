package cs544.domain;

import java.util.LinkedList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PostWithComments {
	Post post;
	private List<Comment> comments = new LinkedList<Comment>();
	
	public void addComment(Comment comment) {
		comments.add(comment);
	}
	public List<Comment> getComments(){
		return comments;
	}
	
}
