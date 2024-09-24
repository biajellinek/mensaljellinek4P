package proj.integrador.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
	private String nome;
	private String descricao;
	private String lote;
	private double preco;
	private LocalDateTime dataEvento;//novo
	private String whatsappLink;
	private String imagem;
	
	
	
	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	@ManyToMany
	@JoinTable(
			name = "produto_atletica",
			joinColumns = @JoinColumn(name = "produto"),
			inverseJoinColumns = @JoinColumn(name = "atletica")
			)
	private List<AtleticaEntity> atletica;//Set N aceita valores repetidos e List SIM
	
	@ManyToMany
	@JoinTable(
			name = "produto_usuario",
			joinColumns = @JoinColumn(name = "produto"),
			inverseJoinColumns = @JoinColumn(name = "usuario")
			)
	private List<UsuarioEntity> usuario;

	@ManyToOne
	@JoinColumn(name = "atletica_id")
	private ProdutoEntity produtos;

	public String getWhatsappLink() {
		return whatsappLink;
	}

	public void setWhatsappLink(String whatsappLink) {
		this.whatsappLink = whatsappLink;
	}

	public LocalDateTime getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(LocalDateTime dataEvento) {
		this.dataEvento = dataEvento;
	}

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
