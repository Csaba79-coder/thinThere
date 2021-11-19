package backend.thinthere.service;

import backend.thinthere.config.JwtUtil;
import backend.thinthere.model.dto.LoginRequestDTO;
import backend.thinthere.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final MyUserDetailsService myUserDetailsService;
    private final JwtUtil jwtUtil;

    public String authenticateExistingUser(LoginRequestDTO loginRequestDTO){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getEmail(), loginRequestDTO.getPassword()));
        UserDetails userDetails = myUserDetailsService.loadUserByUsername(loginRequestDTO.getEmail());
        return jwtUtil.generateToken(userDetails);
    }

}
