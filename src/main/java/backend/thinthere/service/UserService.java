package backend.thinthere.service;

import backend.thinthere.config.JwtUtil;
import backend.thinthere.model.User;
import backend.thinthere.model.dto.LoginRequestDTO;
import backend.thinthere.model.dto.UserRequestDTO;
import backend.thinthere.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final MyUserDetailsService myUserDetailsService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public String authenticateExistingUser(LoginRequestDTO loginRequestDTO){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword()));
        UserDetails userDetails = myUserDetailsService.loadUserByUsername(loginRequestDTO.getUsername());
        return jwtUtil.generateToken(userDetails);
    }

    public void register(UserRequestDTO userRequestDTO) throws Exception{

        if(userRepository.findByUsername(userRequestDTO.getUsername()).isPresent()){
            throw new Exception();
        }else{
            ModelMapper modelMapper = new ModelMapper();
            User user = new User();
            modelMapper.map(userRequestDTO, user);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        }

    }

}
