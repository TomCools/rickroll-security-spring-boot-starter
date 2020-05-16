# Rickroll Security Spring Boot Starter

This starter will reroute configured paths to a video of Rick Astley - Never Gonna Give You Up.

![Demo](https://github.com/TomCools/rickroll-security-spring-boot-starter/blob/master/static/rickroll-demo.gif)

## Configuration

Add the following dependency to your POM.

```xml
<dependency>
    <groupId>be.tomcools</groupId>
    <artifactId>rickroll-security-spring-boot-starter</artifactId>
    <version>1.0.0</version>
</dependency>
```

Paths you want to redirect can be configured in your Spring Application Properties:

```
rickroll.paths=/admin,/tomcools
```


## Contributions
Thank you to:
- Liam Hammet for the original Tweet that started all this madness.
- Andy Wilkinson to suggest the idea for this kind of filter to Spring.
- Rick Astley for never giving me up, nor letting me down. <3