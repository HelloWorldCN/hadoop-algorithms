package com.taobao.auction.secondary;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

/**
 * Created by wenqiang.cwq on 2014/7/8.
 */
public class CustomKeyGroupingComparator extends WritableComparator {
    public CustomKeyGroupingComparator() {
        super(CustomKey.class, true);
    }
    public int compare(WritableComparable cusk1, WritableComparable cusk2) {
        CustomKey c1 = (CustomKey)cusk1;
        CustomKey c2 = (CustomKey)cusk2;

        return c1.getNum().compareTo(c2.getNum());
    }
}
