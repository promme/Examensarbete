package se.nackademin.examensarbete.handlers;

/**
 * Created by olofberg on 15-05-12.
 */
public class AlgorithmHandler {

    public static float CalculatePrice(Float priceToCalculate, int numberOfMe) {
        return priceToCalculate * (1 + Float.valueOf(numberOfMe) / 10f);
    }
}
