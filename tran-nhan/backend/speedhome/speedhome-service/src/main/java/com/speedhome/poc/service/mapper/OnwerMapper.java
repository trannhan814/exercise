package com.speedhome.poc.service.mapper;

import com.speedhome.poc.api.model.Owner;
import com.speedhome.poc.api.model.OwnerRequest;
import com.speedhome.poc.api.model.Owners;
import com.speedhome.poc.service.model.OnwerEntity;
import com.speedhome.poc.service.repository.OnwerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Component
public class OnwerMapper {
    private  final OnwerRepository repository ;
    @Autowired
    public OnwerMapper(OnwerRepository repository){
        this.repository = repository ;
    }
    public OnwerEntity mapOwnerEnityFromOwnerReq(OwnerRequest from) {
        OnwerEntity to = new OnwerEntity();
        to.setIdOwner(UUID.randomUUID().toString());
        to.setFullName(from.getFullName());
        to.setAddress(from.getAddress());
        to.setAge(from.getAge());
        return to;
    }

    public OnwerEntity mapOwnerEnityFromOwnerReq(String idOwner ,OwnerRequest from ){

        OnwerEntity to = repository.getOne(idOwner);
        to.setIdOwner(UUID.randomUUID().toString());
        to.setFullName(from.getFullName());
        to.setAddress(from.getAddress());
        to.setAge(from.getAge());
        return to;
    }

    public Owner mapOwnerFromOwnerEnity(OnwerEntity from) {
        Owner to = new Owner();
        to.setIdOwner(from.getIdOwner());
        to.setFullName(from.getFullName());
        to.setAddress(from.getAddress());
        to.setAge(from.getAge());
        return to;
    }

    public Owners mapOwnersFromOwnerEntity(List<OnwerEntity> enityList) {
        Owners owners = new Owners();
        for ( OnwerEntity ownerEnity : enityList) {
            owners.add(mapOwnerFromOwnerEnity(ownerEnity));
        }
        return owners;

    }
}
