package br.com.andersillva.gameflixcatalogoapi.domain.document;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "Produto")
@Getter
@Setter
public class Produto {

	@Id
	private Long id;
	
	@TextIndexed(weight = 5)
	private String nome;
	
	@TextIndexed(weight = 3)
	private String genero;

	@TextIndexed(weight = 2)
	private String fabricante;

	@TextIndexed(weight = 4)
	private String descricao;
	
	@TextIndexed(weight = 1)
	private Long anoLancamento;

	@TextIndexed(weight = 1)
	private BigDecimal preco;
	
	@TextIndexed(weight = 5)
	private List<String> tags;

}
