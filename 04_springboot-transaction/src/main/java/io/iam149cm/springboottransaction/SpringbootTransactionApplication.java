package io.iam149cm.springboottransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
// @EnableTransactionManagement - plain spring framework 의 경우 필요하지만, spring boot 에서는 자동으로 설정해준다.
public class SpringbootTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTransactionApplication.class, args);
	}

}
