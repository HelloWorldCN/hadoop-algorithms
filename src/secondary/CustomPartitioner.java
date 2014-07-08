package com.taobao.auction.secondary;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * Created by wenqiang.cwq on 2014/7/8.
 */
public class CustomPartitioner extends Partitioner<CustomKey, Text> {
    public int getPartition(CustomKey cusk, Text nullw, int numPartitions) {
        return cusk.getNum().hashCode() % numPartitions;
    }
}
