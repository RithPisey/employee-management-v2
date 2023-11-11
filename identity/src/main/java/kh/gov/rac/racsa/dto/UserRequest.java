package kh.gov.rac.racsa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private Integer userId;
    private Integer employeeId;
    private String email;
    private String employeeCode;
    private String password;
    private String createdBy;
    private Integer roleId;
}
