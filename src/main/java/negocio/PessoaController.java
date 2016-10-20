package negocio;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import beans.Pessoa;
import beans.Telefone;
import persistencia.PessoaDao;

@ManagedBean(name = "beanPessoa")
public class PessoaController implements Serializable {

	private static final long serialVersionUID = 1L;
	private Pessoa pessoa;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String actionUpdate(Pessoa p) {
		pessoa = p;
		return "form_cliente";
	}

	public String actionSalvar() {
		Pessoa pessoa = new Pessoa();
		if(pessoa.getId() == null || pessoa.getId() == 0) {
			PessoaDao.insert(pessoa);
			pessoa = new Pessoa();
			return "form_cliente";
		} else {
			PessoaDao.update(pessoa);
			return "lista_clientes";
		}
	}

	public String actionDelete(Pessoa p) {
		pessoa = p;
		PessoaDao.delete(p);
		return "lista_clientes";
	}

	public List<Pessoa> getList() {
		return PessoaDao.list();
	}
	
	// Parte telefone
	public String actionInserirTelefone() {
		Telefone tel = new Telefone();
		tel.setPessoa(pessoa);
		pessoa.getTelefone().add(tel);
		return "form_cliente";
	}
	
	public String actionDeletarTelefone() {
		return "form_cliente";
	}
}
