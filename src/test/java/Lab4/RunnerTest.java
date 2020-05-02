package Lab4;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\tanya\\Documents\\GitHub\\spbstu.autotests\\src\\test\\java\\Lab4",
        glue = "Lab4"
)

public class RunnerTest {
}
