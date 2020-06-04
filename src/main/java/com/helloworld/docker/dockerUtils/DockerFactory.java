package com.helloworld.docker.dockerUtils;
import java.util.List;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Image;
import com.github.dockerjava.core.DockerClientBuilder;

public class DockerFactory {
    private String name;
    public DockerClient client;
    private DockerFactory(){

    }
    private DockerFactory(String name){
        this.client = DockerClientBuilder.getInstance().build();
    }
    public static DockerClient getClient(String name){
        return new DockerFactory(name).client;
    }
}