//
// Built on Sun Dec 01 04:16:57 CET 2013 by logback-translator
// For more information on configuration files in Groovy
// please see http://logback.qos.ch/manual/groovy.html

// For assistance related to this tool or configuration files
// in general, please contact the logback user mailing list at
//    http://qos.ch/mailman/listinfo/logback-user

// For professional support please see
//   http://www.qos.ch/shop/products/professionalSupport

import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.classic.filter.LevelFilter
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.rolling.FixedWindowRollingPolicy
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy

import static ch.qos.logback.classic.Level.DEBUG
import static ch.qos.logback.classic.Level.ERROR
import static ch.qos.logback.classic.Level.INFO
import static ch.qos.logback.classic.Level.WARN
import static ch.qos.logback.core.spi.FilterReply.ACCEPT
import static ch.qos.logback.core.spi.FilterReply.DENY

appender("CONSOLE", ConsoleAppender) {
  filter(LevelFilter) {
    level = DEBUG
    onMatch = ACCEPT
    onMismatch = DENY
  }
  encoder(PatternLayoutEncoder) {
    pattern = "%d [%t] %-5p %c{50} - %m%n"
  }
}
appender("FILE-DEBUG", RollingFileAppender) {
  filter(LevelFilter) {
    level = DEBUG
    onMatch = ACCEPT
    onMismatch = DENY
  }
  file = "${catalina.base}/logs/weibo-api-debug.log"
  rollingPolicy(FixedWindowRollingPolicy) {
    fileNamePattern = "${catalina.base}/logs/weibo-api-debug.%i"
    minIndex = 1
    maxIndex = 3
  }
  triggeringPolicy(SizeBasedTriggeringPolicy) {
    maxFileSize = "10MB"
  }
  encoder(PatternLayoutEncoder) {
    pattern = "%d [%t] %-5p %c{50} - %m%n"
  }
}
appender("FILE-INFO", RollingFileAppender) {
  filter(LevelFilter) {
    level = INFO
    onMatch = ACCEPT
    onMismatch = DENY
  }
  file = "${catalina.base}/logs/weibo-api-info.log"
  rollingPolicy(FixedWindowRollingPolicy) {
    fileNamePattern = "${catalina.base}/logs/weibo-api-info.%i"
    minIndex = 1
    maxIndex = 3
  }
  triggeringPolicy(SizeBasedTriggeringPolicy) {
    maxFileSize = "10MB"
  }
  encoder(PatternLayoutEncoder) {
    pattern = "%d [%t] %-5p %c{50} - %m%n"
  }
}
appender("FILE-WARN", RollingFileAppender) {
  filter(LevelFilter) {
    level = WARN
    onMatch = ACCEPT
    onMismatch = DENY
  }
  file = "${catalina.base}/logs/weibo-api-warn.log"
  rollingPolicy(FixedWindowRollingPolicy) {
    fileNamePattern = "${catalina.base}/logs/weibo-api-warn.%i"
    minIndex = 1
    maxIndex = 3
  }
  triggeringPolicy(SizeBasedTriggeringPolicy) {
    maxFileSize = "10MB"
  }
  encoder(PatternLayoutEncoder) {
    pattern = "%d [%t] %-5p %c{50} - %m%n"
  }
}
appender("FILE-ERROR", RollingFileAppender) {
  filter(LevelFilter) {
    level = ERROR
    onMatch = ACCEPT
    onMismatch = DENY
  }
  file = "${catalina.base}/logs/weibo-api-error.log"
  rollingPolicy(FixedWindowRollingPolicy) {
    fileNamePattern = "${catalina.base}/logs/weibo-api-error.%i"
    minIndex = 1
    maxIndex = 3
  }
  triggeringPolicy(SizeBasedTriggeringPolicy) {
    maxFileSize = "10MB"
  }
  encoder(PatternLayoutEncoder) {
    pattern = "%d [%t] %-5p %c{50} - %m%n"
  }
}
logger("com.gotour", DEBUG)
root(DEBUG, ["CONSOLE", "FILE-DEBUG", "FILE-INFO", "FILE-WARN", "FILE-ERROR"])

