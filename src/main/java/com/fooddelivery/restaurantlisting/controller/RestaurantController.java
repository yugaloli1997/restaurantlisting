package com.fooddelivery.restaurantlisting.controller;

import com.fooddelivery.restaurantlisting.dto.RestaurantDTO;
import com.fooddelivery.restaurantlisting.service.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantServiceImpl restaurantService;

    @GetMapping("/fetchAllRestaurant")
    public ResponseEntity<List<RestaurantDTO>> fetchAllRestaurant(){
        List<RestaurantDTO> listofRestaurant = restaurantService.fetchAllRestaurant();
        return new ResponseEntity<>(listofRestaurant, HttpStatus.OK);
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDTO> saveRestaurant(@RequestBody RestaurantDTO restaurantDTO){
            RestaurantDTO restaurant = restaurantService.save(restaurantDTO);
            return  new ResponseEntity<>(restaurant,HttpStatus.ACCEPTED);
    }

    @GetMapping("/fetchRestaurantById/{id}")
    public ResponseEntity<RestaurantDTO> fetchRestaurantById(@PathVariable Integer id){
        RestaurantDTO restaurant = restaurantService.fetchRestaurantById(id);
        if(null != restaurant){
            return  new ResponseEntity<>(restaurant,HttpStatus.OK);
        }
        return  new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

}
