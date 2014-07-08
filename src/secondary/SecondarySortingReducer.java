package com.taobao.auction.secondary;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by wenqiang.cwq on 2014/7/8.
 */
public class SecondarySortingReducer extends Reducer<CustomKey, Text, IntWritable, Text> {
    protected void reduce(CustomKey key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        for(Text v : values) {
            context.write(key.getNum(), v);
        }
    }
}
