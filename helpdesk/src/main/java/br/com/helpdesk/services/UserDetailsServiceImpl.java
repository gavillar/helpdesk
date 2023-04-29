package br.com.helpdesk.services;

import br.com.helpdesk.domain.Pessoa;
import br.com.helpdesk.repositories.PessoaRepository;
import br.com.helpdesk.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;


// Essa classe é responsável por coletar os details do usuário.

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Pessoa> user = pessoaRepository.findByEmail(email);
        if(user.isPresent()) {
            return new UserSS(
                    user.get().getId(),
                    user.get().getEmail(),
                    user.get().getPassword(),
                    user.get().getPerfis());
        }
        throw new UsernameNotFoundException(email);
    }
}
