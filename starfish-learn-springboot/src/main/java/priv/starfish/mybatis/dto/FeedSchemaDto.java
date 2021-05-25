package priv.starfish.mybatis.dto;

import java.io.Serializable;

public class FeedSchemaDto implements Serializable {

    private static final long serialVersionUID = -5135913626510595819L;

    private Long id;

    private Integer datastandard;  // 行业类型

    private Integer type;  // 模板类型 0：excel 1：xml

    private String content;    // 模板规则

    private String fileurl;	// dfs存的地址

    public FeedSchemaDto(Long id, Integer datastandard, Integer type, String content, String fileurl) {
        this.id = id;
        this.datastandard = datastandard;
        this.type = type;
        this.content = content;
        this.fileurl = fileurl;
    }

    public FeedSchemaDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDatastandard() {
        return datastandard;
    }

    public void setDatastandard(Integer datastandard) {
        this.datastandard = datastandard;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl;
    }

    @Override
    public String toString() {
        return "FeedSchemaDto{" +
                "id=" + id +
                ", datastandard=" + datastandard +
                ", type=" + type +
                ", content='" + content + '\'' +
                ", fileurl='" + fileurl + '\'' +
                '}';
    }
}
