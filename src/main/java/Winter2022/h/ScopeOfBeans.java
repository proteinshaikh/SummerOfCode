package Winter2022.h;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;


public class ScopeOfBeans {
}


//singleton
class Service {

}

//prototype
@Scope("prototype")
class service {

}

//request
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
class MyService {

}

//session
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
class MyComponent {

}


//Application
@Scope(value = WebApplicationContext.SCOPE_APPLICATION, proxyMode = ScopedProxyMode.TARGET_CLASS)
class MyComp {

}

//Websocket
@Scope(value = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS)
class MyServ {

}

