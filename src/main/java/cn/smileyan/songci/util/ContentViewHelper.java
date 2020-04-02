package cn.smileyan.songci.util;

import cn.smileyan.songci.entity.Content;
import cn.smileyan.songci.view.ViewContent;
import org.springframework.data.domain.Page;

import java.util.LinkedList;
import java.util.List;

/**
 * 将entity层的content转换层显示层对象
 * @author Smileyan
 */
public class ContentViewHelper {

    /**
     * 把Content对象转换成ViewContent对象
     * @param content
     * @return
     */
    public static ViewContent toViewContent(Content content) {
        ViewContent viewContent = new ViewContent();
        // 照抄
        viewContent.setId(content.getId());
        viewContent.setAuthor(content.getAuthor());
        viewContent.setDynasty(content.getDynasty());
        viewContent.setName(content.getName());
        viewContent.setTitle(content.getTitle());
        /**
         * 对于content 需要做以下处理
         * 如果含有字母p则说明含有前言，如果不含字母p则不含前言
         * 根据br切分成上下两部分content
         */
        String poetry = content.getContent() + "";
        // 如果包含两个P，则认为有前言
        char key = 'p';
        String[] contentBody = null;
        String br = "br";
        if (countChar(poetry,key) == 2) {
            // 根据p标签分为三部分
            String[] tempString = poetry.split(key+"");
            String preface = tempString[1];
            viewContent.setPreface(preface);
            // 根据br标签分成两部分
            contentBody = tempString[2].split(br);
        } else {
            poetry = poetry.replace("p","");
            contentBody = poetry.split(br);
            viewContent.setPreface("null");
        }
        viewContent.setContent(contentBody);
        return viewContent;
    }

    /**
     * 把Content类型链表转换成ViewContent类型链表
     * @param contentList Content类型链表
     * @return ContentView类型链表
     */
    public static List<ViewContent> toListViewContent(List<Content> contentList) {
        List<ViewContent> allViewContent = new LinkedList<>();
        for (Content content: contentList) {
            ViewContent viewContent = ContentViewHelper.toViewContent(content);
            allViewContent.add(viewContent);
        }
        return allViewContent;
    }

    public static List<ViewContent> toListViewContent(Page<Content> contentList) {
        List<ViewContent> allViewContent = new LinkedList<>();
        contentList.get().forEach(
                content->{
                    ViewContent viewContent = ContentViewHelper.toViewContent(content);
                    allViewContent.add(viewContent);
                }
        );
        return allViewContent;
    }


    /**
     * 获得某字符串中包含某个字符的数目
     * @param str 字符串
     * @param key 该字符
     * @return 数目
     */
    private static int countChar(String str, char key) {
        int count = 0;
        for (int i=0; i<str.length(); i++) {
            if(str.charAt(i) == key) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String test = "p大健康p23";
        String[] ps = test.split("p");
        System.out.println(ps[2]);
    }

}
