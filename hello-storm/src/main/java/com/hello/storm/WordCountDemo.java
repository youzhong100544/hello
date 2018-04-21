package com.hello.storm;

import java.util.Map;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;

public class WordCountDemo {
	
	public static void main(String[] args) {
		TopologyBuilder builder = new TopologyBuilder();
		builder.setSpout("wordCount_LineSpout", new LineSpout());
		
		builder.setBolt("wordCount_SplitBolt", new SplitBolt()).shuffleGrouping("wordCount_LineSpout");
		builder.setBolt("wordCount_Bolt", new WordCountBolt()).fieldsGrouping("wordCount_SplitBolt",new Fields("word"));
		
		LocalCluster localCluster = new LocalCluster();
		localCluster.submitTopology("wordCount", new Config(), builder.createTopology());
		
	}
	
	public static class LineSpout extends BaseRichSpout{

		public void nextTuple() {
			// TODO Auto-generated method stub
			
		}

		public void open(Map map, TopologyContext context, SpoutOutputCollector collector) {
			// TODO Auto-generated method stub
			
		}

		public void declareOutputFields(OutputFieldsDeclarer declarer) {
			declarer.declare(new Fields("line"));
		}
		
	}
	
	public static class SplitBolt extends BaseRichBolt{

		public void execute(Tuple arg0) {
			// TODO Auto-generated method stub
			
		}

		public void prepare(Map map, TopologyContext context, OutputCollector collector) {
			// TODO Auto-generated method stub
			
		}

		public void declareOutputFields(OutputFieldsDeclarer declarer) {
			declarer.declare(new Fields("word"));
		}
		
	}
	
	public static class WordCountBolt extends BaseRichBolt{

		public void execute(Tuple arg0) {
			// TODO Auto-generated method stub
			
		}

		public void prepare(Map map, TopologyContext context, OutputCollector collector) {
			// TODO Auto-generated method stub
			
		}

		public void declareOutputFields(OutputFieldsDeclarer declarer) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
