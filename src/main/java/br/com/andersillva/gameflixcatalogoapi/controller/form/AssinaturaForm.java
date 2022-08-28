package br.com.andersillva.gameflixcatalogoapi.controller.form;

import java.math.BigDecimal;
import org.modelmapper.ModelMapper;

import br.com.andersillva.gameflixcatalogoapi.domain.document.Assinatura;
import lombok.Data;

@Data
public class AssinaturaForm {

	private static ModelMapper mapper = new ModelMapper();

	private String nome;
	
	private String descricao;
	
	private String duracao;

	private BigDecimal preco;
	
	public Assinatura converter() {
		return mapper.map(this, Assinatura.class);
	}

}
