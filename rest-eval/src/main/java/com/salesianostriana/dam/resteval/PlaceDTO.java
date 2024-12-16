package com.salesianostriana.dam.resteval;

import java.util.List;

public record PlaceDTO(Long id , String nombre , String direccion, String location, String desc, List<String> tags, String image) {

    public PlaceDTO of(Place place){
        return new PlaceDTO(place.getId(), place.getName(), place.getAddress(), place.getCoords(), place.getDesc(),place.getTags(),place.getImage());
    }
}
