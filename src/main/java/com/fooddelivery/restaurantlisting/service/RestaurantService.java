package com.fooddelivery.restaurantlisting.service;

import com.fooddelivery.restaurantlisting.dto.RestaurantDTO;

import java.util.List;

public interface RestaurantService {

    public List<RestaurantDTO> fetchAllRestaurant();

    RestaurantDTO save(RestaurantDTO restaurantDTO);

    RestaurantDTO fetchRestaurantById(Integer id);
}
