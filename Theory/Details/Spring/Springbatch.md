### Agenda

* Intro
* Setup Workspace
* Tasklet Implementation
* Job Architecture
* Table Sequence

#### Intro

Job is a task having steps
**Types of steps**:

1. Tasklet step - Doing steps in sequential manner
2. Chunk step-consuming data in chunk(batches) having the following components:
   **Item Reader**—Reading from the source
   **Item Processor**-Processing or modifying data
   **Item Writer**—Writing to the destination

#### Setup workspace

1. We need spring batch and any db as dependencies
2. Add annotation @EnableBatchProcessing on the main class

#### Tasklet step Implementation

1. create job example a Sample job andd add annotation @Configuration
2. spring batch provides one class called **JobBuilderFactory** help in creating job. (Autowired)
3. Use a class Job to create a job name provided by spring batch.
4. Spring batch provides one class called **StepBuilderFactory** to create a step
5. after then create a task using Tasklet()

```java
@Configuration
public class SampleJob {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Job firstJob() {
		return jobBuilderFactory.get("First Job")
				.start(firstStep())
				.next(secondStep())
				.build();
	}

	private Step firstStep() {
		return stepBuilderFactory.get("First Step")
				.tasklet(firstTask())
				.build();
	}

	private Tasklet firstTask() {
		return new Tasklet() {

			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				System.out.println("This is first tasklet step");
				return RepeatStatus.FINISHED;
			}
		};
	}

	private Step secondStep() {
		return stepBuilderFactory.get("Second Step")
				.tasklet(secondTask())
				.build();
	}

	private Tasklet secondTask() {
		return new Tasklet() {

			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				System.out.println("This is second tasklet step");
				return RepeatStatus.FINISHED;
			}
		};
	}

}
```

Customized Tasklet

```java

@Service
public class SeconTasklet implements Tasklet {
    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        System.out.println("This is second tasklet step");
        return RepeatStatus.FINISHED;
    }
}
```

```java

@Autowired
private SeconTasklet seconTasklet;

private Step secondStep() {
		return stepBuilderFactory.get("Second Step")
				.tasklet(seconTasklet)
				.build();
	}

```

Job Architecture
JOB-> Job Instance -> Job execution (meta data)

Mysql Connectivity
Add mysql dependency in pom.xml

```
<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<scope>runtime</scope>
		</dependency>
```

Add credentials in application.properties

```java
spring.datasource.url=jdbc:mysql://localhost:3306/springbatch
spring.datasource.username=root
spring.datasource.password=root
##use .sql file . it will not create table everytime. its liik for table if present its skip
spring.batch.jdbc.initialize-schema=always
```

#### Table Sequence

1. batch_job_instance - contains number of jobs configured
2. batch_job_execution—Spring batch store information regarding job execution like when started when ended and status
3. batch_job_execution_context - it's a map.
4. batch_step_execution - when step started ended and status
5. batch_step_execution_context-Its a map
6. batch_step_execution_seq-