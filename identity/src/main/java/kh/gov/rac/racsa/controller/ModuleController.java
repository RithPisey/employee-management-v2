package kh.gov.rac.racsa.controller;

import kh.gov.rac.racsa.dto.Module.ModuleRequest;
import kh.gov.rac.racsa.service.ModuleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/module")
@RequiredArgsConstructor
@Slf4j
public class ModuleController {

    private final ModuleService moduleService;

    public void createModule(@RequestBody ModuleRequest moduleRequest){

        Boolean isCreated = moduleService.createModule(moduleRequest);

    }
}
