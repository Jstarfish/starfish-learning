package priv.starfish.function;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertThat;

/**
 * @description:
 * @author: starfish
 * @date: 2021/7/12 19:32
 */
public class FunctionInterfaceDemo {

    private static BigInteger generateBigNumber() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {}
        return new BigInteger("12345");
    }


    @Test
    public void givenMemoizedSupplier_whenGet_thenSubsequentGetsAreFast() {
        Supplier<BigInteger> memoizedSupplier;
        memoizedSupplier = Suppliers.memoize(FunctionInterfaceDemo::generateBigNumber);

        BigInteger expectedValue = new BigInteger("12345");
        assertSupplierGetExecutionResultAndDuration(
                memoizedSupplier, expectedValue, 2000D);
        assertSupplierGetExecutionResultAndDuration(
                memoizedSupplier, expectedValue, 0D);
        assertSupplierGetExecutionResultAndDuration(
                memoizedSupplier, expectedValue, 0D);
    }

    private <T> void assertSupplierGetExecutionResultAndDuration(
            Supplier<T> supplier, T expectedValue, double expectedDurationInMs) {
        Instant start = Instant.now();
        T value = supplier.get();
        Long durationInMs = Duration.between(start, Instant.now()).toMillis();
        double marginOfErrorInMs = 100D;

        assertThat(value, is(equalTo(expectedValue)));
        assertThat(
                durationInMs.doubleValue(),
                is(closeTo(expectedDurationInMs, marginOfErrorInMs)));
    }
}
