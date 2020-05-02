package Lab2;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(SmokeTest.class)
@Suite.SuiteClasses({HomePageTest.class})//, BasketPageTest.class, CatalogPageTest.class})

public class SmokeTestSuite {

}