package com.didi365;

import com.google.common.annotations.VisibleForTesting;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import java.io.IOException;


public class HdfsClientDemo1 {
    public static void main(String[] args) throws IOException {
        //1.获取文件系统
        Configuration configuration =  new Configuration();
        //配置在集群上运行
        /*参数设置
         参数优先级：     1、客户端代码中设置的值
                        2、classpath下的用户自定义配置文件
                        3、然后是服务器的默认配置
         */
        configuration.set("fs.defaultFS","hdfs://master:8022");
        FileSystem fileSystem = FileSystem.get(configuration);

        /*
        * 文件系统操作
        * */
        //1.把本地文件上传到文件系统中
        //fileSystem.copyFromLocalFile(new Path("C:\\Users\\luxiaole\\Downloads\\query-hive-2383.csv"),new Path("/query-hive-2383.csv"));
        //2.文件下载
        //fileSystem.copyToLocalFile(new Path("hdfs://master:8022/aaa.txt"),new Path("d:\\aaa.copy.txt"));
        //hdfs文件夹的创建和删除
        //fileSystem.mkdirs(new Path("hdfs://master:8022/output"));
        fileSystem.delete(new Path("hdfs://master:8022/out"));
        //文件重命名
        //fileSystem.rename(new Path("hdfs://master:8022/query-hive-2383.csv"),new Path("hdfs://master:8022/bbb.csv"));


        //关闭资源
        fileSystem.close();
        System.out.println("over");



    }

}
