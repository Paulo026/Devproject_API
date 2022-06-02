package org.serratec.trabalho.api.esquadrao6.service;

import org.serratec.trabalho.api.esquadrao6.dto.ProdutoCategoriaDTO;
import org.serratec.trabalho.api.esquadrao6.exception.ProdutoCategoriaException;
import org.serratec.trabalho.api.esquadrao6.model.ProdutoCategoria;
import org.serratec.trabalho.api.esquadrao6.repository.ProdutoCategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public String atualizar(Integer categoriaId, ProdutoCategoriaDTO produtoCategoriaDTO) throws ProdutoCategoriaException{
        Optional<ProdutoCategoria> produtoCategoria = produtoCategoriaRepository.findById(categoriaId);
        ProdutoCategoria produtoCategoriaLoja = new ProdutoCategoria();
        if(produtoCategoria.isPresent()){
            produtoCategoriaLoja = produtoCategoria.get();
            if(produtoCategoriaDTO.getCategoriaNome() != null){
                produtoCategoriaLoja.setCategoriaNome(produtoCategoriaDTO.getCategoriaNome());
            }
            if(produtoCategoriaDTO.getCategoriaDescricao() != null){
                produtoCategoriaLoja.setCategoriaDescricao(produtoCategoriaDTO.getCategoriaDescricao());
            }
            produtoCategoriaRepository.save(produtoCategoriaLoja);
            return "A categoria com o código "+produtoCategoriaLoja.getCategoriaId()+"foi atualizado";
        }
            throw new ProdutoCategoriaException("A categoria não foi atualizada, verifique od dados digitados.");

    }

    public List<ProdutoCategoriaDTO> buscarTodos(){
        List<ProdutoCategoria> listaProdutoCategoriaModel = produtoCategoriaRepository.findAll();
        List<ProdutoCategoriaDTO> listaProdutoCategoriaDTO = new ArrayList<>();
        for(ProdutoCategoria produtoCategoria : listaProdutoCategoriaModel){
            ProdutoCategoriaDTO produtoCategoriaDTO = new ProdutoCategoriaDTO();
            transformarModelEmDTO(produtoCategoria, produtoCategoriaDTO);
            listaProdutoCategoriaDTO.add(produtoCategoriaDTO);
        }
        return listaProdutoCategoriaDTO;
    }

    public void salvarListaCategoria(List<ProdutoCategoriaDTO> listaProdutoCategoriaDTO){
        List<ProdutoCategoria> listaProdutoCategoria = new ArrayList<>();
        for(ProdutoCategoriaDTO produtoCategoriaDTO : listaProdutoCategoriaDTO){
            ProdutoCategoria produtoCategoria = new ProdutoCategoria();
            transformarDTOEmMOdel(produtoCategoria, produtoCategoriaDTO);
            listaProdutoCategoria.add(produtoCategoria);
        }
        produtoCategoriaRepository.saveAll(listaProdutoCategoria);
    }

}
