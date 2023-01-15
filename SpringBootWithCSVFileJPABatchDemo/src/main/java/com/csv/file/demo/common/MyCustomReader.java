package com.csv.file.demo.common;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import com.csv.file.demo.entity.Employee;

@Component
public class MyCustomReader extends FlatFileItemReader<Employee> implements ItemReader<Employee> {

	public MyCustomReader() {
       setResource(new FileSystemResource("data/input.csv"));
		//setResource(new FileSystemResource("input.csv"));
		setLinesToSkip(1);
		setLineMapper(getDefaultLineMapper());
	}

	public DefaultLineMapper<Employee> getDefaultLineMapper() {
		DefaultLineMapper<Employee> defaultLineMapper = new DefaultLineMapper<Employee>();

		DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
		delimitedLineTokenizer.setNames(new String[] { "id", "name", "salary" });
		defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);

		BeanWrapperFieldSetMapper<Employee> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<Employee>();
		beanWrapperFieldSetMapper.setTargetType(Employee.class);
		defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);

		return defaultLineMapper;
	}
}