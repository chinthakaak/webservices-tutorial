package helloservice.endpoint;

import javax.jws.WebService;

//Service Implementation
@WebService(endpointInterface = "helloservice.endpoint.HelloWorld")
public class HelloWorldImpl implements HelloWorld{


    public String getHelloWorldAsString(String name) {
        return "Hello World JAX-WS " + name;
    }

}
