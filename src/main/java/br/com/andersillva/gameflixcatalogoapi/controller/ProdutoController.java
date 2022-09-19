package br.com.andersillva.gameflixcatalogoapi.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.andersillva.gameflixcatalogoapi.controller.dto.ProdutoDTO;
import br.com.andersillva.gameflixcatalogoapi.controller.form.AssinaturaForm;
import br.com.andersillva.gameflixcatalogoapi.controller.form.JogoForm;
import br.com.andersillva.gameflixcatalogoapi.controller.util.VersaoAPI;
import br.com.andersillva.gameflixcatalogoapi.domain.document.Assinatura;
import br.com.andersillva.gameflixcatalogoapi.domain.document.Jogo;
import br.com.andersillva.gameflixcatalogoapi.domain.document.Produto;
import br.com.andersillva.gameflixcatalogoapi.domain.service.ProdutoService;

@RestController
@RequestMapping(path=VersaoAPI.URI_BASE_V1, produces=MediaType.APPLICATION_JSON_VALUE)
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDTO> obterProduto(@PathVariable("id") Long id) {
		Produto produto = produtoService.obterPorId(id);
		ProdutoDTO produtoDTO = new ProdutoDTO(produto);
		return new ResponseEntity<>(produtoDTO, HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<List<ProdutoDTO>> obterProdutos(@RequestParam("ids") String ids) {
		List<Long> parametros = Stream.of(ids.split(","))
				.map(Long::parseLong)
		        .collect(Collectors.toList());
		List<Produto> produtos = produtoService.obterPorIds(parametros);
		if (!produtos.isEmpty()) {
			return new ResponseEntity<>(ProdutoDTO.converter(produtos), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/pesquisa")
	public ResponseEntity<List<ProdutoDTO>> pesquisar(@RequestParam("termo") String termo) {
		List<Produto> produtos = produtoService.pesquisar(termo);
		if (!produtos.isEmpty()) {
			return new ResponseEntity<>(ProdutoDTO.converter(produtos), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping(path="/jogo", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> registrarJogo(@Valid @RequestBody JogoForm produtoForm) {

		Jogo produto = produtoForm.converter();
		produtoService.cadastrar(produto);
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}

	@PostMapping(path="/assinatura", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> registrarAssinatura(@Valid @RequestBody AssinaturaForm assinaturaForm) {

		Assinatura assinatura = assinaturaForm.converter();
		produtoService.cadastrar(assinatura);
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}

}
