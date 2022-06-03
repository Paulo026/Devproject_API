package org.serratec.trabalho.api.esquadrao6.service;

import java.util.List;
import java.util.stream.Collectors;

import org.serratec.trabalho.api.esquadrao6.dto.UsuarioDTO;
import org.serratec.trabalho.api.esquadrao6.model.Usuario;
import org.serratec.trabalho.api.esquadrao6.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioService {

	
	@Autowired
	private UsuarioRepository uRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public UsuarioDTO mapToDTO(Usuario usuario, UsuarioDTO usuarioDTO) {
		usuarioDTO.setIdUsuario(usuario.getIdUsuario());
		usuarioDTO.setUsername(usuario.getUsername());
		usuarioDTO.setPassword(usuario.getPassword());
		return usuarioDTO;
	}
	
	public Usuario mapToModel(Usuario usuario, UsuarioDTO usuarioDTO) {
		usuario.setUsername(usuarioDTO.getUsername());
		usuario.setPassword(encoder.encode(usuarioDTO.getPassword()));
		return usuario;
	}
	
	public UsuarioDTO buscar(Integer idUsuario) {
		return uRepository.findById(idUsuario)
				.map(usuario -> mapToDTO(usuario, new UsuarioDTO()))
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public UsuarioDTO buscarPorId(Integer idUsuario) {
		return uRepository.findById(idUsuario)
				.map(usuario -> mapToDTO(usuario, new UsuarioDTO()))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public List<UsuarioDTO> buscarTodos(){
		return uRepository.findAll()
				.stream()
				.map(usuario -> mapToDTO(usuario, new UsuarioDTO()))
				.collect(Collectors.toList());
						
	}
	
	public Integer salvar(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
		mapToModel(usuario, usuarioDTO);
		uRepository.save(usuario);
		return usuario.getIdUsuario();
		
	}
	
	public UsuarioDTO buscarPorLogin(String login) {
		return uRepository.findAll()
		.stream()
		.filter(usuario -> usuario.getUsername().equals(login))
		.map(usuario -> mapToDTO(usuario, new UsuarioDTO()))
		.findFirst()
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
}
