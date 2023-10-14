package br.com.viverprogramando.organizador.model;


import br.com.viverprogramando.organizador.utils.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="tarefa")
public class TarefaModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private long id;
	private String descricao;
	
	@ManyToOne
	private ProjetoModel projeto;
	
	@ManyToOne
	private UsuarioModel usuario;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public ProjetoModel getProjeto() {
		return projeto;
	}
	public void setProjeto(ProjetoModel projeto) {
		this.projeto = projeto;
	}

	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public UsuarioModel getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}
	
	
	

}
