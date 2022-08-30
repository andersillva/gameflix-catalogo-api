package br.com.andersillva.gameflixcatalogoapi.domain.document;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.andersillva.gameflixcatalogoapi.domain.document.domaintype.TipoProduto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "produto")
public abstract class Produto {

    @Transient
    public static final String SEQUENCE_NAME = "produto_sequence";

	@Id
	private Long id;

	@TextIndexed(weight = 5)
	private String nome;

	@TextIndexed(weight = 4)
	private String descricao;

	@TextIndexed(weight = 1)
	private BigDecimal preco;

	@TextIndexed(weight = 5)
	private List<String> tags = new ArrayList<>();

	private TipoProduto tipo;

}
