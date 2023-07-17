package examples;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
// With single package name
//@SelectPackages("examples")
//@SelectPackages({"TestProgram", "JunitParameterizeTest","AssumptionTest"})
// With a single class
//@SelectClasses(examples.TestFixtureExample.class)
// with multiple classes
@SelectClasses({
        examples.TestFixtureExample.class,
        examples.TestProgram.class,
        examples.DisabledTestMethodExample.class
})
public class TestSuiteExampleWithSelectPackages {}