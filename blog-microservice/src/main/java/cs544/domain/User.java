package cs544.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	private String userName;
	private String firstName;
	private String lastName;
	private Integer roleId;

	public User(String userName, String firstName, String lastName, Integer roleId) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.roleId = roleId;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", roleId=" + roleId + "]";
	}

}
