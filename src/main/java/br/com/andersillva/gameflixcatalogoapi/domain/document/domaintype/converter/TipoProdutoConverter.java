package br.com.andersillva.gameflixcatalogoapi.domain.document.domaintype.converter;

import javax.persistence.Converter;

import br.com.andersillva.gameflixcatalogoapi.domain.document.domaintype.TipoProduto;

@Converter(autoApply = true)
public class TipoProdutoConverter extends DominioAbstractConverter<TipoProduto, String> {

    public TipoProdutoConverter() {
        super(TipoProduto.class);
    }

}
