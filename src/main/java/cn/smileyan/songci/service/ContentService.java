package cn.smileyan.songci.service;


import cn.smileyan.songci.entity.Content;
import cn.smileyan.songci.view.ViewContent;

import java.util.List;

/**
 * @author Smileyan
 */
public interface ContentService {
    /**
     * 根据Id查询
     * @param id 编号
     * @return Content 对象
     */
    ViewContent getContentById(Long id);

    /**
     * 根据作者获得所有诗词
     * @param author 作者
     * @return list 诗词
     */
    List<ViewContent> listContentByAuthor(String author);

    /**
     * 根据词牌名查询
     * @param name 词牌名
     * @return 所有该词牌名下词
     */
    List<ViewContent> listContentByNameLike(String name);

    /**
     * 分页查询
     * @param page 根据页数查询
     * @return list词
     */
    List<ViewContent> listContentByPage(Integer page, Integer pageSize);

    /**
     * 获得所有作何名称
     * @return list 作者名称
     */
    List<String> listAuthor();

    /**
     * 获得所有词牌名
     * @return 所有词牌名
     */
    List<String> listTitle();

    /**
     *
     * @return
     */
    Integer countAll();

    /**
     * 获得推荐词
     * @return 推荐词
     */
    Content getAdvice();

    /**
     *
     * @param query
     * @return
     */
    List<ViewContent> queryAllByAuthorOrTitleOrName(String query);
}
