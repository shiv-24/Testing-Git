package com.learning.journal.examples;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class VideoPlayerReducer extends Reducer<Text, LongWritable, Text, LongWritable> {

	@Override
	protected void reduce(Text arg0, Iterable<LongWritable> arg1,
			Reducer<Text, LongWritable, Text, LongWritable>.Context arg2) throws IOException, InterruptedException {
		int count = 0;
		long input = 0;

		for (LongWritable value : arg1) {
			input += value.get();
			count++;
		}

		input /= count;
		arg2.write(arg0, new LongWritable(input));
	}
}
