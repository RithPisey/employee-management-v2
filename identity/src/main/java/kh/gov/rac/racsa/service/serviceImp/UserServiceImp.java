package kh.gov.rac.racsa.service.serviceImp;


import kh.gov.rac.racsa.service.UserService;
import kh.gov.rac.racsa.utils.JwtService;

public class UserServiceImp implements UserService {
    private final JwtService jwtService = new JwtService();
    @Override
    public String generateToken(String email, Integer roleId) {

        return jwtService.generateToken(email,roleId);
    }
}
