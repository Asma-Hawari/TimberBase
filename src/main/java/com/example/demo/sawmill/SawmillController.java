package com.example.demo.sawmill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/sawmill")
public class SawmillController {

    private final SawmillService sawmillService;

    @Autowired
    public SawmillController(SawmillService sawmillService) {
        this.sawmillService = sawmillService;
    }

    @GetMapping
    public List<Sawmill> getSawmills(
            @RequestParam(required = false) String name) {
        return sawmillService.getSawmills(name);
    }

    @GetMapping(path = "{sawmillId}")
    public Sawmill getSawmillById(@PathVariable("sawmillId") Long id) {
        return sawmillService.getSawmillById(id);
    }

    @PostMapping
    public void registerNewSawmill(@RequestBody Sawmill sawmill) {
        sawmillService.addNewSawmill(sawmill);
    }

    @PutMapping(path = "{sawmillId}")
    public void updateSawmill(
            @PathVariable("sawmillId") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String country
            ){
        sawmillService.updateSawmill(id,name,city,country);
    }

    @DeleteMapping(path = "{sawmillId}")
    public void deleteSawmill(@PathVariable("sawmillId") Long id){

        sawmillService.deleteSawmill(id);
    }
}
