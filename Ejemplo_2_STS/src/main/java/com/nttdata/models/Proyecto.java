package com.nttdata.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="proyectos")
public class Proyecto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String descripcion;
	
	@Column(updatable = false)
	private Date createdAt;
	
	private Date updatedAt;

	//relacion 1 a muchos
	//Un proyecto va a tener muchos usuarios
	@OneToMany(mappedBy = "proyecto", 
			fetch = FetchType.LAZY)
	private List<Usuario> usuarios;
	
	public Proyecto() {
		super();
	}

	public Proyecto(String nombre, String descripcion, Date createAt, Date updateAt) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.createdAt = createAt;
		this.updatedAt = updateAt;
	}
	
	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", createAt=" + createdAt
				+ ", updateAt=" + updatedAt + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getCreateAt() {
		return createdAt;
	}

	public void setCreateAt(Date createAt) {
		this.createdAt = createAt;
	}

	public Date getUpdateAt() {
		return updatedAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updatedAt = updateAt;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
}
