package com.hadoop.movielens.rating;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class MovieRatingReducer2 extends Reducer<IntWritable, IntWritable, IntWritable, IntWritable> {

	@Override
	protected void reduce(IntWritable arg0, Iterable<IntWritable> arg1,
			Reducer<IntWritable, IntWritable, IntWritable, IntWritable>.Context arg2)
			throws IOException, InterruptedException {

		for (IntWritable value : arg1) {

			arg2.write(value, arg0);
		}

	}

}
