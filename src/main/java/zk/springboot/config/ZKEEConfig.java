package zk.springboot.config;

import be.chillworld.filter.PageDispatcherFilter;
import javax.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.zkoss.zkmax.ui.comet.CometAsyncServlet;

@Import(ZKCEConfig.class)
public class ZKEEConfig {

//    @Bean
//    public ServletContextInitializer manualServletConfigInit() {
//        return servletContext -> {
//            //required to avoid duplicate installing of the CometAsyncServlet
//            //startup sequence in spring boot is different to a normal servlet webapp
//            servletContext.setAttribute("org.zkoss.zkmax.ui.comet.async.installed", true);
//            //servletContext.setAttribute("org.zkoss.zkmax.ws.filter.installed", true); //when FR ZK-3799 is ready (8.5.1 ?)
//        };
//    }

    @Bean
    public ServletRegistrationBean cometAsyncServlet() {
        ServletRegistrationBean reg = new ServletRegistrationBean(new CometAsyncServlet(), "/zkcomet/*");
        reg.setAsyncSupported(true);
        return reg;
    }
    
    @Bean
    public FilterRegistrationBean pageFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(pageFilter());
        registration.addUrlPatterns("/*");
        registration.setName("pageFilter");
        registration.setOrder(99);
        return registration;
    }

    public Filter pageFilter() {
        return new PageDispatcherFilter();
    }
}
