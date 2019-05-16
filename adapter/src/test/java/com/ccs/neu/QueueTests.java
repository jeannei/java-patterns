package com.ccs.neu;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        IntegerQueueTest.class,
        StringQueueTest.class,
        CollectionQueueTest.class
})
public class QueueTests {
}
