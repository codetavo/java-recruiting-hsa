package cl.accenture.javarecruitinghsa.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import cl.accenture.javarecruitinghsa.JavaRecruitingHsaApplication;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JavaRecruitingHsaApplication.class);
	}

}
