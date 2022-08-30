package br.com.andersillva.gameflixcatalogoapi.controller.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.andersillva.gameflixcatalogoapi.domain.document.Produto;
import br.com.andersillva.gameflixcatalogoapi.domain.document.domaintype.TipoProduto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO {

	private static ModelMapper mapper = new ModelMapper();

	private Long id;

	private String nome;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String genero;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String fabricante;

	private String descricao;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Long anoLancamento;

	private BigDecimal preco;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<String> tags = new ArrayList<>();

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Long duracao;

	private TipoProduto tipo;

	public ProdutoDTO(Produto produto) {
		mapper.map(produto, this);
	}

	public static List<ProdutoDTO> converter(List<Produto> produtos) {
		return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
	}

}
