package com.shopme.admin;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String dirName = "user-photos";
        String dirName4 = "users/edit/user-photos";
        String dirName5 = "users/edit/images";
        String dirName6 = "users/images";
        String dirName1 = "users/page/user-photos";
        Path userPhotosDir = Paths.get(dirName);
        Path userPhotosDir1 = Paths.get(dirName);
        String dirName2 = "images";
        String dirName3 = "users/page/images";
        Path userPhotosDir2 = Paths.get(dirName2);
        Path userPhotosDir4 = Paths.get(dirName2);
        Path userPhotosDir3 = Paths.get(dirName);
        Path userPhotosDir5 = Paths.get(dirName2);

        String userPhotosPath = userPhotosDir.toFile().getAbsolutePath();
        String userPhotosPath1 = userPhotosDir1.toFile().getAbsolutePath();
        String userPhotosPath2 = userPhotosDir2.toFile().getAbsolutePath();
        String userPhotosPath3 = userPhotosDir3.toFile().getAbsolutePath();
        String userPhotosPath4 = userPhotosDir4.toFile().getAbsolutePath();
        String userPhotosPath5 = userPhotosDir5.toFile().getAbsolutePath();
  /*      System.out.println(dirName);
        System.out.println(userPhotosPath);
        System.out.println(dirName1);
        System.out.println(userPhotosPath1);
            System.out.println(dirName2);
            System.out.println(userPhotosPath2);
        System.out.println(dirName4);
        System.out.println(userPhotosPath3);
        System.out.println(dirName5);
        System.out.println(userPhotosPath4);
        System.out.println(dirName6);
        System.out.println(userPhotosPath5);*/
        registry.addResourceHandler("/"+dirName+"/**")
                .addResourceLocations("file:/" +userPhotosPath+"/");
        registry.addResourceHandler("/"+dirName1+"/**")
                .addResourceLocations("file:/" +userPhotosPath1+"/");
        registry.addResourceHandler("/"+dirName3+"/**")
                .addResourceLocations("file:/" +userPhotosPath2+"/");
        registry.addResourceHandler("/"+dirName4+"/**")
                .addResourceLocations("file:/" +userPhotosPath3+"/");
        registry.addResourceHandler("/"+dirName5+"/**")
                .addResourceLocations("file:/" +userPhotosPath4+"/");
        registry.addResourceHandler("/"+dirName6+"/**")
                .addResourceLocations("file:/" +userPhotosPath5+"/");
    }
}
