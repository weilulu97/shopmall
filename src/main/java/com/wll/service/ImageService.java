package com.wll.service;

import com.wll.domain.ImagePath;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Version 1.0
 * @Author:wll
 * @Date:2019/9/24
 * @Content:
 */
public interface ImageService {

    /**
     * 保存图片信息
     *
     * @param goodId 商品id
     * @param files  商品图片, 可能为多个图片, 用"," 分隔
     */
    void insertImage(int goodId, MultipartFile[] files);

    List<ImagePath> queryPathByGoodId(int goodsId);
}
