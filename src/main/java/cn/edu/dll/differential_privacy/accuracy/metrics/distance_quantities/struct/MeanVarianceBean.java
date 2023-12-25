package cn.edu.dll.differential_privacy.accuracy.metrics.distance_quantities.struct;

import java.util.Objects;

public class MeanVarianceBean {
    private Double mean = null;
    private Double variance = null;

    public MeanVarianceBean() {
    }

    public MeanVarianceBean(Double mean, Double variance) {
        this.mean = mean;
        this.variance = variance;
    }

    public Double getMean() {
        return mean;
    }

    public void setMean(Double mean) {
        this.mean = mean;
    }

    public Double getVariance() {
        return variance;
    }

    public void setVariance(Double variance) {
        this.variance = variance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MeanVarianceBean)) return false;
        MeanVarianceBean that = (MeanVarianceBean) o;
        return Objects.equals(mean, that.mean) && Objects.equals(variance, that.variance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mean, variance);
    }

    @Override
    public String toString() {
        return "MeanVarianceBean{" +
                "mean=" + mean +
                ", variance=" + variance +
                '}';
    }
}
