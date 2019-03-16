package com.didi365;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class WordcountMapper extends Mapper<Text, IntWritable,Text, IntWritable> {
    Text k = new Text();
    IntWritable v = new IntWritable(1);

    @Override
    protected void map(Text key, IntWritable value, Context context) throws IOException, InterruptedException {
        //1.获取一行数据
        String line = value.toString();
        //2.切割数据
        String[] words = line.split(" ");
        //3.输出
        for (String word : words) {
            key.set(word);
            context.write(k,v);
        }
    }

}
