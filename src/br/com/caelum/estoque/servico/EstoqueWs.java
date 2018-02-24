package br.com.caelum.estoque.servico;

import java.util.List;

import javax.jws.WebService;

import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;

@WebService
public class EstoqueWs {

	private ItemDao itemDao = new ItemDao();

	public List<Item> getItens() {
		return itemDao.todosItens();
	}

}
