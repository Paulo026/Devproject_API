package org.serratec.trabalho.api.esquadrao6.service;

import org.serratec.trabalho.api.esquadrao6.dto.ClienteDTO;
import org.serratec.trabalho.api.esquadrao6.exception.ClienteException;
import org.serratec.trabalho.api.esquadrao6.model.Cliente;
import org.serratec.trabalho.api.esquadrao6.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	// código = id
	// verificar se há erro
	public String salvar(ClienteDTO clienteDTO) throws ClienteException {
		Cliente cliente = new Cliente();
		transformarDTOEmModel(clienteDTO, cliente);
		clienteRepository.save(cliente);
		return "O cliente foi cadastrado com sucesso, seu código é: " + cliente.getClienteId();
	}

	public ClienteDTO buscarporId(Integer clienteId) throws ClienteException {
		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
		Cliente clienteNaLoja = new Cliente();
		ClienteDTO clienteDTO = new ClienteDTO();
		if (cliente.isPresent()) {
			clienteNaLoja = cliente.get();
			transformarModelEmDTO(clienteNaLoja, clienteDTO);
			return clienteDTO;
		}
		throw new ClienteException("O cliente com o código informado não foi encontrado");
	}

	public void deletar(Integer idCliente) {
		clienteRepository.deleteById(idCliente);
	}

	public String atualizar(Integer clienteId, ClienteDTO clienteDTO) throws ClienteException {
		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
		Cliente clienteLoja = new Cliente();
		if (cliente.isPresent()) {
			clienteLoja = cliente.get();
			if (clienteDTO.getClienteNome() != null) {
				clienteLoja.setClienteNome(clienteDTO.getClienteNome());
			}

			if (clienteDTO.getClienteUsuario() != null) {
				clienteLoja.setClienteUsuario(clienteDTO.getClienteUsuario());
			}

			if (clienteDTO.getClienteSenha() != null) {
				clienteLoja.setClienteSenha(clienteDTO.getClienteSenha());
			}

			if (clienteDTO.getClienteEmail() != null) {
				clienteLoja.setClienteEmail(clienteDTO.getClienteEmail());
			}

			if (clienteDTO.getClienteCpf() != null) {
				clienteLoja.setClienteCpf(clienteDTO.getClienteCpf());
			}

			if (clienteDTO.getClienteDataNascimento() != null) {
				clienteLoja.setClienteDataNascimento(clienteDTO.getClienteDataNascimento());
			}

			if (clienteDTO.getClienteTelefone() != null) {
				clienteLoja.setClienteTelefone(clienteDTO.getClienteTelefone());
			}

			if (clienteDTO.getClienteEnderecoCompleto() != null) {
				clienteLoja.setClienteEnderecoCompleto(clienteDTO.getClienteEnderecoCompleto());
			}

			if (clienteDTO.getClienteCep() != null) {
				clienteLoja.setClienteCep(clienteDTO.getClienteCep());
			}
			clienteRepository.save(clienteLoja);
			return "O cliente com código: " + clienteLoja.getClienteId() + "foi atualizado";
		}
		throw new ClienteException("O cliente não fora atualizado!");
	}

	// Conversores
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

		return clienteDTO;
	}

	public Cliente transformarDTOEmModel(ClienteDTO clienteDTO, Cliente cliente) throws ClienteException {
		if (clienteDTO.getClienteNome() == null) {
			throw new ClienteException("O nome do cliente não foi informado");
		}
		if (clienteDTO.getClienteCpf() == null) {
			throw new ClienteException("O cpf do cliente não foi informado");
		}
		if (clienteDTO.getClienteUsuario() == null) {
			throw new ClienteException("O usuário do cliente não foi informado");
		}
		if (clienteDTO.getClienteSenha() == null) {
			throw new ClienteException("A senha do cliente não foi informada");
		}
		if (clienteDTO.getClienteEmail() == null) {
			throw new ClienteException("O e-mail do cliente não foi informado");
		}
		if (clienteDTO.getClienteEnderecoCompleto() == null) {
			throw new ClienteException("O endereço do cliente não foi informado");
		}
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

	public List<ClienteDTO> buscarTodos() {
		List<Cliente> listaClienteModel = clienteRepository.findAll();
		List<ClienteDTO> listaClienteDTO = new ArrayList<>();

		for (Cliente cliente : listaClienteModel) {
			ClienteDTO clienteDTO = new ClienteDTO();
			transformarModelEmDTO(cliente, clienteDTO);
			listaClienteDTO.add(clienteDTO);
		}

		return listaClienteDTO;

	}

	public void salvarListaCLiente(List<ClienteDTO> listaClienteDTO) throws ClienteException {

		List<Cliente> listaCliente = new ArrayList<>();
		for (ClienteDTO clienteDTO : listaClienteDTO) {
			Cliente cliente = new Cliente();
			transformarDTOEmModel(clienteDTO, cliente);
			listaCliente.add(cliente);
		}
		clienteRepository.saveAll(listaCliente);
	}
}
