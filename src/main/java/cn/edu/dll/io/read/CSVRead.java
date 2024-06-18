package cn.edu.dll.io.read;


import cn.edu.dll.io.print.MyPrint;
import cn.edu.dll.io.write.CSVWrite;
import cn.edu.dll.struct.bean_structs.BeanInterface;
import cn.edu.dll.struct.point.TwoDimensionalIntegerPoint;

import java.io.*;
import java.util.*;

@SuppressWarnings("Duplicates")
public class CSVRead {
    protected BufferedReader bufferedReader = null;
    public static List<Map<String, String>> readData(String filePath, int lineSize) {
        BufferedReader bufferedReader = null;
        String line = null;
        String[] dataElement;
        int dataSize;
        List<Map<String, String>> elementList = new ArrayList<>();
        List<String> keyList = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
//            line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()).startsWith(CSVWrite.commonTag));   // 循环直到读到不是注释为止
            String[] keyStrs = line.split(",");
            String[] valueStrs = null;
            Map<String, String> tempMap;
            int lineNum = 0;
            while ((line = bufferedReader.readLine()) != null && lineNum < lineSize) {
                if (line.startsWith(CSVWrite.commonTag)) {
                    continue;
                }
                valueStrs = line.split(",");
                tempMap = new HashMap<>();
                int i;
                for (i = 0; i < keyStrs.length && i < valueStrs.length; i++) {
                    tempMap.put(keyStrs[i], valueStrs[i]);
                }
                for (; i < keyStrs.length; i++) {
                    tempMap.put(keyStrs[i], "");
                }
                elementList.add(tempMap);
                ++lineNum;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return elementList;
    }
    public static List<Map<String, String>> readData(String filePath) {
        BufferedReader bufferedReader = null;
        String line = null;
        List<Map<String, String>> elementList = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
//            line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()).startsWith(CSVWrite.commonTag));   // 循环直到读到不是注释为止
            String[] keyStrs = line.split(",");
            String[] valueStrs = null;
            Map<String, String> tempMap;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.startsWith(CSVWrite.commonTag)) {
                    continue;
                }
                valueStrs = line.split(",");
                tempMap = new HashMap<>();
                int i;
                for (i = 0; i < keyStrs.length && i < valueStrs.length; i++) {
                    tempMap.put(keyStrs[i], valueStrs[i]);
                }
                for (; i < keyStrs.length; i++) {
                    tempMap.put(keyStrs[i], "");
                }
                elementList.add(tempMap);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return elementList;
    }

    public static TreeMap<TwoDimensionalIntegerPoint, Double> readTwoDimensionalIntegerPointDistributionWithoutTitle(String filePath) {
        BufferedReader bufferedReader = null;
        String line;
        TreeMap<TwoDimensionalIntegerPoint, Double> resultMap = new TreeMap<>();
        String[] valueStrs;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
//            line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()).startsWith(CSVWrite.commonTag));   // 循环直到读到不是注释为止
            Map<String, String> tempMap;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.startsWith(CSVWrite.commonTag)) {
                    continue;
                }
                valueStrs = line.split(",");
                resultMap.put(new TwoDimensionalIntegerPoint(Integer.parseInt(valueStrs[0]), Integer.parseInt(valueStrs[1])), Double.parseDouble(valueStrs[2]));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultMap;
    }

    public static List<String> readDataLinesWithoutTitle(String filePath) {
        BufferedReader bufferedReader = null;
        String line;
        List<String> elementList = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
//            line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()).startsWith(CSVWrite.commonTag));   // 循环直到读到不是注释为止
            while ((line = bufferedReader.readLine()) != null) {
                if (line.startsWith(CSVWrite.commonTag)) {
                    continue;
                }
                elementList.add(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return elementList;
    }

    public static String readDataTitle(String filePath) {
        BufferedReader bufferedReader = null;
        String line = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
//            line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()).startsWith(CSVWrite.commonTag));   // 循环直到读到不是注释为止

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return line;
    }

    public static <T> List<T> readDataToBeanList(String filePath, BeanInterface<T> beanInterface) {
        BufferedReader bufferedReader = null;
        String line;
        List<T> elementList = new ArrayList<>();
        T tempElement;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            while ((line = bufferedReader.readLine()) != null) {
                if (line.startsWith(CSVWrite.commonTag)) {
                    // 跳过注释
                    continue;
                }
                tempElement = beanInterface.toBean(line.split(","));
                elementList.add(tempElement);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return elementList;
    }

    public static void main(String[] args) {
        String filePath = "E:\\1.学习\\4.数据集\\1.FourSquare-NYCandTokyoCheck-ins\\dataset_TSMC2014_NYC.csv";
        List<Map<String, String>> data = CSVRead.readData(filePath);
        MyPrint.showList(data);

    }
}
