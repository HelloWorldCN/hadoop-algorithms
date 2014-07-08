package com.taobao.auction.secondary;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
/**
 * Created by wenqiang.cwq on 2014/7/8.
 */
public class SecondarySortDriver {
    public static void main(String[] args)  throws Exception {
        Configuration config = new Configuration();
        Job job = new Job(config, "Secondary Sorting");
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        job.setJarByClass(SecondarySortDriver.class);
        job.setMapOutputKeyClass(CustomKey.class);
        job.setMapOutputValueClass(Text.class);
        job.setOutputKeyClass(CustomKey.class);
        job.setOutputValueClass(Text.class);
        job.setMapperClass(SecondarySortingMapper.class);
        job.setPartitionerClass(CustomPartitioner.class);
        job.setGroupingComparatorClass(CustomKeyGroupingComparator.class);
        job.setReducerClass(SecondarySortingReducer.class);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
