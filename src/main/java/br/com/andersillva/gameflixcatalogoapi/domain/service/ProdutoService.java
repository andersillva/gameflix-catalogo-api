package br.com.andersillva.gameflixcatalogoapi.domain.service;

import java.util.List;

import br.com.andersillva.gameflixcatalogoapi.domain.document.Produto;

public interface ProdutoService {

	public Produto obterPorId(Long id);

	public List<Produto> obterPorIds(List<Long> id);

	public List<Produto> pesquisar(String termo);
	
	public void cadastrar(Produto produto);

}
