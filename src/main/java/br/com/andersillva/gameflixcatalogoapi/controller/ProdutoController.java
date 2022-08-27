package br.com.andersillva.gameflixcatalogoapi.controller;

import java.util.List;

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
import br.com.andersillva.gameflixcatalogoapi.controller.form.ProdutoForm;
import br.com.andersillva.gameflixcatalogoapi.controller.util.VersaoAPI;
import br.com.andersillva.gameflixcatalogoapi.domain.document.Produto;
import br.com.andersillva.gameflixcatalogoapi.domain.service.ProdutoService;

@RestController
@RequestMapping(path=VersaoAPI.URI_BASE_V1, produces=MediaType.APPLICATION_JSON_VALUE)
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> registrar(@Valid @RequestBody ProdutoForm produtoForm) {

		Produto produto = produtoForm.converter();
		produtoService.cadastrar(produto);
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDTO> obterProduto(@PathVariable("id") Long id) {
		Produto produto = produtoService.obterPorId(id);
		var produtoDTO = new ProdutoDTO(produto);
		return new ResponseEntity<>(produtoDTO, HttpStatus.OK);
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

}
