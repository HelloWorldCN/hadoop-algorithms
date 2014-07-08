package com.taobao.auction.secondary;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Created by wenqiang.cwq on 2014/7/8.
 */
public class CustomKey implements Writable, WritableComparable<CustomKey>{
    private IntWritable num = new IntWritable();
    private Text str = new Text();

    public CustomKey() {}

    public CustomKey(IntWritable num, Text str) {
        this.num = num;
        this.str = str;
    }

    public static CustomKey read(DataInput in) throws IOException {
        CustomKey cusk = new CustomKey();
        cusk.readFields(in);
        return cusk;
    }

    public void write(DataOutput out) throws IOException{
        num.write(out);
        str.write(out);
    }

    public void readFields(DataInput in) throws IOException {
        num.readFields(in);
        str.readFields(in);
    }

    public int compareTo(CustomKey cusk) {
        int compareValue = this.num.compareTo(cusk.getNum());
        if (compareValue == 0) {
            compareValue = this.str.compareTo(cusk.getStr());
        }
        return compareValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomKey that = (CustomKey) o;

        if (str != null ? !str.equals(that.str) : that.str != null) return false;
        if (num != null ? !num.equals(that.num) : that.num != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = num != null ? num.hashCode() : 0;
        result = 31 * result + (str != null ? str.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CustomKey{" +
                "num=" + num +
                ", str=" + str +
                '}';
    }

    public IntWritable getNum() {
        return this.num;
    }

    public Text getStr() {
        return this.str;
    }

    public void setNum(int num) {
        this.num = new IntWritable(num);
    }

    public void setStr(String str) {
        this.str = new Text(str);
    }


}
