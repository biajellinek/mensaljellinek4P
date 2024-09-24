package proj.integrador.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Setter
//@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity(name = "atletica")
public class AtleticaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Integer donoId;
	private String nome;
	private String universidade;
	private String cnpj;
	
	@ManyToMany(mappedBy = "atletica")//muitas atleticas para muitos usuarios
	private List<UsuarioEntity> usuario; //lindo
	
	@ManyToMany(mappedBy = "atletica")
	private List<ProdutoEntity> produto;
	
	@OneToMany(mappedBy = "atletica")
	private List<ProdutoEntity> produtos;
	

	public Integer getDonoId() {
		return donoId;
	}

	public void setDonoId(Integer donoId) {
		this.donoId = donoId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUniversidade() {
		return universidade;
	}

	public void setUniversidade(String universidade) {
		this.universidade = universidade;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<UsuarioEntity> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<UsuarioEntity> usuario) {
		this.usuario = usuario;
	}

	public List<ProdutoEntity> getProduto() {
		return produto;
	}

	public void setProduto(List<ProdutoEntity> produto) {
		this.produto = produto;
	}
	
	

}
