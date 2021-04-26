package com.wazny.routing;

import org.springframework.web.bind.annotation.*;

@RestController
public class DojoController {

    @GetMapping("/{place}")
    public String place(@PathVariable String place) {

        if (place.equalsIgnoreCase("dojo")) {
            return "The dojo is awesome";
        }
        if (place.equalsIgnoreCase("burbank-dojo")) {
            return "Burbank Dojo is located in Southern California";
        }
        if (place.equalsIgnoreCase("san-jose")) {
            return "SJ is the headquarters";
        }
        return "";

    }
}
