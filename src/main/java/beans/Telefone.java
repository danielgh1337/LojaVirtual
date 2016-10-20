package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "fone")
public class Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fone_fon_id_seq")
	@SequenceGenerator(name = "fone_fon_id_seq", sequenceName = "fone_fon_id_seq", allocationSize = 1)
	@Column(name = "fon_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "pes_id")
	private Pessoa pessoa;

	@Column(name = "fon_numero", length = 20, nullable = true)
	private String numero;

	@Column(name = "fon_descricao", length = 30, nullable = true)
	private String descricao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
