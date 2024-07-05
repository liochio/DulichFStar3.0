package com.dichvudulich;

import com.dichvudulich.hello.Hello;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;



@SuppressWarnings("resource")
@SpringBootApplication
@Configuration
@EnableAspectJAutoProxy
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		Hello hello = (Hello) context.getBean("hello");
		hello.method1();
		System.out.println("\n");
		hello.method2();
	}

}
