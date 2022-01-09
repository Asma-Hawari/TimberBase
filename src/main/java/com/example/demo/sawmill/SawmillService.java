package com.example.demo.sawmill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class SawmillService {
    private final SawmillRepository sawmillRepository;

    @Autowired
    public SawmillService(SawmillRepository sawmillRepository) {
        this.sawmillRepository = sawmillRepository;
    }

    public  List<Sawmill> getSawmills(String name) {
        if( name != null && name.length() > 0) {
        return sawmillRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        }
        return sawmillRepository.findAll();
    }

    public void addNewSawmill(Sawmill sawmill){
        sawmillRepository.save(sawmill);
    }

    public void deleteSawmill(Long id) {
        boolean exists = sawmillRepository.existsById(id);
        if(!exists) {
            throw  new IllegalStateException("Sawmill with id = "+ id+ " ,does not exist");
        }
            sawmillRepository.deleteById(id);
    }

    @Transactional
    public void updateSawmill(Long id,
                              String name,
                              String city,
                              String country) {
        Sawmill sawmill = sawmillRepository.findById(id).
                orElseThrow(() -> new IllegalStateException(
                        "sawmill with id = "+id+ " ,does not exists"
                ));
        if( name != null &&
                name.length() > 0 &&
                !Objects.equals(sawmill.getName() , name)) {
            sawmill.setName(name);
        }
        if( city != null &&
                city.length() > 0 &&
                !Objects.equals(sawmill.getCity() , city)) {
            sawmill.setCity(city);
        }
        if( country != null &&
                country.length() > 0 &&
                !Objects.equals(sawmill.getCountry() , country)) {
            sawmill.setCountry(country);
        }
    }

    public Sawmill getSawmillById(Long id) {
        boolean exists = sawmillRepository.existsById(id);
        if(!exists) {
            throw  new IllegalStateException("Sawmill with id = "+ id+ " ,does not exist");
        }
        Sawmill sawmill = sawmillRepository.findById(id).get();
        return sawmill;
    }
}
