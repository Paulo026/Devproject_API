package org.serratec.trabalho.api.esquadrao6.service;

import org.serratec.trabalho.api.esquadrao6.dto.ProdutoCategoriaDTO;
import org.serratec.trabalho.api.esquadrao6.exception.ProdutoCategoriaException;
import org.serratec.trabalho.api.esquadrao6.model.ProdutoCategoria;
import org.serratec.trabalho.api.esquadrao6.repository.ProdutoCategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoCategoriaService {

    @Autowired
    ProdutoCategoriaRepository produtoCategoriaRepository;

    public ProdutoCategoriaDTO transformarModelEmDTO(ProdutoCategoria produtoCategoria, ProdutoCategoriaDTO produtoCategoriaDTO){
        produtoCategoriaDTO.setCategoriaId(produtoCategoria.getCategoriaId());
        produtoCategoriaDTO.setCategoriaNome(produtoCategoria.getCategoriaNome());
        produtoCategoriaDTO.setCategoriaDescricao(produtoCategoria.getCategoriaDescricao());

        return produtoCategoriaDTO;
    }
    public ProdutoCategoria transformarDTOEmMOdel(ProdutoCategoria produtoCategoria, ProdutoCategoriaDTO produtoCategoriaDTO){
        produtoCategoria.setCategoriaNome(produtoCategoriaDTO.getCategoriaNome());
        produtoCategoria.setCategoriaDescricao(produtoCategoriaDTO.getCategoriaDescricao());

        return produtoCategoria;
    }

    public String salvar(ProdutoCategoriaDTO produtoCategoriaDTO){
        ProdutoCategoria produtoCategoria = new ProdutoCategoria();
        transformarModelEmDTO(produtoCategoria, produtoCategoriaDTO);
        produtoCategoriaRepository.save(produtoCategoria);
        return "A categoria foi criada com suceso, seu códgo é: " +produtoCategoria.getCategoriaId();
    }

    public ProdutoCategoriaDTO buscarPorId(Integer categoriaId) throws ProdutoCategoriaException{
        Optional<ProdutoCategoria> produtoCategoria = produtoCategoriaRepository.findById(categoriaId);
        ProdutoCategoria produtoCategoriaNaLoja = new ProdutoCategoria();
        ProdutoCategoriaDTO produtoCategoriaDTO = new ProdutoCategoriaDTO();
        if(produtoCategoria.isPresent()){
            produtoCategoriaNaLoja = produtoCategoria.get();
            transformarModelEmDTO(produtoCategoriaNaLoja, produtoCategoriaDTO);
            return produtoCategoriaDTO;
        }
        throw new ProdutoCategoriaException("Categoria com código informado não foi encontrada.");
    }

    public void deletar(Integer categoriaId){
        produtoCategoriaRepository.deleteById(categoriaId);
    }

//    public String atualizar(Integer categoriaId, ProdutoCategoriaDTO produtoCategoriaDTO) throws ProdutoCategoriaException{
//        Optional<ProdutoCategoria> produtoCategoria = produtoCategoriaRepository.findById(categoriaId);
//
//    }

}
