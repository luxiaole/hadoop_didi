package com.didi365;
import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordcountReducer extends Reducer<Text, IntWritable, Text, IntWritable>{

    @Override
    protected void reduce(Text key, Iterable<IntWritable> value,
                          Context context) throws IOException, InterruptedException {

        // 1 累加求和
        int sum = 0;
        for (IntWritable count : value) {
            sum += count.get();
        }

        // 2 输出
        context.write(key, new IntWritable(sum));
    }
}