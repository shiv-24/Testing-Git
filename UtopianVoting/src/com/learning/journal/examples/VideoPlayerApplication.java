package com.learning.journal.examples;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class VideoPlayerApplication extends Configured implements Tool {

	@Override
	public int run(String[] arg0) throws Exception {

		if (arg0.length < 2) {
			System.out.println("usage: [input] [output]");
			System.exit(-1);
		}

		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, "User Avg Time");
		job.setJarByClass(VideoPlayerApplication.class);
		job.setMapperClass(VideoPlayerMapperMappingTheUser.class);
		job.setReducerClass(VideoPlayerReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(LongWritable.class);
		FileInputFormat.setInputPaths(job, new Path(arg0[0]));
		FileOutputFormat.setOutputPath(job, new Path(arg0[1]));
		job.waitForCompletion(true);

		Configuration conf2 = new Configuration();
		Job job2 = Job.getInstance(conf2, "Video Avg Time");
		job2.setJarByClass(VideoPlayerApplication.class);
		job2.setMapperClass(VideoPlayerMapperForVideo.class);
		job2.setReducerClass(VideoPlayerReducer.class);
		job2.setOutputKeyClass(Text.class);
		job2.setOutputValueClass(LongWritable.class);
		FileInputFormat.setInputPaths(job2, new Path(arg0[0]));
		FileOutputFormat.setOutputPath(job2, new Path(arg0[2]));

		System.exit(job2.waitForCompletion(true) ? 0 : 1);
		return 0;
	}
	
	public static void main(String[] args) throws Exception {
		int res = ToolRunner.run(new Configuration(), new VideoPlayerApplication(), args);
        System.exit(res);
	}

}
