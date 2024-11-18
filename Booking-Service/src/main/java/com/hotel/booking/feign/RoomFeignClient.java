package com.hotel.booking.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "room-service")
public interface RoomFeignClient {
    @GetMapping("/api/admin/rooms/{id}")
    Object getRoomById(@PathVariable Long id);
}

