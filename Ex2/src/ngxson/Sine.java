package ngxson;

public class Sine implements RealFunction {
    @Override
    public double apply(double input) {
        return Math.sin(input);
    }
}
