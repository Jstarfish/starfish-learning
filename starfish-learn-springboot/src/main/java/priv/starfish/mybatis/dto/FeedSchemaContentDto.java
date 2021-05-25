package priv.starfish.mybatis.dto;

import java.io.Serializable;

/**
 * @description:
 * @author: starfish
 * @date: 2021/2/9 10:54
 */
public class FeedSchemaContentDto implements Serializable {
    private static final long serialVersionUID = -1447393256958351888L;
    private Integer column;
    private String header;
    private String name;
    private Boolean required;
    private String datatype;
    private ValidateRule validaterule;
    private String audittype;

    public FeedSchemaContentDto() {
    }

    public Integer getColumn() {
        return this.column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public String getHeader() {
        return this.header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getRequired() {
        return this.required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public String getDatatype() {
        return this.datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public ValidateRule getValidaterule() {
        return this.validaterule;
    }

    public void setValidaterule(ValidateRule validaterule) {
        this.validaterule = validaterule;
    }

    public String getAudittype() {
        return this.audittype;
    }

    public void setAudittype(String audittype) {
        this.audittype = audittype;
    }

    public String toString() {
        return "FeedSchemaDto [column=" + this.column + ", header=" + this.header + ", name=" + this.name + ", required=" + this.required + ", datatype=" + this.datatype + ", validaterule=" + this.validaterule + ", audittype=" + this.audittype + "]";
    }
}
