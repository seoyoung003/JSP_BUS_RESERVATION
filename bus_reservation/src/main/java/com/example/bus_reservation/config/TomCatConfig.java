package com.example.bus_reservation.config;

import org.apache.coyote.AbstractProtocol;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomCatConfig {

    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();

        // Tomcat 서버의 기본 커넥터 커스터마이징
        factory.addConnectorCustomizers(connector -> {
            // Tomcat의 커넥터에서 프로토콜을 가져와서 수정
            AbstractProtocol<?> protocol = (AbstractProtocol<?>) connector.getProtocolHandler();

            // 최대 연결 수 설정
            protocol.setMaxConnections(200);  // 최대 연결 수 설정

            // 최대 스레드 수 설정
            protocol.setMaxThreads(200);      // 최대 스레드 수 설정

            // 연결 대기 시간 설정 (milliseconds)
            protocol.setConnectionTimeout(30000);  // 30초
        });

        // 포트 변경
        factory.setPort(9090);

        // 서버의 컨텍스트 경로 설정
        factory.setContextPath("/myapp");

        return factory;
    }
}
