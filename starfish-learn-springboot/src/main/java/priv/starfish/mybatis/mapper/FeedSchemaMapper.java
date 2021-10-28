package priv.starfish.mybatis.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import priv.starfish.mybatis.dto.FeedSchemaDto;
import priv.starfish.mybatis.model.IndustryFieldDO;

import java.util.List;

/**
 * @description:
 * @author: starfish
 * @date: 2021/2/8 17:54
 */
@Mapper
public interface FeedSchemaMapper {

    @Select("SELECT id,datastandard,type,content FROM feedschema where type = 0 and datastandard = #{datastandard}")
    FeedSchemaDto getContentById(int datastandard);

    @Select("SELECT name FROM kuaitou.sku_attribute where filter_condition = 1")
    List<String> getName();

    @Insert("insert into industry_field_0 (industry_id,field_key,field_key_cn,is_required,seq,field_type,validate_rule,demo,field_length,gmt_create,gmt_modified,is_pick) values(#{industryId},#{fieldKey},#{fieldKeyCn},#{required},#{seq},#{fieldType},#{validateRule},#{demo},#{fieldLen},now(),now(),#{pick})")
    int insertIndustryField(IndustryFieldDO industryField);
}
