package negocio;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import persistencia.ProdutoDao;
import beans.Produto;

@ManagedBean(name = "beanProduto")
@SessionScoped
public class ProdutoController implements Serializable {

	private static final long serialVersionUID = 1L;
	private Produto produto = new Produto();

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String actionUpdate(Produto p) {
		produto = p;
		return "form_produto";
	}

	public String actionSalvar() {
		if (produto.getId() == null || produto.getId() == 0) {
			ProdutoDao.insert(produto);
			produto = new Produto();
			return "form_produto";
		} else {
			ProdutoDao.update(produto);
			return "lista_produtos";
		}
	}

	public String actionDelete(Produto p) {
		produto = p;
		ProdutoDao.delete(p);
		return "lista_produtos";
	}

	public List<Produto> getList() {
		return ProdutoDao.list();
	}
}
