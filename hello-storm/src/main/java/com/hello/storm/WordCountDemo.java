package com.hello.storm;

import java.util.Map;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Tuple;

public class WordCountDemo {
	
	public static void main(String[] args) {
		
	}
	
	private static class WordCountSpout extends BaseRichSpout{

		public void nextTuple() {
			// TODO Auto-generated method stub
			
		}

		public void open(Map map, TopologyContext context, SpoutOutputCollector collector) {
			// TODO Auto-generated method stub
			
		}

		public void declareOutputFields(OutputFieldsDeclarer declarer) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private static class WordCountBolt extends BaseRichBolt{

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
