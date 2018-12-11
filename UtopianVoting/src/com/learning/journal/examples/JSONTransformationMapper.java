package com.learning.journal.examples;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.json.simple.JSONObject;

public class JSONTransformationMapper extends Mapper<Object, Text, Text, JSONObject> {

	@Override
	protected void map(Object key, Text value, Mapper<Object, Text, Text, JSONObject>.Context context)
			throws IOException, InterruptedException {

		String data[] = value.toString().split(",");
		Calendar startTime = Calendar.getInstance();
		Calendar endTime = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		JSONObject json = new JSONObject();
		try {

			startTime.setTime(df.parse(data[4]));
			endTime.setTime(df.parse(data[5]));
			long timeDiff = (endTime.getTimeInMillis() - startTime.getTimeInMillis()) / 1000;

			if (timeDiff > 0) {
				json.put("User ID", data[0]);
				json.put("Video ID", data[1]);
				json.put("Session ID", data[2]);
				json.put("IP", data[3]);
				json.put("Start Time", startTime.getTime());
				json.put("End Time", endTime.getTime());
				json.put("Player", data[6]);
				json.put("Play Mode", data[7]);

				context.write(null, json);
			}

		} catch (Exception e) {

		}
	}

}
