package cn.edu.ecnu.math.methods.solve_function.iteration_methods;

public abstract class IterationMethod {
    protected abstract double getNextValue(double currentValue);
    public double getValue(double initValue, double precision) {
        double resultValueNew = initValue;
        double resultValueBefore;
        do {
            resultValueBefore = resultValueNew;
            resultValueNew = getNextValue(resultValueBefore);
        } while (Math.abs(resultValueNew - resultValueBefore) > precision);
        return resultValueNew;
    }
}
