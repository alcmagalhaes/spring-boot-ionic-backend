package com.teste.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.teste.cursomc.domain.Cliente;
import com.teste.cursomc.repositories.ClienteRepository;
import com.teste.cursomc.security.UserSS;

/**
 * @author amagalhaes
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private ClienteRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Cliente cli = repository.findByEmail(email);
		
		if (cli == null) {
			throw new UsernameNotFoundException(email);
		}
		
		return new UserSS(cli.getId(), cli.getEmail(), cli.getSenha(), cli.getPerfis());
	}

}
