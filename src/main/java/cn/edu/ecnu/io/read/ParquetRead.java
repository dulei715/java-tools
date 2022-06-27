package cn.edu.ecnu.io.read;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.parquet.example.data.Group;
import org.apache.parquet.example.data.GroupFactory;
import org.apache.parquet.example.data.simple.SimpleGroupFactory;
import org.apache.parquet.hadoop.ParquetReader;
import org.apache.parquet.hadoop.ParquetWriter;
import org.apache.parquet.hadoop.example.GroupReadSupport;
import org.apache.parquet.hadoop.example.GroupWriteSupport;
import org.apache.parquet.schema.MessageType;
import org.apache.parquet.schema.MessageTypeParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class ParquetRead {

//    public static Logger logger = Logger.getLogger(ParquetRead.class);

    public static void main(String[] args) throws Exception {

//    parquetWriter("test\\parquet-out2","input.txt");
//        String inPath = "F:\\dataset\\yellow_tripdata_2022-01.parquet";
        String inPath = "F:\\dataset\\yellow_tripdata_2016-01.parquet";

        parquetReaderV2(inPath);

    }

    private static void parquetReaderV2(String inPath) throws Exception{

        GroupReadSupport readSupport = new GroupReadSupport();

        ParquetReader.Builder<Group> reader= ParquetReader.builder(readSupport, new Path(inPath));

        ParquetReader<Group> build=reader.build();

        Group line=null;

        while((line=build.read())!=null){
            System.out.println(line);
//            break;
//            System.out.println(line.getLong("VendorID", 0));
//            System.out.println(line.getLong(0, 0));
//            System.out.println(line.getLong(1, 0));
//            System.out.println(line.getLong(2, 0));
//            System.out.println(line.getDouble(5, 0));
//            System.out.println(line.getDouble(6, 0));
            break;
        }
        System.out.println("读取结束");

    }

    //新版本中new ParquetReader()所有构造方法好像都弃用了,用上面的builder去构造对象

    public static void parquetReader(String inPath) throws Exception{

        GroupReadSupport readSupport = new GroupReadSupport();
        Path path = new Path(inPath);

//        ParquetReader<Group> reader = new ParquetReader<Group>(path,readSupport);
        ParquetReader<Group> reader = ParquetReader.<Group>builder(readSupport, path).build();

        Group line=null;

        while((line=reader.read())!=null){

            System.out.println(line.toString());

        }

        System.out.println("读取结束");

    }

    /**

     *

     * @param outPath　　输出Parquet格式

     * @param inPath 输入普通文本文件

     * @throws IOException

     */

    static void parquetWriter(String outPath,String inPath) throws IOException {

        MessageType schema = MessageTypeParser.parseMessageType("message Pair {\n" +
                        " required binary city (UTF8);\n" +
                        " required binary ip (UTF8);\n" +
                        " repeated group time {\n"+" required int32 ttl;\n"+" required binary ttl2;\n"+"}\n"+
                        "}");

        GroupFactory factory = new SimpleGroupFactory(schema);

        Path path = new Path(outPath);

        Configuration configuration = new Configuration();

        GroupWriteSupport writeSupport = new GroupWriteSupport();

        writeSupport.setSchema(schema,configuration);

        ParquetWriter<Group> writer = new ParquetWriter<Group>(path,configuration,writeSupport);

        //把本地文件读取进去，用来生成parquet格式文件

        BufferedReader br =new BufferedReader(new FileReader(new File(inPath)));

        String line="";

        Random r = new Random();

        while((line=br.readLine())!=null){

            String[] strs=line.split("\\s+");

            if(strs.length==2) {

                Group group = factory.newGroup().append("city",strs[0]).append("ip",strs[1]);

                Group tmpG =group.addGroup("time");

                tmpG.append("ttl", r.nextInt(9)+1);

                tmpG.append("ttl2", r.nextInt(9)+"_a");

                writer.write(group);

            }

        }

        System.out.println("write end");

        writer.close();

    }
}
