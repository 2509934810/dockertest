package com.helloworld.docker.dockerUtils;

import java.util.HashMap;
import java.util.List;

import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.model.Image;

public interface DockerCmd {
    List<Image> listAllImage();
    void pullImage(String ImageName, String Tag);
    Boolean removeImage(String ImageName, String Tag);
    CreateContainerResponse createContainer(String ImageName, String Tag, HashMap<Integer, Integer> Port, HashMap<String, String> otherCmd);
    Boolean runContainer(String ContainerId);
    Boolean stopContainer(String ContainerId);
    Boolean removeContainer(String ContainerId);
    Boolean removeAllContainer();
}