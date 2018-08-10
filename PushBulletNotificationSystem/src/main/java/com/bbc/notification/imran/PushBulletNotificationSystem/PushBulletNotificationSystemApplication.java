package com.bbc.notification.imran.PushBulletNotificationSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 * Main Spring class
 * 
 * @author Imran Hyderi
 *
 */
@EnableJpaRepositories("com.bbc.notification.imran.repository")
@EntityScan("com.bbc.notification.imran.dto")
@SpringBootApplication(scanBasePackages={"com"})
public class PushBulletNotificationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PushBulletNotificationSystemApplication.class, args);
	}
}
