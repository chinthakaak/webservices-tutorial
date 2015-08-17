package simpleclient;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;

import helloservice.endpoint.HelloWorld;
import org.csapi.wsdl.parlayx.common.v2_1.faults.PolicyException;
import org.csapi.wsdl.parlayx.common.v2_1.faults.ServiceException;
import org.csapi.wsdl.parlayx.terminal_status.v2_3._interface.TerminalStatus;

public class HelloWorldClient{

    public static void main(String[] args) throws Exception {
//
//        URL url = new URL("http://localhost:9999/ws/hello?wsdl");
//
//        //1st argument service URI, refer to wsdl document above
//        //2nd argument is service name, refer to wsdl document above
//        QName qname = new QName("http://endpoint.helloservice/", "HelloWorldImplService");
//
//        Service service = Service.create(url, qname);
//
//        HelloWorld hello = service.getPort(HelloWorld.class);
//
//        System.out.println(hello.getHelloWorldAsString("hello me"));

        testStatus();
    }

    private static void testStatus() throws MalformedURLException, ServiceException, PolicyException {
        URL url = new URL("http://localhost:8181/cxf/ts/SOAP_v2_2?wsdl");

        //1st argument service URI, refer to wsdl document above
        //2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://www.csapi.org/wsdl/parlayx/terminal_status/v2_3/service", "TerminalStatus");

        Service service = Service.create(url, qname);

        TerminalStatus status = service.getPort(TerminalStatus.class);

        BindingProvider bp = (BindingProvider)status;
        Map<String,Object> map = bp.getRequestContext();
        map.put(BindingProvider.USERNAME_PROPERTY, "tsuser");
        map.put(BindingProvider.PASSWORD_PROPERTY,"1qaz2wsx@");

//        Map<String, Object> req_ctx = ((BindingProvider)status).getRequestContext();
//        req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
//
//        Map<String, List<String>> headers = new HashMap<String, List<String>>();
//        headers.put("Username", Collections.singletonList("tsuser"));
//        headers.put("Password", Collections.singletonList("1qaz2wsx@"));
//        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

        System.out.println(status.getStatus("tel:+16472260269"));
    }

}
