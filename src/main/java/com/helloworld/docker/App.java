package com.helloworld.docker;

import java.util.List;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Image;
import com.github.dockerjava.api.model.SearchItem;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;
import com.helloworld.docker.dockerUtils.DockerFactory;
import com.helloworld.docker.dockerUtils.DockerService;

import org.apache.commons.lang.ObjectUtils.Null;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DockerService docker = new DockerService("123");
        // List<Image> images =  docker.listAllImage();
        // for (Image image : images) {
        //     try{
        //         System.out.println(image.getRepoTags()[0]);
        //     }catch(NullPointerException e){

        //     }
        // }
        docker.pullImage("hello-world", "latest");
        // docker.createContainer(imageName, Tag, Port, otherCmd)
    }
}
