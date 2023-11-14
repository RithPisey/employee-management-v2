package kh.gov.rac.racsa.service.serviceImp;


import kh.gov.rac.racsa.service.UserService;
import kh.gov.rac.racsa.utils.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImp implements UserService {
    private final JwtService jwtService;
    @Override
    public String generateToken(String email, Long roleId) {

        return jwtService.generateToken(email,roleId);
    }
}
