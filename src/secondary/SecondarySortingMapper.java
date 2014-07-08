package com.taobao.auction.secondary;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by wenqiang.cwq on 2014/7/8.
 */
public class SecondarySortingMapper extends Mapper<LongWritable, Text, CustomKey, Text> {

    private CustomKey cusk = new CustomKey();

    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] lines = line.split(",");

        System.err.println(lines);

        cusk.setNum(Integer.parseInt(lines[0]));
        cusk.setStr(lines[1]);

        context.write(cusk, new Text(lines[1]));
    }
}
