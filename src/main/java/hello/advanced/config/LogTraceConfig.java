package hello.advanced.config;

import hello.advanced.trace.logTrace.LogTrace;
import hello.advanced.trace.logTrace.ThreacLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {
    @Bean
    public LogTrace logTrace() {
//        return new FieldLogTrace();
        return new ThreacLocalLogTrace();
    }
}
