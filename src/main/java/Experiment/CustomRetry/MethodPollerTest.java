package Experiment.CustomRetry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MethodPollerTest {

    private static final Logger log = LoggerFactory.getLogger(MethodPollerTest.class);


    @Test
    public void test() {
        MethodPoller<String, String> poller = new MethodPoller<>();
        String uuidWithOneTwoThree = poller.method(() -> UUID.randomUUID().toString())
                .until(s->s.startsWith("123"))
                .executeSupplier();
        Assert.assertTrue(uuidWithOneTwoThree.startsWith("123"));
        System.out.println(uuidWithOneTwoThree);
    }

    @Test
    public void test2() {

        when(testMethod(anyInt()))
                .thenThrow(new RuntimeException("Test"))
                .thenReturn(100);
        Assert.assertEquals(100, testMethod(10));

    }

    private int testMethod(int input) {
        return input^2;
    }

    @Test
    public void testExceptionLog() {
        log.warn(new RuntimeException("test").getMessage());
    }

}
