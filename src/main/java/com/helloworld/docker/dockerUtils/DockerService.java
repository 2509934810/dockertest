package com.helloworld.docker.dockerUtils;

import java.io.Closeable;
import java.util.HashMap;
import java.util.List;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.async.ResultCallback;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.exception.NotFoundException;
import com.github.dockerjava.api.model.Image;
import com.github.dockerjava.api.model.PullResponseItem;

public class DockerService implements DockerCmd{
    private DockerClient client;
    public PullResponseItem pullResponseItem;
    public String imageName;
    public DockerService(){
    }
    public DockerService(String name){
        System.out.println("docker "+ name + "object are created");
        this.client = DockerFactory.getClient(name);
    }
    public List<Image> listAllImage(){
        return this.client.listImagesCmd().exec();
    };
    public void pullImage(String imageName, String Tag){
        String ImageFullName = imageName + ":" + Tag;
        System.out.println(ImageFullName);
        // this.client.pullImageCmd(ImageFullName).exec();
        // this.client.pullImageCmd(ImageFullName).exec(new ResultCallback<PullResponseItem>() {
        //     public void onStart(Closeable closeAble){
        //         System.out.println("start");
        //     }
        //     public void onNext(PullResponseItem status){
        //         System.out.println(status.getStatus());
        //     }
        //     public void onError(Throwable throwable){
        //         throwable.printStackTrace();
        //     }
        //     public void onComplete(){
        //         System.out.println();
        //     }
        //     public void close(){
        //         System.out.println("close");
        //     }
        // });
    };
    public Boolean removeImage(String imageName, String Tag){
        String ImageFullName = imageName + ":" + Tag;
        try{
            this.client.removeContainerCmd(ImageFullName).exec();
        }catch(NotFoundException e){
            return false;
        }catch(Exception e){
            return false;
        }
        return true;
    };
    public CreateContainerResponse createContainer(String imageName, String Tag, HashMap<Integer, Integer> Port, HashMap<String, String> otherCmd){
        String ImageFullName = imageName + ":" + Tag;
        CreateContainerResponse rsp = null;
        try{
            rsp = this.client.createContainerCmd(ImageFullName).withCmd("").withCmd("").exec();
        }catch(NotFoundException e){
            return rsp;
        }catch(Exception e){
            return rsp;
        }
        return rsp;
    };
    public Boolean runContainer(String containerId){
        try{
            this.client.startContainerCmd(containerId).exec();
        }catch(Exception e){
            return false;
        }
        return true;
    }
    public Boolean stopContainer(String containerId){
        try{
            this.client.stopContainerCmd(containerId).exec();
        }catch(Exception e){
            return false;
        }
        return true;
    };
    public Boolean removeContainer(String containerId){
        try{
            this.client.removeContainerCmd(containerId).exec();
        }catch(NotFoundException e){
            return false;
        }
        return true;
    };
    public Boolean removeAllContainer(){
        List<Container> containers = this.client.listContainersCmd().exec();
        try{
            for (Container container : containers){
                this.client.removeContainerCmd(container.getId()).exec();
            }
        }catch(NullPointerException e){
            return false;
        }
        return true;
    };
}