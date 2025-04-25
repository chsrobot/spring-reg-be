package th.ac.chs.reg.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import th.ac.chs.reg.interceptor.ApiKeyInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ApiKeyInterceptor())
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/register")
                .excludePathPatterns("/api/login")
                .excludePathPatterns("/api/register")
                .excludePathPatterns("/api/login")
                .excludePathPatterns("/api/makecode")
                .excludePathPatterns("/api/admin/**");
    }
}
