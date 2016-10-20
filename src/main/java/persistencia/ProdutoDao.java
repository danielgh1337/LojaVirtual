package persistencia;

import java.io.Serializable;
import java.util.List;

import org.hibernate.*;

import beans.Produto;

public class ProdutoDao implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void insert(Produto produto) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.save(produto);
		t.commit();
		sessao.close();
	}
	
	public static void update(Produto produto) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.update(produto);
		t.commit();
		sessao.close();
	}
	
	public static void delete(Produto produto) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(produto);
		t.commit();
		sessao.close();
	}
	
//	public static List<Produto> listagem(String filtro) {
//		Session sessao = HibernateUtil.getSessionFactory().openSession();
//		Query consulta;
//		if( filtro.trim().length() == 0 ) {
//			consulta = sessao.createQuery("FROM Produto ORDER BY pro_nome");
//		} else {
//			consulta = sessao.createQuery("FROM Produto WHERE pro_nome LIKE :x ORDER BY pro_nome");
//			consulta.setString("x", "%" + filtro + "%");
//		}
//		List lista = consulta.list();
//		sessao.close();
// 		return lista;
//	}
	
	public static List<Produto> list() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta;
		consulta = sessao.createQuery("FROM Produto ORDER BY pro_nome");
		List lista = consulta.list();
		sessao.close();
		return lista;
	}
	
	public static Produto pesqId(int valor) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta = sessao.createQuery("FROM Produto WHERE pro_id = :x");
		consulta.setInteger("x", valor);
		sessao.close();
		return (Produto) consulta.uniqueResult();
	}
}
