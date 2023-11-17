package kh.gov.rac.racsa.dto.Module;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import kh.gov.rac.racsa.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ModuleRequestDTO {
    @Max(100)
    private String name;
    @Max(100)
    private String moduleKey;
    @NotNull
    private StatusEnum status;
}
