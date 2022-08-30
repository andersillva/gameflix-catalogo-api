package br.com.andersillva.gameflixcatalogoapi.domain.document.domaintype;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public enum TipoProduto implements Dominio<String> {

	JOGO("JOGO"),
	ASSINATURA("ASSINATURA");

	@Getter
	private String valor;

}
