package beans;

import javax.persistence.*;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_pro_id_seq")
	@SequenceGenerator(name = "produto_pro_id_seq", sequenceName = "produto_pro_id_seq", allocationSize = 1)
	@Column(name = "pro_id")
	private Integer id;
	
	@Column(name = "pro_nome", length = 60, nullable = false)
	private String nome;

	@Column(name = "pro_preco", nullable = false)
	private Float preco;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
