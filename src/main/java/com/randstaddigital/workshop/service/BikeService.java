package com.randstaddigital.workshop.service;

import com.randstaddigital.workshop.mapper.BikeMapper;
import com.randstaddigital.workshop.model.Bike;
import com.randstaddigital.workshop.repository.BikeRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BikeService {

  private final BikeRepository bikeRepository;
  private final BikeMapper bikeMapper;

  public List<Bike> getAllBikes() {
    return bikeRepository.findAll().stream().map(bikeMapper::toModel).toList();
  }

  public Optional<Bike> getBikeById(UUID id) {
    return bikeRepository.findById(id).map(bikeMapper::toModel);
  }

  public List<Bike> getBikesByStationId(UUID stationId) {
    return bikeRepository.findAllByStationId(stationId).stream().map(bikeMapper::toModel).toList();
  }

  public void deleteBikeById(UUID id) {
    bikeRepository.deleteById(id);
  }
}
