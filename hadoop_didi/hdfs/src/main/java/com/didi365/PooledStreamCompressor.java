package com.didi365;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.compress.CodecPool;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.CompressionOutputStream;
import org.apache.hadoop.io.compress.Compressor;
import org.apache.hadoop.util.ReflectionUtils;

import java.io.IOException;

/**
 * 使用压缩池对读取自标准输入的数据进行压缩，然后将其写到标准输出
 */

public class PooledStreamCompressor {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        String codecClassname = args[0];
        Class<?> codecClass = Class.forName(codecClassname);

        Configuration conf = new Configuration();
        CompressionCodec codec = (CompressionCodec)
                ReflectionUtils.newInstance(codecClass,conf);

        Compressor compressor = null;
        try {
            compressor = CodecPool.getCompressor(codec);
            CompressionOutputStream out = codec.createOutputStream(System.out, compressor);
            IOUtils.copyBytes(System.in,out,4096,false);
            out.close();
        } finally {
            CodecPool.returnCompressor(compressor);
        }


    }


}
