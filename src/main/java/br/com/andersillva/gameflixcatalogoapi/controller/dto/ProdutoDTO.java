package br.com.andersillva.gameflixcatalogoapi.controller.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import br.com.andersillva.gameflixcatalogoapi.domain.document.Produto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO {

	private static ModelMapper mapper = new ModelMapper();

	private Long id;
	
	private String nome;
	
	private String genero;

	private String fabricante;

	private String descricao;
	
	private Long anoLancamento;

	private BigDecimal preco;
	
	private List<String> tags;

	public ProdutoDTO(Produto produto) {
		mapper.map(produto, this);
	}

	public static List<ProdutoDTO> converter(List<Produto> produtos) {
		return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
	}

}
