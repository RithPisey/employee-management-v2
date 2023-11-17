package kh.gov.rac.racsa.controller;

import kh.gov.rac.racsa.dto.Module.ModuleFilterInputDTO;
import kh.gov.rac.racsa.dto.Module.ModuleRequestDTO;
import kh.gov.rac.racsa.model.Module;
import kh.gov.rac.racsa.service.ModuleService;
import kh.gov.rac.racsa.utils.ResponseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Set;

@RestController
@RequestMapping("/api/module")
@RequiredArgsConstructor
@Slf4j
public class ModuleController {

    private final ModuleService moduleService;


    @GetMapping
    public HashMap<String, Object> moduleData(@RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue= "1000") int size,
                           @RequestParam(defaultValue = "created_at") String orderBy,
                           @RequestParam(defaultValue = "desc") String orderType,
                           @RequestBody ModuleFilterInputDTO filter
                           ){
        Set<Module> modules = moduleService.getModule(page, size, orderBy, orderType, filter);
        return ResponseMessage.responseObject(
                "module list",
                false,
                true,
                    modules,
                    ResponseMessage.getPaginate(page, size, orderBy, orderType),
                    filter
                );
    }


    @PostMapping("/create")
    public void createModule(@RequestBody ModuleRequestDTO moduleRequestDTO){
        Boolean isCreated = moduleService.createModule(moduleRequestDTO);
    }


}
