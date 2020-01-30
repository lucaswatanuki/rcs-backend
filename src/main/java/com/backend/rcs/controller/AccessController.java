package com.backend.rcs.controller;

import com.backend.rcs.controller.request.AccessRequest;
import com.backend.rcs.controller.request.UserRequest;
import com.backend.rcs.controller.response.AccessResponse;
import com.backend.rcs.controller.response.AccessResponse;
import com.backend.rcs.service.AccessService;
import com.backend.rcs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/access")
public class AccessController {

    @Autowired
    private AccessService accessService;

    @PostMapping("")
    public AccessResponse post(@RequestBody AccessRequest request){
        return accessService.save(request);
    }

    @GetMapping("/{id}")
    public AccessResponse getUserById(@PathVariable("id") String id){
        return accessService.findById(id);
    }

    @GetMapping("")
    public List<AccessResponse> getAll(){
        return accessService.findAllAccess();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
        accessService.delete(id);
    }
}
