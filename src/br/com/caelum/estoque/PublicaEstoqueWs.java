package br.com.caelum.estoque;

import javax.xml.ws.Endpoint;

import br.com.caelum.estoque.servico.EstoqueWs;

public class PublicaEstoqueWs {
	
	public static void main(String[] args) {
		
		EstoqueWs estoqueWs = new EstoqueWs();
		
		String Url = "http://localhost:8080/estoquews";
		
		System.out.println("Rodando");
		
		Endpoint.publish(Url, estoqueWs);
		
	}
	
}
