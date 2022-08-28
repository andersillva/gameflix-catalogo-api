package br.com.andersillva.gameflixcatalogoapi.domain.document;

import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@Document(collection = "produto")
public class Jogo extends Produto {

	@TextIndexed(weight = 3)
	private String genero;

	@TextIndexed(weight = 2)
	private String fabricante;

	@TextIndexed(weight = 1)
	private Long anoLancamento;

	@TextIndexed(weight = 1)
	private Long classificacaoEtaria;

}
