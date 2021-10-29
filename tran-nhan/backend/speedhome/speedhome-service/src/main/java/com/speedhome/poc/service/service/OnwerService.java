package com.speedhome.poc.service.service;

import com.speedhome.poc.api.model.Owner;
import com.speedhome.poc.api.model.OwnerRequest;
import com.speedhome.poc.api.model.Owners;
import com.speedhome.poc.service.mapper.OnwerMapper;
import com.speedhome.poc.service.model.OnwerEntity;
import com.speedhome.poc.service.repository.OnwerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OnwerService {
    private  final OnwerMapper onwerMapper ;
    private  final OnwerRepository onwerRepository ;
    @Autowired
    public OnwerService(OnwerMapper onwerMapper , OnwerRepository onwerRepository){
        this.onwerMapper = onwerMapper ;
        this.onwerRepository = onwerRepository;
    }
    public Owner createOwner(OwnerRequest request) {
        OnwerEntity onwerEntity = onwerMapper.mapOwnerEnityFromOwnerReq(request);
        return  onwerMapper.mapOwnerFromOwnerEnity(onwerRepository.save(onwerEntity));
    }

    public Owner updateOwner(String idOwner, OwnerRequest request) {
        OnwerEntity onwerEntity = onwerMapper.mapOwnerEnityFromOwnerReq(idOwner,request);
        return onwerMapper.mapOwnerFromOwnerEnity(onwerRepository.save(onwerEntity));
    }

    public void removeOwner(String idOwner) {
        onwerRepository.deleteById(idOwner);
    }


    public Owners getAllOwner() {
        List<OnwerEntity> enityList = onwerRepository.findAll();
        return onwerMapper.mapOwnersFromOwnerEntity(enityList);
    }

}
