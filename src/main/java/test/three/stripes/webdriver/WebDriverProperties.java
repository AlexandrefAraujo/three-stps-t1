package test.three.stripes.webdriver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Service;


@ComponentScan(basePackages = "test.three.stripes.webdriver")
@PropertySource(value={"classpath:selenium.properties"})
@Service("SELENIUM")

class WebDriverProperties{

    @Value("${webdriver.system.property}")
    String webDriverSytemProperty;

    @Value("${webdriver.path}")
    String webDriverPath;

    @Value("${browser.name}")
    String browser;


    WebDriverProperties loadContext() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(WebDriverProperties.class);

        WebDriverProperties properties = (WebDriverProperties) context.getBean("SELENIUM");

        context.close();
        return properties;
    }

}
