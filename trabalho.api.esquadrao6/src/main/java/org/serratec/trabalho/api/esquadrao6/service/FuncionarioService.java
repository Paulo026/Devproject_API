package org.serratec.trabalho.api.esquadrao6.service;

import org.serratec.trabalho.api.esquadrao6.dto.FuncionarioDTO;
import org.serratec.trabalho.api.esquadrao6.model.Funcionario;
import org.serratec.trabalho.api.esquadrao6.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	
	public String salvar(FuncionarioDTO funcionarioDTO) {
		Funcionario funcionario = new Funcionario();
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
}
