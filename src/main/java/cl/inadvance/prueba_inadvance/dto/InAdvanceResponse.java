package cl.inadvance.prueba_inadvance.dto;

import java.util.Date;

public class InAdvanceResponse {
	private String id;
	private Date created;
	private Date modified;
	private Date last_login;
	private String token;
	private boolean isactive;
	
	public InAdvanceResponse() {}

	public InAdvanceResponse(String id, Date created, Date modified, Date last_login, String token, boolean isactive) {
		this.id = id;
		this.created = created;
		this.modified = modified;
		this.last_login = last_login;
		this.token = token;
		this.isactive = isactive;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Date getLast_login() {
		return last_login;
	}

	public void setLast_login(Date last_login) {
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
	
	
}
