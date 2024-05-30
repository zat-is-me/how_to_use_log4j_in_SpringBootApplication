# How to use log4j in SpringBoot Application

- First add the dependency of spring-boot-starter with excluding spring-boot-starter-logging
    
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
            <exclusions>
                <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-logging</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
- Add the two log4j dependencies        
        
      <dependency>
          <groupId>org.apache.logging.log4j</groupId>
          <artifactId>log4j-api</artifactId>
      </dependency>

      <dependency>
          <groupId>org.apache.logging.log4j</groupId>
          <artifactId>log4j-core</artifactId>
      </dependency>

- For yml file add those dependencies

    
    <dependency>
  		<groupId>com.fasterxml.jackson.dataformat</groupId>
  		<artifactId>jackson-dataformat-yaml</artifactId>
  	</dependency>

  	<dependency>
  		<groupId>com.fasterxml.jackson.core</groupId>
  		<artifactId>jackson-databind</artifactId>
  	</dependency>

- Then add the configuration log4j2.properties or log4j2.yml file


- log4j2.properties

      name=PropertiesConfig
      property.filename = logs
      appenders = console, file
      
      appender.console.type = Console
      appender.console.name = STDOUT
      appender.console.layout.type = PatternLayout
      appender.console.layout.pattern = [%-5level] %d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %c{1} - %msg%n
      
      appender.file.type=file
      appender.file.name=LOGFILE
      appender.file.fileName=springBootlogFile.log
      #appender.file.fileName=C:\\Users\\tatek\\IdeaProjects\\logging.log
      #appender.file.fileName=C:\\Users\\tatek\\IdeaProjects\\seganutBank\\src\\main\\resources\\seganutBankLogs.log
      appender.file.layout.type=PatternLayout
      appender.file.layout.pattern=[%-5level] %d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %c{1} - %msg%n
      
      loggers=file
      logger.file.name=com.tatek.how_to_use_log4j_in_SpringBootApplication
      logger.file.level = DEBUG
      logger.file.additivity = false
      logger.file.appenderRefs = file
      logger.file.appenderRef.file.ref = LOGFILE
      
      #Output to the console
      rootLogger.level = DEBUG
      rootLogger.appenderRef.stdout.ref = STDOUT

  - log4j2.yml
    
  
    Configuration:
        status: warn
        name: YAMLConfigTest
        properties:
            property:
            name: filename
            value: springBootLogFile.log
        thresholdFilter:
            level: debug
        appenders:
            Console:
                name: STDOUT
                target: SYSTEM_OUT
                PatternLayout:
                    Pattern: "%d{yyyy-MM-dd HH:mm:ss.SSS} [%-5level] [%t] %c{1} - %msg%n"
            File:
                name: File
                fileName: ${filename}
                PatternLayout:
                    Pattern: "%d{yyyy-MM-dd HH:mm:ss.SSS} [%-5level] [%t] %c{1} - %msg%n"
        Loggers:
            logger:
                name: com.tatek.how_to_use_log4j_in_SpringBootApplication
                level: debug
                additivity: false
                AppenderRef:
                    ref: File
        Root:
            level: INFO
            AppenderRef:
                ref: STDOUT

 

- Do not forget to change the root package name 
  - 
  - logger.file.name=com.tatek.how_to_use_log4j_in_SpringBootApplication