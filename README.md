# Rickroll Security Spring Boot Starter

This starter will reroute configured paths to a video of Rick Astley - Never Gonna Give You Up.

![Demo](https://github.com/TomCools/rickroll-security-spring-boot-starter/blob/master/docs/rickroll-demo.gif)

## Configuration

Add the following dependency to your POM.

```xml
<dependency>
    <groupId>be.tomcools</groupId>
    <artifactId>rickroll-security-spring-boot-starter</artifactId>
    <version>1.1.0</version>
</dependency>
```

Paths you want to redirect can be configured in your Spring Application Properties:

```
rickroll.paths=/admin,/tomcools
rickroll.file-extensions=php
```


## Special Thanks
- [Liam Hammet for the original Tweet that started all this madness.](https://twitter.com/LiamHammett/status/1260984553570570240)
- [Andy Wilkinson to suggest the idea for this kind of filter to Spring.](https://twitter.com/ankinson/status/1261724332553900034)
- [My amazing wife](https://twitter.com/HenderickxSilke) for putting up with me and all my sillyness. <3
- [Rick Astley for never giving me up, nor letting me down.](https://www.youtube.com/watch?v=dQw4w9WgXcQ)
