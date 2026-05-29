package com.demo.travelcardsystem.controller;

import com.demo.travelcardsystem.model.request.CardRegistrationRequest;
import com.demo.travelcardsystem.model.request.SwipeRequest;
import com.demo.travelcardsystem.model.response.TravelCardResponse;
import com.demo.travelcardsystem.service.TravellerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/card")
@AllArgsConstructor
@CrossOrigin
@Tag(name = "Travel Card", description = "Endpoints for managing Al-Naqel travel cards, recharging balances, and processing station swipes")
public class TravellerController {

    private TravellerService travellerService;

    @Operation(summary = "Health check", description = "Returns a simple message confirming the service is running")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Service is running normally")
    })
    @GetMapping(value = "/ping")
    public String pingMe() {
        return "Service is UP and Running";
    }

    @Operation(summary = "Register a new travel card", description = "Creates a new travel card in the system with an optional opening balance")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Card registered successfully"),
            @ApiResponse(responseCode = "406", description = "Invalid card number or negative balance provided")
    })
    @PostMapping(value = "/register")
    public void registerNewUser(@RequestBody CardRegistrationRequest cardRegistrationRequest) {
        travellerService.registerNewCard(cardRegistrationRequest);
    }

    @Operation(summary = "Recharge a travel card", description = "Adds credit to an existing travel card identified by card number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Card recharged successfully"),
            @ApiResponse(responseCode = "406", description = "Invalid card number or negative recharge amount provided")
    })
    @PostMapping(value = "/recharge/{rechargeAmount}")
    public void rechargeTheCard(
            @RequestBody String cardNumber,
            @Parameter(description = "Amount in AED to add to the card balance", example = "10.0")
            @PathVariable double rechargeAmount) {
        travellerService.rechargeTheCard(cardNumber, rechargeAmount);
    }

    @Operation(summary = "Swipe a travel card at a station", description = "Processes a tap-in or tap-out event. On tap-in the maximum fare is held. On tap-out the correct fare is calculated and the difference refunded.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Swipe processed successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request data provided"),
            @ApiResponse(responseCode = "406", description = "Card not found or insufficient balance")
    })
    @PostMapping(value = "/swipe")
    public TravelCardResponse swipeCard(@RequestBody SwipeRequest swipeRequest) {
        return travellerService.swipeCard(swipeRequest);
    }

    @Operation(summary = "Get travel card details", description = "Returns the current balance, transit status, and transport type for a given card number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Card details returned successfully"),
            @ApiResponse(responseCode = "406", description = "Card not found")
    })
    @GetMapping(value = "/{cardNumber}")
    public TravelCardResponse checkCardDetail(
            @Parameter(description = "The unique card number to look up", example = "CARD-001")
            @PathVariable String cardNumber) {
        return travellerService.checkCardDetail(cardNumber);
    }

    @Operation(summary = "List all registered card numbers", description = "Returns a list of all card numbers currently registered in the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List returned successfully")
    })
    @GetMapping
    public List<String> fetchAllCard() {
        return travellerService.fetchAllCard();
    }
}