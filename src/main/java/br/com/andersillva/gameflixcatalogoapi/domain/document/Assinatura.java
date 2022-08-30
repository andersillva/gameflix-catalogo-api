package br.com.andersillva.gameflixcatalogoapi.domain.document;

import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.andersillva.gameflixcatalogoapi.domain.document.domaintype.TipoProduto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@Document(collection = "produto")
public class Assinatura extends Produto {

	@TextIndexed(weight = 1)
	private Long duracao;

	public Assinatura() {
		super();
		super.setTipo(TipoProduto.ASSINATURA);
	}

}
