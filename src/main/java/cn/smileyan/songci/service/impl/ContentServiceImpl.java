package cn.smileyan.songci.service.impl;

import cn.smileyan.songci.dao.ContentDao;
import cn.smileyan.songci.entity.Content;
import cn.smileyan.songci.service.ContentService;
import cn.smileyan.songci.util.ContentViewHelper;
import cn.smileyan.songci.view.ViewContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * @author Smileyan
 */
@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private ContentDao contentDao;

    @Override
    public ViewContent getContentById(Long id) {
        Content content = contentDao.getContentById(id);
        return ContentViewHelper.toViewContent(content);
    }

    @Override
    public List<ViewContent> listContentByAuthor(String author) {
        List<Content> allContent = contentDao.findAllByAuthor(author);
        return ContentViewHelper.toListViewContent(allContent);
    }

    @Override
    public List<ViewContent> listContentByNameLike(String name) {
        List<Content> allContent = contentDao.findAllByTitleLike(name+"%");
        return ContentViewHelper.toListViewContent(allContent);
    }

    @Override
    public List<ViewContent> listContentByPage(Integer page, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        Page<Content> allContent = contentDao.findAll(pageRequest);
        return ContentViewHelper.toListViewContent(allContent);
    }

    @Override
    public List<String> listAuthor() {
        return contentDao.listAllAuthor();
    }

    @Override
    public List<String> listTitle() {
        return contentDao.listAllTitle();
    }

    @Override
    public Integer countAll() {
        return contentDao.countId();
    }

    @Override
    public Content getAdvice() {
        // 1. 获得总数
        Integer MAX = contentDao.countId();

        // 2. 根据日期获得随机种子
        Calendar instance = Calendar.getInstance();
        int seed = instance.get(Calendar.DAY_OF_YEAR);

        // 3.获得随机数
        Random random = new Random(seed);
        long id = Math.abs(random.nextLong())%MAX + 1;
        return contentDao.getContentById(id);
    }

    @Override
    public List<ViewContent> queryAllByAuthorOrTitleOrName(String query) {
        if(query == null || query.trim().length()==0 ) {
            return null;
        }
        List<Content> allContent  = contentDao.queryContentByAuthorOrTitleOrName("%"+query+"%");
        return ContentViewHelper.toListViewContent(allContent);
    }
}
