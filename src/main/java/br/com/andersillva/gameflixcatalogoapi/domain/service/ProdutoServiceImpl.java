package br.com.andersillva.gameflixcatalogoapi.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.andersillva.gameflixcatalogoapi.domain.document.Produto;
import br.com.andersillva.gameflixcatalogoapi.domain.repository.ProdutoRepository;
import br.com.andersillva.gameflixcatalogoapi.domain.service.exception.RegistroNaoEncontradoException;

public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private MongoTemplate mongoTemplate;
    
    @Autowired
    private ProdutoRepository produtoRepository;

	@Override
	public Produto obterPorId(Long id) {
		return produtoRepository.findById(id)
				.orElseThrow(() -> new RegistroNaoEncontradoException("Produto não encontrado."));
	}

	@Override
	public List<Produto> pesquisar(String termo) {
        TextCriteria criteria = TextCriteria
                .forDefaultLanguage()
                .matchingPhrase(termo);

		Query query = TextQuery.queryText(criteria).sortByScore();

		return mongoTemplate.find(query, Produto.class);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void cadastrar(Produto produto) {
		produto.setId(null);
		produtoRepository.save(produto);
	}

}
