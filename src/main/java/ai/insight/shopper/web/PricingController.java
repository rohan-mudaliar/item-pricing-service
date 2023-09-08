package ai.insight.shopper.web;

import ai.insight.shopper.service.RetailerService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PricingController {

    @Autowired
    private RetailerService retailerService;

    @GetMapping("/ping")
    public String hello() {
        return "service pinged at" + System.currentTimeMillis();
    }

    @GetMapping("/getCompetitivePrice")
    public ResponseEntity<String> getCompetitivePrice (
            @RequestParam float price,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String itemName
    ) {

        float amazonPrice = retailerService.getAmazonPrice(price, brand, itemName);
        float alibabaPrice = retailerService.getAlibabaPrice(price, brand, itemName);
        float yahooShoppingJapanPrice = retailerService.getYahooShoppingJapanPrice(price, brand, itemName);
        float mercariPrice = retailerService.getMercariPrice(price, brand, itemName);

        JSONObject responseObject = new JSONObject();

        JSONObject competitorPriceObj = new JSONObject();
        competitorPriceObj.put("Amazon", amazonPrice);
        competitorPriceObj.put("Alibaba", alibabaPrice);
        competitorPriceObj.put("Yahoo Shopping Japan", yahooShoppingJapanPrice);
        competitorPriceObj.put("Mercari", mercariPrice);

        responseObject.put("competitors", competitorPriceObj);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(responseObject.toString());
    }
}

