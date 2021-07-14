package com.wll.service.impl;

import com.wll.domain.Comment;
import com.wll.mapper.CommentMapper;
import com.wll.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:wll
 * @Date: 2019/9/25
 * @Content:
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> queryCommentByGoodsId(Integer goodsId) {
        return commentMapper.queryCommentByGoodsId(goodsId);
    }
}
