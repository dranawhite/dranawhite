package com.dranawhite.jmh;

import com.dranawhite.common.util.CollectionUtil;
import com.dranawhite.exception.DranawhiteException;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @author liangyq
 * @version [1.0, 2018/4/26 16:52]
 */
public class JmhRunner {

	/**
	 * 默认场景下，JMH会找寻标注了@BenchMark类型的方法，它可能会跑一些你所不需要的测试，这样可以通过include和exclude方法来
	 * 完成包含以及排除的语义；
	 * warmupIterations(10)        表示做10轮预热
	 * measurementIterations(10)   表示正式计量测试做10轮
	 * forks(3)                    表示做3轮测试
	 * 采用3组，每组预热10轮，正式计量10轮
	 */
	public static void run(Class<?> ...clz) {
		try {
			OptionsBuilder optionsBuilder = new OptionsBuilder();
			if (CollectionUtil.isNotEmpty(clz)) {
				for(Class<?> cls : clz) {
					optionsBuilder.include(cls.getSimpleName());
				}
			}
			Options opt = optionsBuilder.warmupIterations(10)
					.measurementIterations(10)
					.forks(3)
					.build();
			new Runner(opt).run();
		} catch (RunnerException ex) {
			throw new DranawhiteException("基准测试异常！", ex);
		}
	}

}
