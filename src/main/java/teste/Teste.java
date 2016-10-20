package teste;

import beans.Pessoa;
import persistencia.HibernateUtil;
import persistencia.PessoaDao;

public class Teste {

	public static void main(String[] args) {
		
		HibernateUtil.getSessionFactory().openSession();
		Pessoa p = new Pessoa();
		p.setNome("Daniel");
		p.setCpf("111-111-111-11");
		p.setRg("5441069");
		p.setDataNascimento(null);
		p.setRua("Rua x");
		p.setBairro("Bairro Y");
		p.setCidade("Goiânia");
		p.setEstado("GO");
		p.setCep(74910150);
		p.setEmail("danielgyn1337@gmail.com");
		p.setSenha("a1b2c3z4X5.");
		p.setId(2);
		PessoaDao.update(p);
	}
}
