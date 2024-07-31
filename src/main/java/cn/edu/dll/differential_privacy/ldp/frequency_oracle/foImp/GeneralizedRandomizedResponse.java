package cn.edu.dll.differential_privacy.ldp.frequency_oracle.foImp;

import cn.edu.dll.differential_privacy.ldp.frequency_oracle.FrequencyOracle;

import java.util.Random;

public class GeneralizedRandomizedResponse<T> implements FrequencyOracle<T, T> {

    private double epsilon;
    private int size;
    private double p;
    private double q;
    private T[] dataDomainArray;

    private Random random;

    public GeneralizedRandomizedResponse(double epsilon, T[] dataDomainArray) {
        this.epsilon = epsilon;
        this.dataDomainArray = dataDomainArray;
        this.size = dataDomainArray.length;
        this.p = Math.exp(epsilon) / (Math.exp(epsilon) + this.size - 1);
        this.q = 1 / (Math.exp(epsilon) + this.size - 1);

        random = new Random();
//        Arrays.quickSort(this.data);
    }

    /**
     * Get the random value of the array excluding the value on index position
     * @param index
     * @return
     */
    private T getRandomDataExcept(int index) {
        int pos = this.random.nextInt(this.size - 1);
        if (pos < index) {
            return this.dataDomainArray[pos];
        }
        return this.dataDomainArray[pos+1];
    }



    private int getIndex(T[] data, T rawData) {
        //todo: 这里是线性查找，之后想想怎么优化
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(rawData)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public T perturb(T rawData) {
        double randomPoint = Math.random();
        if (randomPoint < this.p) {
            return rawData;
        }
//        double rawDoubleData = (double)rawData;
//        int index = Arrays.binarySearch(this.data, rawDoubleData);
        int index = getIndex(this.dataDomainArray, rawData);
        return getRandomDataExcept(index);
    }

    @Override
    public double aggregate(int noiseEstimateCount, int userSize) {
        return (noiseEstimateCount * 1.0 / userSize - this.q)/(this.p - this.q);
    }

    public double getProbabilityP() {
        return p;
    }

    public double getProbabilityQ() {
        return q;
    }

    public static void main(String[] args) {

    }


}
