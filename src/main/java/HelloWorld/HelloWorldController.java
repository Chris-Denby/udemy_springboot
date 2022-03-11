package HelloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@RestController
public class HelloWorldController
{
    //GET
    //URI = /hello-world
    //method - prints "hello world"

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/hello-world")
    public String helloWorld()
    {
        return "Hello world";
    }

    @GetMapping("/hello-world/path-variable/{name}")
    public HelloWorldBean getHelloWorldPathVariable(@PathVariable String name)
    {
        return new HelloWorldBean(String.format("Hello World, %s",name));
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean getHelloWorldBean()
    {
        return new HelloWorldBean("Hello World");
    }

    /**
    @GetMapping("/hello-world-internationalized")
    public String getHelloWorldInternationalization(@RequestHeader(name="Accept-Language", required=false) Locale locale)
    {
        return messageSource.getMessage("good.morning.message",null, LocaleContextHolder);
    }
    **/




}
