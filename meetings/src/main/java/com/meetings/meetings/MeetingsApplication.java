package com.meetings.meetings;

import com.blueveery.springrest2ts.Rest2tsGenerator;
import com.blueveery.springrest2ts.converters.JacksonObjectMapper;
import com.blueveery.springrest2ts.converters.ModelClassesToTsInterfacesConverter;
import com.blueveery.springrest2ts.converters.SpringRestToTsConverter;
import com.blueveery.springrest2ts.filters.ContainsSubStringJavaTypeFilter;
import com.blueveery.springrest2ts.filters.HasAnnotationJavaTypeFilter;
import com.blueveery.springrest2ts.implgens.Angular4ImplementationGenerator;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.meetings.meetings.annotations.ApiEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Set;

@EnableEurekaClient
@SpringBootApplication
public class MeetingsApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MeetingsApplication.class);
	}

	public static void main(String[] args) {
		generateApiTsFile();
		SpringApplication.run(MeetingsApplication.class, args);
	}

	private static void generateApiTsFile() {
		Rest2tsGenerator tsGenerator = new Rest2tsGenerator();

		// Java Classes filtering
		tsGenerator.setModelClassesCondition(new HasAnnotationJavaTypeFilter(ApiEntity.class));
		tsGenerator.setRestClassesCondition(new ContainsSubStringJavaTypeFilter("Controller"));

		// Java model classes converter setup
		JacksonObjectMapper jacksonObjectMapper = new JacksonObjectMapper();
		jacksonObjectMapper.setFieldsVisibility(JsonAutoDetect.Visibility.ANY);
		ModelClassesToTsInterfacesConverter modelClassesConverter = new ModelClassesToTsInterfacesConverter(jacksonObjectMapper);
		tsGenerator.setModelClassesConverter(modelClassesConverter);

		// Spring REST controllers converter
		SpringRestToTsConverter restClassesConverter = new SpringRestToTsConverter(new Angular4ImplementationGenerator());
		tsGenerator.setRestClassesConverter(restClassesConverter);

		// set of java root packages for class scanning
		Set<String> javaPackageSet = Collections.singleton("com.meetings.meetings");
		try {
			tsGenerator.generate(javaPackageSet, Paths.get("./target/generated-sources/api-ts"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
