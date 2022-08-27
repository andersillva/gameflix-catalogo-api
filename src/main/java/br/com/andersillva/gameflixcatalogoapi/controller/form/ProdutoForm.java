package br.com.andersillva.gameflixcatalogoapi.controller.form;

import java.math.BigDecimal;
import java.util.List;

import org.modelmapper.ModelMapper;

import br.com.andersillva.gameflixcatalogoapi.domain.document.Produto;
import lombok.Data;

@Data
public class ProdutoForm {

	private static ModelMapper mapper = new ModelMapper();

	private String nome;
	
	private String genero;

	private String fabricante;

	private String descricao;
	
	private Long anoLancamento;

	private BigDecimal preco;
	
	private List<String> tags;

	public Produto converter() {
		return mapper.map(this, Produto.class);
	}

}
