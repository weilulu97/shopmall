package com.wll.service.impl;

import com.wll.domain.ImagePath;
import com.wll.mapper.ImageMapper;
import com.wll.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @Version 1.0
 * @Author:wll
 * @Date:2019/9/24
 * @Content:
 */
@Service
public class ImageServiceImpl implements ImageService {

    // 日志组件
    private static final Logger logger = LoggerFactory.getLogger(ImageServiceImpl.class);

    @Autowired
    private ImageMapper imageMapper;

    @Override
    public void insertImage(int goodId, MultipartFile[] files) {

        // 1. 图片上传
        if (files == null || files.length == 0) {
            logger.error("上传图片为空, goodId={}", goodId);
            return;
        }

        // 该路径在tomcat的虚拟路径名为"upload"
        File parentFile = new File("D://uploadImage");
        if (parentFile == null || !parentFile.exists()) {
            parentFile.mkdirs();
        }

        for (MultipartFile file : files) {
            if (file == null || file.isEmpty()) {
                continue;
            }

            // 这个图片肯定不为空, 需要上传
            // 需要为上传的图片起一个不会重复的名字
            String targetFileName = UUID.randomUUID().toString().replace("-", "") + file.getOriginalFilename();
            File targetFile = new File(parentFile.getPath() + File.separator + targetFileName);

            try {
                file.transferTo(targetFile);

                // 绑定goodsId和路径path
                // 2. 插入imagepath表
                // path为虚拟路径
                imageMapper.insert(goodId, "/upload/" + targetFileName);
            } catch (IOException e) {
                logger.error("上传图片失败, goodId={}, fileName={}", goodId, file.getOriginalFilename());
                continue;
            }
        }
    }

    @Override
    public List<ImagePath> queryPathByGoodId(int goodsId) {
        return imageMapper.queryPathByGoodId(goodsId);
    }
}
