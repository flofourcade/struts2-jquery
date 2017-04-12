package com.jgeppert.jquery.autocompleter;

<<<<<<< Upstream, based on origin/release/4.0.3
<<<<<<< Upstream, based on origin/release/4.0.3
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.contains;
=======
import static org.hamcrest.Matchers.containsInAnyOrder;
>>>>>>> 12c183d references #36 - add integration test for Autocompleter's error topics
=======
import com.jgeppert.jquery.selenium.JQueryIdleCondition;
import com.jgeppert.jquery.selenium.JQueryNoAnimations;
import com.jgeppert.jquery.selenium.WebDriverFactory;
import com.jgeppert.jquery.junit.category.HtmlUnitCategory;
import com.jgeppert.jquery.junit.category.PhantomJSCategory;
>>>>>>> 74116da reverted to fix code style

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
<<<<<<< Upstream, based on origin/release/4.0.3
<<<<<<< Upstream, based on origin/release/4.0.3
import org.openqa.selenium.support.ui.ExpectedConditions;
=======
>>>>>>> 12c183d references #36 - add integration test for Autocompleter's error topics
=======
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
>>>>>>> 74116da reverted to fix code style
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Parameterized.class)
@Category({HtmlUnitCategory.class, PhantomJSCategory.class})
public class AutocompleterTagIT {
<<<<<<< Upstream, based on origin/release/4.0.3
<<<<<<< Upstream, based on origin/release/4.0.3
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                 { "http://localhost:8080/regular" },
                 { "http://localhost:8080/uncompressed" },
                 { "http://localhost:8080/loadatonce" },
                 { "http://localhost:8080/loadfromgoogle" }
           });
    }

    private static final JQueryIdleCondition JQUERY_IDLE = new JQueryIdleCondition();
    private static final JQueryNoAnimations JQUERY_NO_ANIMATIONS = new JQueryNoAnimations();
=======
	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays
		        .asList(new Object[][] { { "http://localhost:8080/regular" }, { "http://localhost:8080/uncompressed" },
		                { "http://localhost:8080/loadatonce" }, { "http://localhost:8080/loadfromgoogle" } });
	}
>>>>>>> 12c183d references #36 - add integration test for Autocompleter's error topics
=======
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                 { "http://localhost:8080/regular" }, 
                 { "http://localhost:8080/uncompressed" },
                 { "http://localhost:8080/loadatonce" }, 
                 { "http://localhost:8080/loadfromgoogle" }  
           });
    }
    
    private static final JQueryIdleCondition JQUERY_IDLE = new JQueryIdleCondition();
    private static final JQueryNoAnimations JQUERY_NO_ANIMATIONS = new JQueryNoAnimations();
>>>>>>> 74116da reverted to fix code style

<<<<<<< Upstream, based on origin/release/4.0.3
<<<<<<< Upstream, based on origin/release/4.0.3
    private String baseUrl;
    private WebDriver driver;
=======
	private static final JQueryIdleCondition JQUERY_IDLE = new JQueryIdleCondition();
	private static final JQueryNoAnimations JQUERY_NO_ANIMATIONS = new JQueryNoAnimations();
>>>>>>> 12c183d references #36 - add integration test for Autocompleter's error topics
=======
    private String baseUrl;        
    private WebDriver driver;        
>>>>>>> 74116da reverted to fix code style

    public AutocompleterTagIT(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Before
    public void before() {
        driver = WebDriverFactory.getWebDriver();
    }

    @After
    public void after() {
        driver.quit();
    }

    @Test
    public void testListData() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/autocompleter/list.action");

        WebElement autocompleteInput = driver.findElement(By.id("autocompleterMonths"));
        WebElement autocompleteInputWidget = driver.findElement(By.id("autocompleterMonths_widget"));

        autocompleteInputWidget.sendKeys("j");
        Thread.sleep(1000);
        Assert.assertEquals(3, driver.findElements(By.tagName("li")).size());

        autocompleteInputWidget.sendKeys("u");
        Thread.sleep(1000);
        Assert.assertEquals(2, driver.findElements(By.tagName("li")).size());

<<<<<<< Upstream, based on origin/release/4.0.3
<<<<<<< Upstream, based on origin/release/4.0.3
        driver.findElements(By.tagName("li")).get(0).click();
        Thread.sleep(1000);
        Assert.assertEquals("June", autocompleteInput.getAttribute("value"));

        //verify #46 - handling of cssClass attribute
        Assert.assertThat(autocompleteInputWidget.getAttribute("class"), containsString("extra-class"));
    }

    @Test
    public void testListDataWithCssErrorClass() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        this.testListData();
        driver.get(baseUrl + "/autocompleter/list.action?addError=true");

        WebElement autocompleteInputWidget = driver.findElement(By.id("autocompleterMonths_widget"));

        //verify #46 - handling of cssErrorClass attribute
        Assert.assertThat(autocompleteInputWidget.getAttribute("class"), containsString("error-class"));
    }
