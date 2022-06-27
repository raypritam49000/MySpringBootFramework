package com.csv.file.demo.config;
import java.io.IOException;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.csv.file.demo.common.MyCustomReader;
import com.csv.file.demo.common.MyCustomWriter;
import com.csv.file.demo.entity.Employee;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	MyCustomReader myCustomReader;
	
	@Autowired
	MyCustomWriter myCustomWriter;

	@Bean
	public Job createJob() {
		return jobBuilderFactory.get("MyJob")
				.incrementer(new RunIdIncrementer())
				.flow(createStep()).end().build();
	}

	@Bean
	public Step createStep() {
		return stepBuilderFactory.get("MyStep")
				.<Employee, Employee> chunk(1)
				.reader(reader())
				.writer(myCustomWriter)
				.build();
	}
	
	@Bean
	public ItemReader<Employee> reader() {
	    Resource[] resources = null;
	    ResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();   
	    try {
	        resources = patternResolver.getResources("/data/*.csv");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    MultiResourceItemReader<Employee> reader = new MultiResourceItemReader<>();
	    reader.setResources(resources);
	    reader.setDelegate(myCustomReader);
	    return reader;
	}
}