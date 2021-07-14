package com.wll.mapper;

import com.wll.domain.ImagePath;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Version 1.0
 * @Author:wll
 * @Date:2019/9/24
 * @Content:
 */
public interface ImageMapper {

    void insert(@Param("goodId") int goodId, @Param("filePath") String filePath);

    List<ImagePath> queryPathByGoodId(int goodsId);
}