=======
		autocompleteInputWidget.sendKeys("u");
		Thread.sleep(1000);
		Assert.assertEquals(2, driver.findElements(By.tagName("li")).size());
>>>>>>> 12c183d references #36 - add integration test for Autocompleter's error topics
=======
        driver.findElements(By.tagName("li")).get(0).click();
        Thread.sleep(1000);
	Assert.assertEquals("June", autocompleteInput.getAttribute("value"));
    }
>>>>>>> 74116da reverted to fix code style

    @Test
    public void testAjaxArray() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/autocompleter/ajaxarray.action");

        WebElement autocompleteInput = driver.findElement(By.id("autocompleterMonths"));
        WebElement autocompleteInputWidget = driver.findElement(By.id("autocompleterMonths_widget"));

        autocompleteInputWidget.sendKeys("j");
        Thread.sleep(1000);
        Assert.assertEquals(3, driver.findElements(By.tagName("li")).size());

        autocompleteInputWidget.sendKeys("u");
        Thread.sleep(1000);
        Assert.assertEquals(2, driver.findElements(By.tagName("li")).size());

<<<<<<< Upstream, based on origin/release/4.0.3
<<<<<<< Upstream, based on origin/release/4.0.3
        driver.findElements(By.tagName("li")).get(0).click();
        Thread.sleep(1000);
        Assert.assertEquals("June", autocompleteInput.getAttribute("value"));
    }
=======
		autocompleteInputWidget.sendKeys("u");
		Thread.sleep(1000);
		Assert.assertEquals(2, driver.findElements(By.tagName("li")).size());
>>>>>>> 12c183d references #36 - add integration test for Autocompleter's error topics
=======
        driver.findElements(By.tagName("li")).get(0).click();
        Thread.sleep(1000);
	Assert.assertEquals("June", autocompleteInput.getAttribute("value"));
    }
>>>>>>> 74116da reverted to fix code style

    @Test
    public void testAjaxArrayInsideObject() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/autocompleter/ajaxarrayinsideobject.action");

        WebElement autocompleteInput = driver.findElement(By.id("autocompleterMonths"));
        WebElement autocompleteInputWidget = driver.findElement(By.id("autocompleterMonths_widget"));

        autocompleteInputWidget.sendKeys("j");
        Thread.sleep(1000);
        Assert.assertEquals(3, driver.findElements(By.tagName("li")).size());

        autocompleteInputWidget.sendKeys("u");
        Thread.sleep(1000);
        Assert.assertEquals(2, driver.findElements(By.tagName("li")).size());

<<<<<<< Upstream, based on origin/release/4.0.3
<<<<<<< Upstream, based on origin/release/4.0.3
        driver.findElements(By.tagName("li")).get(0).click();
        Thread.sleep(1000);
        Assert.assertEquals("June", autocompleteInput.getAttribute("value"));
    }
=======
		autocompleteInputWidget.sendKeys("u");
		Thread.sleep(1000);
		Assert.assertEquals(2, driver.findElements(By.tagName("li")).size());
>>>>>>> 12c183d references #36 - add integration test for Autocompleter's error topics
=======
        driver.findElements(By.tagName("li")).get(0).click();
        Thread.sleep(1000);
	Assert.assertEquals("June", autocompleteInput.getAttribute("value"));
    }
>>>>>>> 74116da reverted to fix code style

    @Test
    public void testAjaxMapInsideObject() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/autocompleter/ajaxmapinsideobject.action");

        WebElement autocompleteInput = driver.findElement(By.id("autocompleterMonths"));
        WebElement autocompleteInputWidget = driver.findElement(By.id("autocompleterMonths_widget"));

        autocompleteInputWidget.sendKeys("j");
        Thread.sleep(1000);
        Assert.assertEquals(3, driver.findElements(By.tagName("li")).size());

        autocompleteInputWidget.sendKeys("u");
        Thread.sleep(1000);
        Assert.assertEquals(2, driver.findElements(By.tagName("li")).size());

<<<<<<< Upstream, based on origin/release/4.0.3
<<<<<<< Upstream, based on origin/release/4.0.3
        driver.findElements(By.tagName("li")).get(0).click();
        Thread.sleep(1000);
        Assert.assertEquals("6", autocompleteInput.getAttribute("value"));
    }
=======
		autocompleteInputWidget.sendKeys("u");
		Thread.sleep(1000);
		Assert.assertEquals(2, driver.findElements(By.tagName("li")).size());
>>>>>>> 12c183d references #36 - add integration test for Autocompleter's error topics
=======
        driver.findElements(By.tagName("li")).get(0).click();
        Thread.sleep(1000);
	Assert.assertEquals("6", autocompleteInput.getAttribute("value"));
    }
>>>>>>> 74116da reverted to fix code style

    @Test
    public void testAjaxObjectsInsideObject() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/autocompleter/ajaxobjectsinsideobject.action");

        WebElement autocompleteInput = driver.findElement(By.id("autocompleterMonths"));
        WebElement autocompleteInputWidget = driver.findElement(By.id("autocompleterMonths_widget"));

        autocompleteInputWidget.sendKeys("j");
        Thread.sleep(1000);
        Assert.assertEquals(3, driver.findElements(By.tagName("li")).size());

        autocompleteInputWidget.sendKeys("u");
        Thread.sleep(1000);
        Assert.assertEquals(2, driver.findElements(By.tagName("li")).size());

