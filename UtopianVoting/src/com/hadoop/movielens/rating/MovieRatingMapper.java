package com.hadoop.movielens.rating;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MovieRatingMapper extends Mapper<Object, Text, IntWritable, IntWritable> {

	private final static IntWritable one = new IntWritable(1);

	@Override
	protected void map(Object key, Text value, Mapper<Object, Text, IntWritable, IntWritable>.Context context)
			throws IOException, InterruptedException {

		String[] words = value.toString().split("\t");
//		context.write(new Text(words[2]), one); Calculating the rating of a movie.
//		context.write(new Text(words[1]), one); // For Soring the movie on the basis of Popularity.
		context.write(new IntWritable(Integer.parseInt(words[1])), new IntWritable(Integer.parseInt(words[2])));
	}
}
