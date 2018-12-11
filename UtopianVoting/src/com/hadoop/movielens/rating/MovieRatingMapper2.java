package com.hadoop.movielens.rating;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MovieRatingMapper2 extends Mapper<Object, Text, IntWritable, IntWritable> {
	
	@Override
	protected void map(Object key, Text value, Mapper<Object, Text, IntWritable, IntWritable>.Context context)
			throws IOException, InterruptedException {
		String words[]	=	value.toString().split("\t");
		context.write(new IntWritable(Integer.parseInt(words[0])), new IntWritable(Integer.parseInt(words[1])));
	}
}
