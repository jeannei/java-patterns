package com.ccs.neu;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BitVectorTest.class,
        BitVectorNoIteratorTest.class
})
public class JUnitTestSuite {
}
