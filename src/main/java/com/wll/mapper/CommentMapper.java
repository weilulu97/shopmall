package com.wll.mapper;

import com.wll.domain.Comment;

import java.util.List;

/**
 * @Author:wll
 * @Date: 2019/9/25
 * @Content:
 */
public interface CommentMapper {
    List<Comment> queryCommentByGoodsId(Integer goodsId);
}
