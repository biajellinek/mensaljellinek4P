package proj.integrador.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RankingEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private Integer atletica_id;
	private int pontuacao_total;
	
	@ManyToOne
	@JoinColumn (name = "atletica_id", nullable = false, insertable = false, updatable = false)
	private AtleticaEntity atleticaEntity;
	
		
	@Column(name = "pontuacao_total", nullable = false,insertable = false, updatable = false)
	private int pontuacaoTotal;
	
	
	public int getPontuacaoTotal() {
		return pontuacao_total;
	}

	public void setPontuacaoTotal(int pontuacao_total) {
		this.pontuacao_total = pontuacao_total;
	}

	
}
