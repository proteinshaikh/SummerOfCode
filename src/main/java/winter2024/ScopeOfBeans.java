package winter2024;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

public class ScopeOfBeans {

    // 1. Singleton Scope Bean
    @Component
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON,
            proxyMode = ScopedProxyMode.TARGET_CLASS)
    class SingletonBean {
        // This bean will be created only once per Spring container lifecycle
    }

    // 2. Prototype Scope Bean
    @Component
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,
            proxyMode = ScopedProxyMode.TARGET_CLASS)
    class PrototypeBean {
        // A new instance of this bean will be created each time it is requested
    }

    // 3. Session Scope Bean (typically used in web applications)
    @Component
    @Scope(value = WebApplicationContext.SCOPE_SESSION,
            proxyMode = ScopedProxyMode.TARGET_CLASS)
    class SessionBean {
        // A new instance will be created for each HTTP session
    }

    // 4. Request Scope Bean (commonly used in REST APIs)
    @Component
    @Scope(value = WebApplicationContext.SCOPE_REQUEST,
            proxyMode = ScopedProxyMode.TARGET_CLASS)
    class RequestBean {
        // A new instance will be created for each HTTP request
    }
}
