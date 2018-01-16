package com.hadoop.project.transformer.model.value;

import org.apache.hadoop.io.Writable;

import com.hadoop.project.common.KpiType;

/**
 * 自定义顶级的输出value父类
 * 
 * @author root
 *
 */
public abstract class BaseStatsValueWritable implements Writable {
    /**
     * 获取当前value对应的kpi值
     * 
     * @return
     */
    public abstract KpiType getKpi();
}
