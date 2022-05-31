package org.serratec.trabalho.api.esquadrao6.service;

import java.util.Optional;

import org.serratec.trabalho.api.esquadrao6.dto.ClienteDTO;
import org.serratec.trabalho.api.esquadrao6.exception.ClienteException;
import org.serratec.trabalho.api.esquadrao6.model.Cliente;
import org.serratec.trabalho.api.esquadrao6.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;


	
	//código = id
	// verificar se há erro
	public String salvar(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
		transformarModelEmDTO(cliente, clienteDTO);
		clienteRepository.save(cliente);
		return "O cliente foi cadastrado com sucesso, seu código é: " + cliente.getClienteId();
	}
	
	public ClienteDTO buscarporId(Integer clienteId) throws ClienteException{
		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
		Cliente clienteNaLoja = new Cliente();
		ClienteDTO clienteDTO = new ClienteDTO();
		if(cliente.isPresent()) {
			clienteNaLoja = cliente.get();
			transformarModelEmDTO(clienteNaLoja, clienteDTO);
			return clienteDTO;
		}
		throw new ClienteException("O cliente com o código informado não foi encontrado");
	}
	
	public void deletar(Integer clienteId) {
		clienteRepository.deleteById(clienteId);
	}
	
	public String atualizar(Integer clienteId, ClienteDTO clienteDTO) throws ClienteException{
		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
		Cliente clienteLoja = new Cliente();
		if(cliente.isPresent()) {
			clienteLoja = cliente.get();
			if(clienteDTO.getClienteNome() != null) {
				clienteLoja.setClienteNome(clienteDTO.getClienteNome());
			}
			
			if(clienteDTO.getClienteUsuario() != null) {
				clienteLoja.setClienteUsuario(clienteDTO.getClienteUsuario());
			}
			
			if(clienteDTO.getClienteSenha() != null) {
				clienteLoja.setClienteSenha(clienteDTO.getClienteSenha());
			}
			
			if(clienteDTO.getClienteEmail() != null) {
				clienteLoja.setClienteEmail(clienteDTO.getClienteEmail());
			}
			
			if(clienteDTO.getClienteCpf() != null) {
				clienteLoja.setClienteCpf(clienteDTO.getClienteCpf());
			}
			
			if(clienteDTO.getClienteDataNascimento() != null) {
				clienteLoja.setClienteDataNascimento(clienteDTO.getClienteDataNascimento());
			}
			
			if(clienteDTO.getClienteTelefone() != null) {
				clienteLoja.setClienteTelefone(clienteDTO.getClienteTelefone());
			}
			
			if(clienteDTO.getClienteEnderecoCompleto() != null) {
				clienteLoja.setClienteEnderecoCompleto(clienteDTO.getClienteEnderecoCompleto());
			}
			
			if(clienteDTO.getClienteCep() != null) {
				clienteLoja.setClienteCep(clienteDTO.getClienteCep());
			}
			clienteRepository.save(clienteLoja);
			return "O cliente com código: "+ clienteLoja.getClienteId()+ "foi atualizado";
		}
			throw new ClienteException("O cliente não fora atualizado!");
	}

	//Conversores
	public ClienteDTO transformarModelEmDTO(Cliente cliente, ClienteDTO clienteDTO) {
		clienteDTO.setClienteId(cliente.getClienteId());
		clienteDTO.setClienteNome(cliente.getClienteNome());
		clienteDTO.setClienteUsuario(cliente.getClienteUsuario());
		clienteDTO.setClienteSenha(cliente.getClienteSenha());
		clienteDTO.setClienteEmail(cliente.getClienteEmail());
		clienteDTO.setClienteCpf(cliente.getClienteCpf());
		clienteDTO.setClienteDataNascimento(cliente.getClienteDataNascimento());
		clienteDTO.setClienteTelefone(cliente.getClienteTelefone());
		clienteDTO.setClienteEnderecoCompleto(cliente.getClienteEnderecoCompleto());
		clienteDTO.setClienteCep(cliente.getClienteCep());
		clienteDTO.setMovimentacaoID();

		return clienteDTO;
	}

	public Cliente transformarDTOEmModel(ClienteDTO clienteDTO, Cliente cliente) {
		cliente.setClienteNome(clienteDTO.getClienteNome());
		cliente.setClienteUsuario(clienteDTO.getClienteUsuario());
		cliente.setClienteSenha(clienteDTO.getClienteSenha());
		cliente.setClienteEmail(clienteDTO.getClienteEmail());
		cliente.setClienteCpf(clienteDTO.getClienteCpf());
		cliente.setClienteDataNascimento(clienteDTO.getClienteDataNascimento());
		cliente.setClienteTelefone(clienteDTO.getClienteTelefone());
		cliente.setClienteEnderecoCompleto(clienteDTO.getClienteEnderecoCompleto());
		cliente.setClienteCep(clienteDTO.getClienteCep());

		return cliente;
	}

}
