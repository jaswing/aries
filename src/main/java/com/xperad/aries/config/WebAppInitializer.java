package com.xperad.aries.config;

import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletContext;

/**
 * @author sun@xperad.com
 * @version 1.0, 2015/06/07
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void registerDispatcherServlet(ServletContext servletContext) {
        super.registerDispatcherServlet(servletContext);

        servletContext.addListener(new HttpSessionEventPublisher());

    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[] { characterEncodingFilter, new HiddenHttpMethodFilter()};
    }

    //    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//
//        System.out.println("Initializing Application for " + servletContext.getServerInfo());
//
//        // Create the 'root' Spring application context
//        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
//        rootContext.register(AppConfig.class);
////        applicationContext.setConfigLocation(CONFIG_LOCATION);
//
//        // Manage the lifecycle of the root application context
//        servletContext.addListener(new ContextLoaderListener(rootContext));
//
//        // Create the dispatcher servlet's Spring application context
//        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
//        dispatcherContext.register(MvcConfig.class);
//
//        // Add the servlet mapping manually and make it initialize automatically
//        DispatcherServlet dispatcherServlet = new DispatcherServlet(rootContext);
//        ServletRegistration.Dynamic servlet = servletContext.addServlet("mvc", dispatcherServlet);
//
//        servlet.addMapping("/");
//        servlet.setAsyncSupported(true);
//        servlet.setLoadOnStartup(1);
//    }

}
