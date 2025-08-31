package org.stockflow.utility;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("stockflow")

public class AppCheck {

    @GetMapping("/check")
    public String getStatus() {
        System.out.println("Live");
        return "Live";
    }


}
