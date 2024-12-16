package com.salesianostriana.dam.resteval;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/place")
@RestController
public class PlaceController {

    private final PlaceRepository placeRepository;

    @GetMapping
    public ResponseEntity<List<Place>> getAll(){
        if(placeRepository.getAll().isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(placeRepository.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Place>findById(@PathVariable Long id){
        if(placeRepository.get(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(placeRepository.get(id).get());
    }


    @PostMapping
    public ResponseEntity<Place>putPlace(@RequestBody Place newPlace){

        return ResponseEntity.ok(placeRepository.add(newPlace));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Place>edit(@PathVariable Long id , @RequestBody Place place){
        if(placeRepository.get(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(placeRepository.edit(id, place).get());
    }
}
