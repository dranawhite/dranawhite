package com.dranawhite.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.util.concurrent.TimeUnit;

/**
 * 吞吐量基准
 *
 * @author liangyq
 * @version [1.0, 2018/4/26 17:08]
 */
public class ThroughputBenchmark implements IBenchmark {

	@Override
	@Benchmark
	@BenchmarkMode({Mode.AverageTime})
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	public void run() {
		benchmark();
	}

	protected void benchmark() {}
}
