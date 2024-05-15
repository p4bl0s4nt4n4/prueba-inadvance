package cl.inadvance.prueba_inadvance.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {
	@Id
	public String id;
	
	private String name;
	private String email;
	private String password;
	private LocalDateTime created;
	private LocalDateTime modified;
	private LocalDateTime last_login;
	private String token;
	private boolean isactive;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<PhoneEntity> phones;
	
	public UserEntity() {}

	public UserEntity(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	@PrePersist
	protected void onCreate() {
		this.id = UUID.randomUUID().toString();
		this.created = LocalDateTime.now();
		this.modified = LocalDateTime.now();
		this.last_login = LocalDateTime.now();
		this.token = UUID.randomUUID().toString();
		this.isactive = true;
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.modified = LocalDateTime.now();
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}

	public LocalDateTime getLast_login() {
		return last_login;
	}

	public void setLast_login(LocalDateTime last_login) {
		this.last_login = last_login;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public List<PhoneEntity> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneEntity> phones) {
		this.phones = phones;
	}
}
