package com.teste.cursomc.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.teste.cursomc.domain.Categoria;
import com.teste.cursomc.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

	/*
	 * Os metodos search e findDistinctByNomeContainingAndCategoriasIn produzem o mesmo efeteito, gracas ao
	 * suporte de keywords em nomes de classes do JPA.
	 * 
	 *  Fonte: https://docs.spring.io/spring-data/jpa/docs/2.1.4.RELEASE/reference/html/#jpa.query-methods
	 */
	//@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
	//Page<Produto> search(@Param("nome") String nome, @Param("categorias") List<Categoria> categorias, Pageable pageRequest); 
	@Transactional(readOnly=true)	
	Page<Produto> findDistinctByNomeContainingAndCategoriasIn(String nome, List<Categoria> categorias, Pageable pageRequest);
	
}
