package com.hadoop.project.transformer.model.value.reduce;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableUtils;

import com.hadoop.project.common.KpiType;
import com.hadoop.project.transformer.model.value.BaseStatsValueWritable;

/**
 * 自定义location统计reducer的输出value类
 * 
 * @author root
 *
 */
public class LocationReducerOutputValue extends BaseStatsValueWritable {
    private KpiType kpi;
    private int uvs; // 活跃用户数
    private int visits; // 会话个数
    private int bounceNumber; // 跳出会话个数

    public void setKpi(KpiType kpi) {
        this.kpi = kpi;
    }

    public int getUvs() {
        return uvs;
    }

    public void setUvs(int uvs) {
        this.uvs = uvs;
    }

    public int getVisits() {
        return visits;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }

    public int getBounceNumber() {
        return bounceNumber;
    }

    public void setBounceNumber(int bounceNumber) {
        this.bounceNumber = bounceNumber;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeInt(this.uvs);
        out.writeInt(this.visits);
        out.writeInt(this.bounceNumber);
        WritableUtils.writeEnum(out, this.kpi);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        this.uvs = in.readInt();
        this.visits = in.readInt();
        this.bounceNumber = in.readInt();
        this.kpi = WritableUtils.readEnum(in, KpiType.class);
    }

    @Override
    public KpiType getKpi() {
        return this.kpi;
    }

}
