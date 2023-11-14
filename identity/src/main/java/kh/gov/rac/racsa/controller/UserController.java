package kh.gov.rac.racsa.controller;

import kh.gov.rac.racsa.config.AuthenticationToken;
import kh.gov.rac.racsa.dto.User.UserRequest;
import kh.gov.rac.racsa.model.User;
import kh.gov.rac.racsa.repository.UserRepository;
import kh.gov.rac.racsa.service.UserService;
import kh.gov.rac.racsa.utils.ResponseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/identity")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private  final UserRepository userRepository;
    private  final UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/token")
    public Map<String, Object> getToken(@RequestBody UserRequest authRequest) {

        Optional<User> user = userRepository.findByEmail(authRequest.getEmail());
        Map<Object, Object> tokenData = new HashMap<>();
        if(user.isPresent()){
            if (user.get().getDeletedAt() != null)  throw new RuntimeException("invalid access");
            Authentication authenticate = authenticationManager
                    .authenticate(
                            new AuthenticationToken(
                                    authRequest.getEmail(),
                                    authRequest.getPassword(),user.get().getRole().getId().toString())
                    );
            if (authenticate.isAuthenticated()) {
                tokenData.put("token", userService.generateToken(authRequest.getEmail(),user.get().getRole().getId()));
                tokenData.put("email", user.get().getEmail());
                tokenData.put("role", user.get().getRole().getRoleName());
                return ResponseMessage.responseObject("Token is valid", false, true, tokenData);
            } else {
                throw new RuntimeException("invalid access");
            }
        }
        return ResponseMessage.responseObject("There is no data response", true, false);
    }
}
