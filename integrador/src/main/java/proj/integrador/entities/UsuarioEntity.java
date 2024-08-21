package proj.integrador.entities;

import java.util.List;

import org.hibernate.annotations.processing.Pattern;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;import lombok.experimental.PackagePrivate;


@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity(name = "usuario")
public class UsuarioEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nome;
	
	@Column (nullable = true)
	
	private String email;
	private String cep;
	
	
	@ManyToMany//muitas atleticas para muitos usuarios
	@JoinTable(
			name = "usuario_atletica",
			joinColumns = @JoinColumn(name = "usuario"),
			inverseJoinColumns = @JoinColumn (name = "atletica")
			)
	private List<AtleticaEntity> atletica;
	
	@ManyToMany
	@JoinTable(//muitas atleticas para muitos produtos
			name = "usuario_produto",
			joinColumns = @JoinColumn(name = "usuario"),
			inverseJoinColumns = @JoinColumn(name = "produto")
			)
	
	private List<ProdutoEntity> produto;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public List<AtleticaEntity> getAtletica() {
		return atletica;
	}

	public void setAtletica(List<AtleticaEntity> atletica) {
		this.atletica = atletica;
	}

	public List<ProdutoEntity> getProduto() {
		return produto;
	}

	public void setProduto(List<ProdutoEntity> produto) {
		this.produto = produto;
	}
	
	

}
