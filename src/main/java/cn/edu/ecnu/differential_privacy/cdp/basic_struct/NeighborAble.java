package cn.edu.ecnu.differential_privacy.cdp.basic_struct;

public interface NeighborAble<T> {
    boolean isNeighborhoodWith(T element);
}
