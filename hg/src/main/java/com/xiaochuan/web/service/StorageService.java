package com.xiaochuan.web.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;


import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/21 15:02
 */
public interface StorageService {
    void init();
    Path store(MultipartFile file, String targetName);
    Path store(MultipartFile file, Path root, String targetName);
    Stream<Path> loadAll();
    Path load(String filename);
    Resource loadAsResource(String filename);
    void deleteAll();
}
