package com.example.batch.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.example.batch.entity.User;

/**
 * Spring Batch示例
 * @author Kevin
 *
 */
@Configuration
@EnableBatchProcessing // 开启批处理的支持
public class SpringBatchConfig {
	@Autowired
	DataSource dataSource;
	@Autowired
	JobBuilderFactory jobBuilderFactory;
	@Autowired
	StepBuilderFactory stepBuilderFactory;

	/**
	 * 定义Reader，读取ClassPath下的user.csv，并封包到User实体类
	 * @return
	 */
	@Bean
	FlatFileItemReader<User> itemReader() {
		FlatFileItemReader<User> reader = new FlatFileItemReader<User>();
		reader.setLinesToSkip(1);// 跳过表头
		reader.setResource(new ClassPathResource("user.csv"));

		reader.setLineMapper(new DefaultLineMapper<User>() {// entity与csv数据做映射
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(new String[] { "id", "username", "gender", "age" });
						setDelimiter(DELIMITER_COMMA);
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<User>() {
					{
						setTargetType(User.class);
					}
				});
			}
		});
		return reader;
	}

	/**
	 * 定义Writer，用给定的sql将User实体类写入数据库
	 * @return
	 */
	@Bean
	JdbcBatchItemWriter<User> jdbcBatchItemWriter() {
		JdbcBatchItemWriter<User> writer = new JdbcBatchItemWriter<>();
		writer.setDataSource(dataSource);
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<User>());
		writer.setSql("insert into user(id,username,gender,age) values(:id,:username,:gender,:age)");
		return writer;
	}

	/**
	 * 定义步骤，在步骤中绑定Reader和Writer，每读到2条数据及写入数据库
	 * @return
	 */
	@Bean
	Step myStep() {
		return stepBuilderFactory.get("myStep").<User, User>chunk(2).reader(itemReader()).writer(jdbcBatchItemWriter())
				.build();
	}

	/**
	 * 创建任务，使用上面的步骤
	 * @return
	 */
	@Bean
	Job myJob() {
		return jobBuilderFactory.get("myJob").start(myStep()).build();
	}

}
