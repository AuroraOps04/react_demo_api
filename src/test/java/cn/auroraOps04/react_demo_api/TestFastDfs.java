package cn.auroraOps04.react_demo_api;

import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @author AuroraOps04
 * @date 2021/9/1 19:50:15
 * @description
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestFastDfs {
    @Test
    public void testdfs() throws IOException, MyException {
        ClientGlobal.init("C:\\Users\\coderplus-tr\\.code\\IdeaProjects\\react-demo-api\\src\\main\\resources\\fdfs_client.conf");
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getTrackerServer();
        StorageServer storageServer = null;
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        String[] strings = storageClient.upload_file("C:\\Users\\coderplus-tr\\Pictures\\wallhaven-281d5y.png", "png", null);
        for (String str : strings) {
            System.out.println(str);
        }
    }
}
