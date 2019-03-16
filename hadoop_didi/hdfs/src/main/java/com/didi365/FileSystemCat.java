package com.didi365;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/**
 * FileSystemCat用于读取hdfs文件内容的类
 *
 */
public class FileSystemCat {

    public static void main(String[] args) throws IOException {
        //1.以传参的方式指定要读取的文件地址
        String uri = args[0];
        //2.创建fs配置
        Configuration conf = new Configuration();
        //3.获取文件系统
        FileSystem fs = FileSystem.get(URI.create(uri), conf);
        InputStream in = null;
        try {
            in = fs.open(new Path(uri));
            //io流读取文件内容
            IOUtils.copyBytes(in, System.out, 4096, false);
        } finally {
            IOUtils.closeStream(in);
        }
    }


}
