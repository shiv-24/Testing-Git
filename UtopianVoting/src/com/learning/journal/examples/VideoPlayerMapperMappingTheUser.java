package com.learning.journal.examples;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class VideoPlayerMapperMappingTheUser extends Mapper<Object, Text, Text, LongWritable> {

	@Override
	protected void map(Object key, Text value, Mapper<Object, Text, Text, LongWritable>.Context context)
			throws IOException, InterruptedException {

		String data[] = value.toString().split(",");

		String userId = data[0];
		String videosStartTime = data[4];
		String videosEndTime = data[5];

		Calendar startTime = Calendar.getInstance();
		Calendar endTime = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		try {
			startTime.setTime(df.parse(videosStartTime));
			endTime.setTime(df.parse(videosEndTime));

			long timeDiff = (endTime.getTimeInMillis() - startTime.getTimeInMillis()) / 1000;
			context.write(new Text(userId), new LongWritable(timeDiff));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
