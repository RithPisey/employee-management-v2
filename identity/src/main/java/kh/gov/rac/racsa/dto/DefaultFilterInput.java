package kh.gov.rac.racsa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DefaultFilterInput {
    protected String search;
    protected String branch_id;
    protected String org_id;
    protected LocalDateTime created_at;
    protected Integer created_by;
}
