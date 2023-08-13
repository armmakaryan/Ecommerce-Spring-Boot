package com.smartCode.ecommerce.feign;

import com.smartCode.ecommerce.model.dto.card.CreateCardDto;
import com.smartCode.ecommerce.model.dto.card.ResponseCardDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@FeignClient(value = "cardService", url = "http://localhost:8081/cards")
public interface CardFeignClient {

    @PostMapping("/create")
    ResponseEntity<ResponseCardDto> createCard(@RequestBody @Valid CreateCardDto createCardDto);

    @GetMapping("/users")
    List<ResponseCardDto> getCardsByUserId(Integer userId);

    @GetMapping("/{id}")
    ResponseEntity<ResponseCardDto> getCardById(@PathVariable @Positive Integer id);


    @DeleteMapping("/users/{userId}")
    ResponseEntity<Void> deleteCardsByUserId(@PathVariable @Positive Integer userId);

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseCardDto> deleteCardById(@PathVariable @Positive Integer id);

}
