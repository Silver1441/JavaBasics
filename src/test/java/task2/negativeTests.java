package task2;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@SelectPackages("task2.negative")
@RunWith(JUnitPlatform.class)
public class negativeTests {
}
