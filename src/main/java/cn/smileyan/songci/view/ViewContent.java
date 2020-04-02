package cn.smileyan.songci.view;

/**
 * 显示层对象 Content
 * @author Smileyan
 */
public class ViewContent {
    /**
     * id: 编号
     * name: 名称
     * dynasty: 时期
     * content: 内容
     * preface: 前言
     */
    private Long id;
    private String title;
    private String name;
    private String author;
    private String dynasty;
    private String[] content;
    private String preface;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDynasty() {
        return dynasty;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty;
    }

    public String[] getContent() {
        return content;
    }

    public void setContent(String[] content) {
        this.content = content;
    }

    public String getPreface() {
        return preface;
    }

    public void setPreface(String preface) {
        this.preface = preface;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
