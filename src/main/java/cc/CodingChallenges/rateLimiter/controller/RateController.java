package cc.CodingChallenges.rateLimiter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rate")
public class RateController {

    @GetMapping
    public ResponseEntity<String> getLimited() {
        return ResponseEntity.ok("Limited, don't over use me!");
    }

    @GetMapping
    public ResponseEntity<String> getUnLimited() {
        return ResponseEntity.ok("Unlimited! Let's Go!");
    }
}
