package com.xiaochuan.web.service.impl;

import com.xiaochuan.config.QualityReportProperties;
import com.xiaochuan.web.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

/**
 * @author wangxiaochuan
 * @version 1.0.0
 * @date 2018/8/21 15:08
 */
@Service
public class FileSystemStorageServiceImpl implements StorageService {
    private final Path rootLocation;

    @Autowired
    public FileSystemStorageServiceImpl(QualityReportProperties storageProperties) {
        this.rootLocation = Paths.get(storageProperties.getUpload());
    }

    @Override
    public void init() {
        initPath(rootLocation);
    }

    private void initPath(Path path) {
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }

    @Override
    public Path store(MultipartFile file, String targetName) {

        return this.store(file, this.rootLocation, targetName);
    }

    @Override
    public Path store(MultipartFile file, Path root, String targetName) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        if (!Files.exists(root)) {
            this.initPath(root);
        }
        Path target = root.resolve(targetName);
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + filename);
            }

            if (filename.contains("..")) {
                throw new StorageException("Cannot store file with relative path outside current directory " + filename);
            }

            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, target, StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            throw new StorageException("Failed to store file " + filename, e);
        }

        return target;
    }

    @Override
    public Stream<Path> loadAll() {
        return null;
    }

    @Override
    public Path load(String filename) {
        return null;
    }

    @Override
    public Resource loadAsResource(String filename) {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
