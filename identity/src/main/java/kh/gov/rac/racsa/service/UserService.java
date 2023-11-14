package kh.gov.rac.racsa.service;

import org.springframework.stereotype.Service;

public interface UserService  {

    String generateToken(String email,Long roleId);
}
