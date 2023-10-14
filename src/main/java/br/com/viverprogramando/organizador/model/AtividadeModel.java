package br.com.viverprogramando.organizador.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="atividade")
public class AtividadeModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String descricao;
	
	@ManyToOne
	private TarefaModel tarefa;
	
	
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
	public TarefaModel getTarefa() {
		return tarefa;
	}
	public void setTarefa(TarefaModel tarefa) {
		this.tarefa = tarefa;
	}
	
	

}
