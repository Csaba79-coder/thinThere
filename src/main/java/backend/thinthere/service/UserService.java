package backend.thinthere.service;

import backend.thinthere.config.JwtUtil;
import backend.thinthere.enums.Role;
import backend.thinthere.model.User;
import backend.thinthere.model.dto.LoginRequestDTO;
import backend.thinthere.model.dto.UserRequestDTO;
import backend.thinthere.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    @PersistenceContext
    private EntityManager em;

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final MyUserDetailsService myUserDetailsService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(EntityManager em,
                       UserRepository userRepository,
                       AuthenticationManager authenticationManager,
                       MyUserDetailsService myUserDetailsService,
                       JwtUtil jwtUtil,
                       PasswordEncoder passwordEncoder) {
        this.em = em;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.myUserDetailsService = myUserDetailsService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

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
            user.setEnabled(true);
            user.setLocked(false);
            user.setRole(Role.ROLE_ADMIN);
            userRepository.save(user);
        }

    }

    public Optional<User> getUserByUsername(String username) {
       return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return em.createQuery("SELECT user FROM User user WHERE user.username = :name", User.class)
                .setParameter("name", username)
                .getSingleResult();
    }

    public User getLoggedInUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            Object principal = auth.getPrincipal();
            if (principal instanceof User) {
                return (User) principal;
            }
        }
        return null;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findByID(id);
    }

    /**
     * update, delete
     */

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
