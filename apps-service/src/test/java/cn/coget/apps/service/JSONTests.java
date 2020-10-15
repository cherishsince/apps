package cn.coget.apps.service;

import org.junit.Test;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode({Mode.AverageTime, Mode.Throughput})
@Warmup(iterations = 1)
@Measurement(iterations = 2, time = 1)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Fork(value = 2)
@Threads(8)
@State(Scope.Benchmark)
@OperationsPerInvocation
public class JSONTests {

    @Test
    @Benchmark
    public void jsonTest() throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JSONTests.class.getSimpleName())
                .build();

        new Runner(opt).run();

        long start = System.currentTimeMillis();
        // do something ...
        System.out.println(System.currentTimeMillis() - start);
    }
}
