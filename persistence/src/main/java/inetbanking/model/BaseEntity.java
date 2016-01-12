package inetbanking.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity implements Serializable{
	private static final long serialVersionUID = 8657910983853823384L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	boolean deleted;
	
	public BaseEntity(Long id, boolean deleted) {
		super();
		this.id = id;
		this.deleted = deleted;
	}
	public BaseEntity(Long id)
	{
		super();
		this.id = id;
	}
	public BaseEntity() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}
