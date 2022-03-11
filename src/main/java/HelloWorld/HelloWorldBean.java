package HelloWorld;

public class HelloWorldBean
{
    String message;
    public HelloWorldBean(String text)
    {
        this.message = text;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
