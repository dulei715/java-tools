package cn.edu.dll.differential_privacy.cdp.exponential_mechanism.utility;

public interface UtilityFunction<X,R> {
    Double getUtilityValue(X inputElement, R outputElement);

}
