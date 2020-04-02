package cn.smileyan.songci.dao;

import cn.smileyan.songci.entity.Content;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Smileyan
 */
public interface ContentDao extends CrudRepository<Content,Long> {
    /**
     * 根据id查询
     * @param id 编号
     * @return Content对象
     */
    Content getContentById(Long id);

    /**
     * 根据作者进行查询
     * @param author 作者
     * @return 此作者的所有词
     */
    List<Content> findAllByAuthor(String author);

    /**
     * 根据词牌名查询
     * @param name 词牌名
     * @return 词牌名下所有词
     */
    List<Content> findAllByTitleLike(String name);

    /**
     * 分页查询
     * @param pageable 分页
     * @return 此页词
     */
    Page<Content> findAll(Pageable pageable);

    /**
     * 获得所有作者名称
     * @return 作者名称
     */
    @Query(value = "SELECT DISTINCT c.author FROM Content c")
    List<String> listAllAuthor();

    /**
     * 获得所有作者名称
     * @return 作者名称
     */
    @Query(value = "SELECT DISTINCT c.title FROM Content c")
    List<String> listAllTitle();

    /**
     * 获得总体大小
     * @return int 总数目
     */
    @Query(value = "SELECT COUNT(c.id) FROM Content c")
    Integer countId();

    /**
     * 模糊查询
     * @param query
     * @return
     */
    @Query(value = "SELECT c FROM Content c WHERE c.title LIKE :query OR c.author LIKE :query OR c.name LIKE :query OR c.content LIKE :query")
    List<Content> queryContentByAuthorOrTitleOrName(@Param("query") String query);
}
