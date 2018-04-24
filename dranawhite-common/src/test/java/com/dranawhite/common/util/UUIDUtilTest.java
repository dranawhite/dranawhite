package com.dranawhite.common.util;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author liangyq
 * @version [1.0, 2018/4/24 10:39]
 */
public class UUIDUtilTest {

	@Test
	public void testTimeUUID() {
		String uuid = UUIDUtil.getTimedUUID();
		System.out.println(uuid);
	}

	@Test
	public void testTimePatternUUID() {
		System.out.println(UUIDUtil.getTimedPatternUUID());
	}

	public static void main(String[] args) throws Exception {
		UUIDUtilTest test = new UUIDUtilTest();
		File file = new File("F:\\uuid.txt");
		file.createNewFile();
		Queue<String> list = new ArrayBlockingQueue<>(10000000);
		for (int i = 0; i < 200; i++) {
			UUIDGenerator uuidGenerator = test.new UUIDGenerator(list);
			Thread t = new Thread(uuidGenerator);
			t.start();
		}
		while(Thread.activeCount() > 2) {
			Thread.yield();
		}
		System.out.println(list.size());
		OutputStream outs = new FileOutputStream(file);
		PrintWriter writer = new PrintWriter(outs);
		for(String str : list) {
			writer.println(str);
		}
		writer.flush();
		writer.close();
		outs.close();
	}


	class UUIDGenerator implements Runnable {

		private Queue<String> list;

		public UUIDGenerator(Queue<String> list) {
			this.list = list;
		}

		@Override
		public void run() {
			for (int i = 0; i < 50000; i++) {
				String uuid = UUIDUtil.getTimedPatternUUID();
				list.add(uuid);
			}
		}
	}

}
