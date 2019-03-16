package com.didi365;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HdfsOperation {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        //1.获取文件系统
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://master:8022"),configuration, "luxiaole");
        //2.操作文件系统
        //删除文件夹，删除文件

        fs.delete(new Path("hdfs://master:8022/user/hive/warehouse/didi_bigdata_analyze.db/user_data2/.hive-staging_hive_2019-01-17_09-33-00_875_5136711805331109437-1"),true);
        fs.close();


    }
}
