package com.speedhome.poc.service.api;

import com.speedhome.poc.api.OwnerApi;
import com.speedhome.poc.api.model.Owner;
import com.speedhome.poc.api.model.OwnerRequest;
import com.speedhome.poc.api.model.Owners;
import com.speedhome.poc.service.model.OnwerEntity;
import com.speedhome.poc.service.service.OnwerService;
import com.speedhome.poc.service.validator.OnwerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/speedhome/backend/v1")
@CrossOrigin
public class OnwerControl implements OwnerApi {
    private final OnwerService onwerService;
    private final OnwerValidator onwerValidator;
    @Autowired
    public OnwerControl(OnwerService onwerService, OnwerValidator onwerValidator) {
        this.onwerService = onwerService;
        this.onwerValidator = onwerValidator;
    }
    @Override
    public ResponseEntity<Owner> addOwner(@RequestBody OwnerRequest request) {
        onwerValidator.validatorAddOnwer(request);
        Owner owner = onwerService.createOwner(request);
        return new ResponseEntity<>(owner, HttpStatus.OK);
    }
    @Override
    public  ResponseEntity<Owner> updateOwner( @PathVariable("idOwner") String idOwner,
                                               @RequestBody OwnerRequest request) {
        onwerValidator.validateUpdateOnwer(idOwner,request);
        Owner owner = onwerService.updateOwner(idOwner,request);
        return new ResponseEntity<>(owner, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<Void> removeOwner(@PathVariable("idOwner") String idOwner){
        onwerValidator.validateremoveOnwer(idOwner);
        onwerService.removeOwner(idOwner);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @Override
    public ResponseEntity<Owners> getAllOwner(){
        return new ResponseEntity<>(onwerService.getAllOwner(), HttpStatus.OK);
    }
}