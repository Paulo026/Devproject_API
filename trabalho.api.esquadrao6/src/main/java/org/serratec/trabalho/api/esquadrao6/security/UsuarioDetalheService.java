package org.serratec.trabalho.api.esquadrao6.security;


import java.util.ArrayList;
import java.util.Optional;

import org.serratec.trabalho.api.esquadrao6.model.Usuario;
import org.serratec.trabalho.api.esquadrao6.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetalheService implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Optional<Usuario> usuario = usuarioRepository.buscarPorLogin(username); 
		
		if(usuario.isPresent()) {
			Usuario u = usuario.get();
			return new User(u.getUsername(), u.getPassword(), new ArrayList<>());
		}
		throw new UsernameNotFoundException("Usuario incorreto");
	}

}
