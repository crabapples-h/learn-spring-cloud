package cn.crabapples.turingrobotapi.controller;

import cn.crabapples.turingrobotapi.utils.TuringApiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/truing")
public class TuringController {
    private final TuringApiUtils turingApiUtils;

    public TuringController(TuringApiUtils turingApiUtils) {
        this.turingApiUtils = turingApiUtils;
    }

    @GetMapping("/get/text")
    public String getText() {
        String message = turingApiUtils.sendToTuringApi("哈哈哈");
        return message;
    }
}
