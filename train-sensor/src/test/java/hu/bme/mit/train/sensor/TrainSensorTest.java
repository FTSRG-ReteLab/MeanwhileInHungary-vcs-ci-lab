package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;

public class TrainSensorTest {

    @Before
    public void before() {
        // TODO Add initializations
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        // TODO Delete this and add test cases based on the issues
    }
    
    @Test
    public void FancyTestStub() {
        assertEquals(0,0);

        Map items = ImmutableMap.of("coin", 3, "glass", 4, "pencil", 1);

        items.entrySet()
                .stream()
                .forEach(System.out::println);

        List<String> fruits = Lists.newArrayList("orange", "banana", "kiwi",
                "mandarin", "date", "quince");

        for (String fruit: fruits) {
            System.out.println(fruit);
        }
    }
}
