package com.maxi.marketplace.hi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HiController {
    @GetMapping("/hi")
    String hi() {
        return "Hi World!\n";
    }
}