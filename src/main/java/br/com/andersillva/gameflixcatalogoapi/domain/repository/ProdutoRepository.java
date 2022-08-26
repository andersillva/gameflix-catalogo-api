package br.com.andersillva.gameflixcatalogoapi.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.andersillva.gameflixcatalogoapi.domain.document.Produto;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, Long> {

}
