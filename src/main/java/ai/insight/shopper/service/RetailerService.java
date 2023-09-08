package ai.insight.shopper.service;

import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Random;

@Service
public class RetailerService {

    public float getAmazonPrice(Float sourcePrice, String brand, String itemName) {
        // fetch price from amazon by scrape or through daily feed
        return adjustValue(sourcePrice);
    }

    public float getAlibabaPrice(Float sourcePrice, String brand, String itemName) {
        // fetch price from alibaba by scrape or through daily feed
        return adjustValue(sourcePrice);
    }

    public float getYahooShoppingJapanPrice(Float sourcePrice, String brand, String itemName) {
        // fetch price from alibaba by scrape or through daily feed
        return adjustValue(sourcePrice);
    }

    public float getMercariPrice(Float sourcePrice, String brand, String itemName) {
        // fetch price from alibaba by scrape or through daily feed
        return adjustValue(sourcePrice);
    }

    private float adjustValue(float input) {
        // Create a random number generator
        Random random = new Random();

        // Generate a random boolean (true or false)
        boolean isPositive = random.nextBoolean();

        // Generate a random adjustment value between 0.0 and 1.0
        float adjustment = random.nextFloat();

        // Apply the adjustment, either positive or negative
        if (!isPositive) {
            adjustment = -adjustment;
        }

        // Calculate the adjusted value
        float adjustedValue = input + adjustment;

        DecimalFormat df = new DecimalFormat("#.##");
        adjustedValue = Float.parseFloat(df.format(adjustedValue));

        return adjustedValue;
    }
}