<<<<<<< Upstream, based on origin/release/4.0.3
<<<<<<< Upstream, based on origin/release/4.0.3
        driver.findElements(By.tagName("li")).get(0).click();
        Thread.sleep(1000);
        Assert.assertEquals("6", autocompleteInput.getAttribute("value"));
    }


    /**
     * Issue #36 - verify that errorTopics are fired if AJAX request fail.
     * Autocompleter waiting for a JSON array
     *
     * @throws InterruptedException
     */
    @Test
    public void testAjaxArrayErrorTopic() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/autocompleter/ajaxarrayerrortopic.action");

        WebElement autocompleteInputWidget = driver.findElement(By.id("autocompleterMonths_widget"));
        WebElement errorContainer = driver.findElement(By.id("errorContainer"));

        autocompleteInputWidget.sendKeys("j");
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(errorContainer, By.tagName("p")));
        Assert.assertEquals(0, driver.findElements(By.tagName("li")).size());

        List<WebElement> ps = errorContainer.findElements(By.tagName("p"));
        Assert.assertEquals(2, ps.size());

        List<String> result = new ArrayList<>();
        for (WebElement p : ps) {
            result.add(p.getText());
        }

        Assert.assertThat(result, contains("topic1", "topic2"));

    }

    /**
     * Issue #36 - verify that errorTopics are fired if AJAX request fail.
     * Autocompleter waiting for a JSON array inside an object
     *
     * @throws InterruptedException
     */
    @Test
    public void testAjaxArrayInsideObjectErrorTopic() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(baseUrl + "/autocompleter/ajaxarrayinsideobjecterrortopic.action");

        WebElement autocompleteInputWidget = driver.findElement(By.id("autocompleterMonths_widget"));
        WebElement errorContainer = driver.findElement(By.id("errorContainer"));

        autocompleteInputWidget.sendKeys("j");
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(errorContainer, By.tagName("p")));

        List<WebElement> ps = errorContainer.findElements(By.tagName("p"));
        Assert.assertEquals(2, ps.size());

        List<String> result = new ArrayList<>();
        for (WebElement p : ps) {
            result.add(p.getText());
        }

        Assert.assertThat(result, contains("topic1", "topic2"));

    }
=======
		autocompleteInputWidget.sendKeys("u");
		Thread.sleep(1000);
		Assert.assertEquals(2, driver.findElements(By.tagName("li")).size());

		driver.findElements(By.tagName("li")).get(0).click();
		Thread.sleep(1000);
		Assert.assertEquals("6", autocompleteInput.getAttribute("value"));
	}

	@Test
	public void testAjaxArrayErrorTopic() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);

		driver.get(baseUrl + "/autocompleter/ajaxarrayerrortopic.action");

		WebElement autocompleteInput = driver.findElement(By.id("autocompleterMonths"));
		WebElement autocompleteInputWidget = driver.findElement(By.id("autocompleterMonths_widget"));
		WebElement errorContainer = driver.findElement(By.id("errorContainer"));

		autocompleteInputWidget.sendKeys("j");
		Thread.sleep(1000);
		Assert.assertEquals(0, driver.findElements(By.tagName("li")).size());

		List<WebElement> ps = errorContainer.findElements(By.tagName("p"));
		Assert.assertEquals(2, ps.size());

		List<String> result = new ArrayList<>();
		for (WebElement p : ps) {
			result.add(p.getText());
		}

		Assert.assertThat(result, containsInAnyOrder("topic1", "topic2"));

	}

	@Test
	public void testAjaxArrayInsideObjectErrorTopic() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);

		driver.get(baseUrl + "/autocompleter/ajaxarrayinsideobjecterrortopic.action");

		WebElement autocompleteInput = driver.findElement(By.id("autocompleterMonths"));
		WebElement autocompleteInputWidget = driver.findElement(By.id("autocompleterMonths_widget"));
		WebElement errorContainer = driver.findElement(By.id("errorContainer"));

		autocompleteInputWidget.sendKeys("j");
		Thread.sleep(1000);

		List<WebElement> ps = errorContainer.findElements(By.tagName("p"));
		Assert.assertEquals(2, ps.size());

		List<String> result = new ArrayList<>();
		for (WebElement p : ps) {
			result.add(p.getText());
		}

		Assert.assertThat(result, containsInAnyOrder("topic1", "topic2"));

	}
>>>>>>> 12c183d references #36 - add integration test for Autocompleter's error topics
=======
        driver.findElements(By.tagName("li")).get(0).click();
        Thread.sleep(1000);
	Assert.assertEquals("6", autocompleteInput.getAttribute("value"));
    }
>>>>>>> 74116da reverted to fix code style
}

