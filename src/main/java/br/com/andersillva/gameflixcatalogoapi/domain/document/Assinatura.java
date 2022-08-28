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
public class Assinatura extends Produto {

	@TextIndexed(weight = 1)
	private Long duracao;

}
