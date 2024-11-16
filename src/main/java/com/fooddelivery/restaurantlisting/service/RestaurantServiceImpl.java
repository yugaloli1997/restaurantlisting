package com.fooddelivery.restaurantlisting.service;

import com.fooddelivery.restaurantlisting.dto.RestaurantDTO;
import com.fooddelivery.restaurantlisting.entity.Restaurant;
import com.fooddelivery.restaurantlisting.entity.mapper.RestaurantMapper;
import com.fooddelivery.restaurantlisting.repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService{
    
    @Autowired
    RestaurantRepo restaurantRepo;

    @Override
    public List<RestaurantDTO> fetchAllRestaurant() {

        List<Restaurant> allRestaurant = restaurantRepo.findAll();

        return allRestaurant.stream().map(RestaurantMapper.INSTANCE::mapRestaurantToRestaurantDTO).toList();
    }

    @Override
    public RestaurantDTO save(RestaurantDTO restaurantDTO) {

        Restaurant restaurantEntity = restaurantRepo.save(RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(restaurantDTO));
        return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurantEntity);
    }

    @Override
    public RestaurantDTO fetchRestaurantById(Integer id) {
        try{
            Optional<Restaurant> restaurantEntity = restaurantRepo.findById(id);
            return restaurantEntity.map(RestaurantMapper.INSTANCE::mapRestaurantToRestaurantDTO).orElse(null);
        }catch (Exception e) {
            return null;
        }
    }
}
