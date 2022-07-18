package cn.edu.ecnu.statistic;

public class DistributionUtil {

    /**
     * 根据给定的面积来返回对应的点坐标
     * 该分布为 1/ln(2) * 1/(x+1)
     * @param areaSize 从0到x积分后对应的面积值大小
     * @return 随机的该分布上的点及其概率密度值
     */
    public static double[] getSkewZipfRandomPoint(double areaSize) {
        double ln2 = Math.log(2);
        double x = Math.exp(areaSize*ln2) - 1;
        double y = 1 / ln2 / (x + 1);
        return new double[]{x, y};
    }
}
