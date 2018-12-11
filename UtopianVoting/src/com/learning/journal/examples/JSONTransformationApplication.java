package com.learning.journal.examples;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.json.simple.JSONObject;

public class JSONTransformationApplication extends Configured implements Tool {

	public static void main(String[] args) throws Exception {
		int res = ToolRunner.run(new JSONTransformationApplication(), args);
		System.exit(res);
	}

	@Override
	public int run(String[] arg0) throws Exception {
		if (arg0.length < 2) {
			System.out.println("usage: [input] [output]");
			System.exit(-1);
		}

		Configuration conf = getConf();
		Job job = Job.getInstance(conf, "User Avg Time");
//		DistributedCache.addFileToClassPath(new Path("/user/maria_dev/lib/json-simple-1.1.1"), conf);
		job.setJarByClass(JSONTransformationApplication.class);
		job.setMapperClass(JSONTransformationMapper.class);
		job.setNumReduceTasks(0);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(JSONObject.class);
		FileInputFormat.setInputPaths(job, new Path(arg0[0]));
		FileOutputFormat.setOutputPath(job, new Path(arg0[1]));

		return job.waitForCompletion(true) ? 0 : 1;
	}

}
