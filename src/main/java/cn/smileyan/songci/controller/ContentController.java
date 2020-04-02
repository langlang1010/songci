package cn.smileyan.songci.controller;

import cn.smileyan.songci.service.ContentService;
import cn.smileyan.songci.util.RestBody;
import cn.smileyan.songci.view.ViewContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 所有跟查询content相关的接口
 * @author Smileyan
 */
@CrossOrigin
@RestController
@RequestMapping("/content")
public class ContentController {
    @Autowired
    private ContentService contentService;

    @Value("${page_size}")
    private Integer pageSize;

    @GetMapping("/id/{id}")
    private RestBody getContentById(@PathVariable("id")  Long id) {
        ViewContent viewContent = contentService.getContentById(id);
        RestBody body = new RestBody();
        body.setCode(RestBody.SUCCESS);
        body.setMsg("SUCCESS");
        body.setData(viewContent);
        return body;
    }

    @GetMapping("/author/{author}")
    private RestBody listContentByAuthor(@PathVariable("author")  String author) {
        List<ViewContent> viewContents = contentService.listContentByAuthor(author);
        RestBody body = new RestBody();
        body.setCode(RestBody.SUCCESS);
        body.setMsg("SUCCESS");
        body.setData(viewContents);
        return body;
    }

    @GetMapping("/title/{title}")
    private RestBody listContentByTitle(@PathVariable("title")  String title) {
        List<ViewContent> viewContents = contentService.listContentByNameLike(title);
        RestBody body = new RestBody();
        body.setCode(RestBody.SUCCESS);
        body.setMsg("SUCCESS");
        body.setData(viewContents);
        return body;
    }

    @GetMapping("/page/{page}")
    private RestBody listContentByName(@PathVariable("page")  Integer page) {
        List<ViewContent> viewContents = contentService.listContentByPage(page-1,pageSize);
        RestBody body = new RestBody();
        body.setCode(RestBody.SUCCESS);
        body.setMsg("SUCCESS");
        body.setData(viewContents);
        return body;
    }

    @GetMapping("/all/author")
    private RestBody listAllAuthor() {
        List<String> authors = contentService.listAuthor();
        RestBody body = new RestBody();
        body.setCode(RestBody.SUCCESS);
        body.setMsg("SUCCESS");
        body.setData(authors);
        return body;
    }

    @GetMapping("/all/title")
    private RestBody listAllTitle() {
        List<String> authors = contentService.listTitle();
        RestBody body = new RestBody();
        body.setCode(RestBody.SUCCESS);
        body.setMsg("SUCCESS");
        body.setData(authors);
        return body;
    }

    @GetMapping("/all/size")
    private RestBody getSize() {
        Integer size = contentService.countAll();
        RestBody body = new RestBody();
        body.setCode(RestBody.SUCCESS);
        body.setMsg("SUCCESS");
        // 获得总页数 221 + 7 /8
        Integer len = (size+pageSize-1)/pageSize;
        body.setData(len);
        return body;
    }

    /**
     * 获得今日推荐
     * @return 今日推荐
     */
    @GetMapping("/advice")
    private RestBody getAdviceContent() {
        RestBody body = new RestBody();
        body.setCode(RestBody.SUCCESS);
        body.setMsg("SUCCESS");
        body.setData(contentService.getAdvice());
        return body;
    }

    @GetMapping("/search/{query}")
    private RestBody search(@PathVariable("query")  String query) {
        RestBody body = new RestBody();
        body.setCode(RestBody.SUCCESS);
        body.setMsg("SUCCESS");
        body.setData(contentService.queryAllByAuthorOrTitleOrName(query));
        return body;
    }
}
