package proj.integrador.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity(name = "produto")
public class ProdutoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "nome")
	private String nome;
	private String descricao;
	private String lote;
	private double preco;
	
	@ManyToMany
	@JoinTable(
			name = "produto_atletica",
			joinColumns = @JoinColumn(name = "produto"),
			inverseJoinColumns = @JoinColumn(name = "atletica")
			)
	private List<AtleticaEntity> atletica;
	
	@ManyToMany
	@JoinTable(
			name = "produto_usuario",
			joinColumns = @JoinColumn(name = "produto"),
			inverseJoinColumns = @JoinColumn(name = "usuario")
			)
	private List<UsuarioEntity> usuario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public List<AtleticaEntity> getAtletica() {
		return atletica;
	}

	public void setAtletica(List<AtleticaEntity> atletica) {
		this.atletica = atletica;
	}

	public List<UsuarioEntity> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<UsuarioEntity> usuario) {
		this.usuario = usuario;
	}

	
	

}
