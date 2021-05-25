package priv.starfish.mybatis.model;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @description:
 * @author: starfish
 * @date: 2021/2/9 11:31
 */
@Data
@ToString
public class IndustryFieldDO {

    private Integer industryId;
    private String fieldKey;
    private String fieldKeyCn;
    private Integer required;
    private Integer seq;
    private String remark;
    private String demo;
    private Integer status;
    private Integer fieldLen;
    private Integer fieldType;
    private String validateRule;
    private Date gmtCreate;
    private Date gmtModified;
    private Integer pick;

}
