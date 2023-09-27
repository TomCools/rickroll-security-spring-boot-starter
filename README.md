# Rickroll Security Spring Boot Starter

This starter will reroute configured paths and/or file extensions to a video of Rick Astley - Never Gonna Give You Up.

![Demo](https://github.com/TomCools/rickroll-security-spring-boot-starter/blob/main/docs/rickroll-demo.gif)

## Contribute

You can use the following Gitpod to get started on contributing really quickly ;)

[![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/#https://github.com/TomCools/rickroll-security-spring-boot-starter)

## Example Use Case

Noob hackers often try to access secure pages. The Spring Actuator endpoints are an example where a hacker could do some serious damage. You could put a password on it and you definatly should...but then they don't learn anything. So what you can do is move the actual actuator paths and replace them with Rick Astley! That'll make them think twice!

```
management.endpoints.web.base-path=/manage
rickroll.paths=/actuator
```

Some might even try to reach common PHP pages, such as "/wp-admin/install.php". If you serve no PHP, you can even redirect all requests for PHP pages (or another extension of your choice) to Rick!

```
rickroll.file-extensions=php
```

## Configuration

Add the following dependency to your POM.

```xml
<dependency>
    <groupId>be.tomcools</groupId>
    <artifactId>rickroll-security-spring-boot-starter</artifactId>
    <version>VERSION_HERE</version>
</dependency>
```

Paths you want to redirect can be configured in your Spring Application Properties:

```
rickroll.paths=/admin,/tomcools,/**/bye-bye/*
rickroll.file-extensions=php
```

As of version 1.2.0, we are adding alternative RickRoll videos.
These can be selected by setting the *rickroll.version=**VERSION_NAME*** property.

Available versions:

| VERSION_NAME  | URL                                          |
|---------------|----------------------------------------------|
| original      | https://www.youtube.com/watch?v=dQw4w9WgXcQ  |
| scary-pockets | https://www.youtube.com/watch?v=sQnoZUR6fvY |
| metal-caleb   | https://www.youtube.com/watch?v=MXMf_ni0Msk |

Since version 1.3.0, it's possible to use patterns as path configurations. Patterns give more flexibility and help to reduce the total amount of configured paths.  
Request URIs will be checked on a match using an [`AntPathMatcher`](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/util/AntPathMatcher.html).

## FAQ

### If I have a RestController mapped to /admin and I also add /admin in the rickroll.paths. What will happen?

Why don't you try that for yourself? #evillaugh

The implementation is based on a `Filter.class`. So anything that happens after the filter will be replaced by some nice music.
In case of a RestController, since this comes after the Filter...you will be rickroll'd.

### Why did you hardcode the Rickroll URL?
Let's face it. That video will only be removed from the internet in case of an apocalyptic event. In which case, this project won't matter much either.
We are allowing PRs to add alternative URLs. These will be validated by us before being added to available options.


## Special Thanks
- [Liam Hammet for the original Tweet that started all this madness.](https://twitter.com/LiamHammett/status/1260984553570570240)
- [Andy Wilkinson to suggest the idea of adding it to Spring.](https://twitter.com/ankinson/status/1261724332553900034)
- [My amazing wife](https://twitter.com/HenderickxSilke) for putting up with me and all my sillyness. <3
- [Rick Astley for never giving me up, nor letting me down.](https://www.youtube.com/watch?v=dQw4w9WgXcQ)
