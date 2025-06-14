////package com.arjun.currencyconverter.controller;
////
////import com.arjun.currencyconverter.model.CurrencyRequest;
////import com.arjun.currencyconverter.service.CurrencyService;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.PostMapping;
////import org.springframework.web.bind.annotation.RequestBody;
////import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.bind.annotation.RestController;
////
////import java.util.Map;
////
////@RestController
////@RequestMapping("/api")
////public class CurrencyController {
////
////    @Autowired
////    private CurrencyService currencyService;
////
////    @PostMapping("/convert")
////    public ResponseEntity<?> convertCurrency(@RequestBody CurrencyRequest request) {
////        double result = currencyService.convert(request.getBaseCurrency(), request.getTargetCurrency(), request.getAmount());
////        return ResponseEntity.ok(Map.of("convertedAmount", result));
////    }
////}
//
////
////package com.arjun.currencyconverter.controller;
////
////import com.arjun.currencyconverter.model.CurrencyRequest;
////import com.arjun.currencyconverter.service.CurrencyService;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Controller;
////import org.springframework.ui.Model;
////import org.springframework.web.bind.annotation.*;
////
////@Controller
////public class CurrencyController {
////
////    @Autowired
////    private CurrencyService currencyService;
////
////    @GetMapping("/")
////    public String showForm(Model model) {
////        model.addAttribute("currencyRequest", new CurrencyRequest());
////        return "index";
////    }
////
////    @PostMapping("/convert")
////    public String convertCurrency(@ModelAttribute CurrencyRequest currencyRequest, Model model) {
////        double result = currencyService.convert(
////                currencyRequest.getBaseCurrency(),
////                currencyRequest.getTargetCurrency(),
////                currencyRequest.getAmount()
////        );
////        model.addAttribute("result", result);
////        model.addAttribute("currencyRequest", currencyRequest);
////        return "index";
////    }
////}
//
//package com.arjun.currencyconverter.controller;
//
//import com.arjun.currencyconverter.model.CurrencyRequest;
//import com.arjun.currencyconverter.service.CurrencyService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//public class CurrencyController {
//
//    @Autowired
//    private CurrencyService currencyService;
//
//    @GetMapping("/")
//    public String showForm(Model model) {
//        model.addAttribute("currencyRequest", new CurrencyRequest());
//        return "index";  // loads templates/index.html
//    }
//
//    @PostMapping("/convert")
//    public String convertCurrency(@ModelAttribute CurrencyRequest currencyRequest, Model model) {
//        double result = currencyService.convert(
//                currencyRequest.getBaseCurrency(),
//                currencyRequest.getTargetCurrency(),
//                currencyRequest.getAmount()
//        );
//        model.addAttribute("result", result);
//        model.addAttribute("currencyRequest", currencyRequest);
//        return "index";  // show result on the same page
//    }
//}





package com.arjun.currencyconverter.controller;

import com.arjun.currencyconverter.model.CurrencyRequest;
import com.arjun.currencyconverter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @PostMapping("/convert")
    public Map<String, Object> convertCurrency(@RequestBody CurrencyRequest request) {
        double result = currencyService.convert(
                request.getBaseCurrency(),
                request.getTargetCurrency(),
                request.getAmount()
        );
        return Map.of(
                "amount", request.getAmount(),
                "base", request.getBaseCurrency(),
                "target", request.getTargetCurrency(),
                "convertedAmount", result
        );
    }
}
