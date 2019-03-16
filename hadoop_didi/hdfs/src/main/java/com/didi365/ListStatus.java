package com.didi365;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;


import java.io.IOException;
import java.net.URI;

/**
 * 显示hadoop文件系统中一组路径的文件信息
 */
public class ListStatus {

    public static void main(String[] args) throws IOException {
        String uri = args[0];
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri), conf);
        Path[] paths = new Path[args.length];
        for (int i = 0; i < paths.length; i++) {
            paths[i] = new Path(args[i]);
        }
        FileStatus[] statuses = fs.listStatus(paths);
        Path[] listedPaths = FileUtil.stat2Paths(statuses);
        for (Path p :
                listedPaths) {
            System.out.println(p);
        }
        fs.close();
    }

}
