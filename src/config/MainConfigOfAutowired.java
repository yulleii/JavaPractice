package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*
自动装配
 */
@Configuration
@ComponentScan({"dao","service"})
public class MainConfigOfAutowired {

}
