package org.serratec.trabalho.api.esquadrao6.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.trabalho.api.esquadrao6.dto.FuncionarioDTO;
import org.serratec.trabalho.api.esquadrao6.exception.FuncionarioException;
import org.serratec.trabalho.api.esquadrao6.model.Funcionario;
import org.serratec.trabalho.api.esquadrao6.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	
	public String salvar(FuncionarioDTO funcionarioDTO) {
		Funcionario funcionario = new Funcionario();
		transformarDTOEmModel(funcionario, funcionarioDTO);
		funcionarioRepository.save(funcionario);
		return "O funcionário foi cadastrado com uma ID: " + funcionario.getFuncionarioId();
	}
	
	public FuncionarioDTO buscarPorId(Integer idFuncionario) throws FuncionarioException{
		Optional<Funcionario> funcionario = funcionarioRepository.findById(idFuncionario);
		Funcionario funcionarioNoBanco = new Funcionario();
		FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
		if(funcionario.isPresent()) {
			funcionarioNoBanco = funcionario.get();
			transformarModelEmDTO(funcionarioNoBanco, funcionarioDTO);
			return funcionarioDTO;
		}
		throw new FuncionarioException("Funcionário com a id informada, não foi encontrado"); // verificar mensagem ou melhorar
	}
	
	public void deletar(Integer idFuncionario) {
		funcionarioRepository.deleteById(idFuncionario);
	}
	
	public String atualizar(Integer idFuncionario, FuncionarioDTO funcionarioDTO) throws FuncionarioException{
		Optional<Funcionario> funcionario = funcionarioRepository.findById(idFuncionario);
		Funcionario funcionarioBanco = new Funcionario();
		if(funcionario.isPresent()) {
			funcionarioBanco = funcionario.get();
			if(funcionarioDTO.getFuncionarioCpf() != null) {
				funcionarioBanco.setFuncionarioCpf(funcionarioDTO.getFuncionarioCpf());
			}
			if(funcionarioDTO.getFuncionarioNome() != null) {
				funcionarioBanco.setFuncionarioNome(funcionarioDTO.getFuncionarioNome());
			}
			funcionarioRepository.save(funcionarioBanco);
			return "O funcionario com a id " + funcionarioBanco.getFuncionarioId()+" foi atualizado";
		}
		throw new FuncionarioException("O funcionario não foi atualizado"); // verificar se o método está faltando algo
	}
	
	public List<FuncionarioDTO> buscarTodos(){
		List<Funcionario> funcionarioModel = funcionarioRepository.findAll();
		List<FuncionarioDTO> listaDTO = new ArrayList<>();
		for(Funcionario funcionario : funcionarioModel) {
			FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
			transformarModelEmDTO(funcionario, funcionarioDTO);
			listaDTO.add(funcionarioDTO);
		}
		return listaDTO;
	}
	
	public void salvarListaFuncionario(List<FuncionarioDTO> listaDTO) {
		List<Funcionario> listaFuncionario = new ArrayList<>();
		
		for(FuncionarioDTO funcionarioDTO : listaDTO) {
			Funcionario funcionario = new Funcionario();
			transformarDTOEmModel(funcionario, funcionarioDTO);
			listaFuncionario.add(funcionario);
		}
		funcionarioRepository.saveAll(listaFuncionario);
	}
	
	public FuncionarioDTO transformarModelEmDTO(Funcionario funcionario, FuncionarioDTO funcionarioDTO) {
		funcionarioDTO.setFuncionarioId(funcionario.getFuncionarioId());
		funcionarioDTO.setFuncionarioNome(funcionario.getFuncionarioNome());
		funcionarioDTO.setFuncionarioCpf(funcionario.getFuncionarioCpf());
		
		return funcionarioDTO;
	}
	
	public Funcionario transformarDTOEmModel(Funcionario funcionario, FuncionarioDTO funcionarioDTO) {
		funcionario.setFuncionarioNome(funcionarioDTO.getFuncionarioNome());
		funcionario.setFuncionarioCpf(funcionarioDTO.getFuncionarioCpf());
		return funcionario;
	}

	// verificar erro
	public String salvar(FuncionarioDTO funcionarioDTO){
		Funcionario funcionario = new Funcionario();
		transformarDTOEmModel(funcionario,funcionarioDTO);
		funcionarioRepository.save(funcionario);
		return "O funcionário foi criado com o código: "+funcionario.getFuncionarioId();
	}

	public FuncionarioDTO buscarPorid(Integer funcionarioId) throws FuncionarioException{
		Optional<Funcionario> funcionario = funcionarioRepository.findById(funcionarioId);
		Funcionario funcionarioNaLoja = new Funcionario();
		FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
		if(funcionario.isPresent()){
			funcionarioNaLoja = funcionario.get();
			transformarModelEmDTO(funcionarioNaLoja, funcionarioDTO);
			return funcionarioDTO;
		}
		throw new FuncionarioException("O funcionário com o código informado não foi encontrado. " +
				"Por favor verifique os dados digitados.")
	}

	public void deletar(Integer funcionarioId){
		funcionarioRepository.deleteById(funcionarioId);
	}

	public String atualizar(Integer funcionarioId, FuncionarioDTO funcionarioDTO) throws FuncionarioException{
		Optional<Funcionario> funcionario = funcionarioRepository.findById(funcionarioId);
		Funcionario funcionarioLoja = new Funcionario();
		if(funcionario.isPresent()){
			funcionarioLoja = funcionario.get();
			if(funcionarioDTO.getFuncionarioNome()!= null){
				funcionarioLoja.setFuncionarioNome(funcionarioDTO.getFuncionarioNome());
			}
			if(funcionarioDTO.getFuncionarioCpf()!= null){
				funcionarioLoja.setFuncionarioCpf(funcionarioDTO.getFuncionarioCpf());
			}
			funcionarioRepository.save(funcionarioLoja);
			return "O funcionário com o código: "+funcionarioLoja.getFuncionarioId()+"foi atualizado"
		}
		throw new FuncionarioException("O funcionário não foi atualizado, favor verificar dados digitado.");
	}

	public List<FuncionarioDTO> buscarTodos(){
		List<Funcionario> listaFuncionarioModel = funcionarioRepository.findAll();
		List<FuncionarioDTO> listaFuncionarioDTO = new ArrayList<>();

		for(Funcionario funcionario : listaFuncionarioModel){
			FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
			transformarModelEmDTO(funcionario, funcionarioDTO);
		}
		return listaFuncionarioDTO;
	}

	public void salvarlistaFuncionario(List<FuncionarioDTO> listaFuncionarioDTO){
		for(FuncionarioDTO funcionarioDTO : listaFuncionarioDTO){
			Funcionario funcionario = new Funcionario();
			funcionarioRepository.save(funcionario);
		}
	}

}
