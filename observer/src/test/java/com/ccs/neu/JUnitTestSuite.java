package com.ccs.neu;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AsciiObserverTest.class,
        HexObserverTest.class,
        ReverseObserverTest.class,
        SubjectTest.class
})
public class JUnitTestSuite {
}
