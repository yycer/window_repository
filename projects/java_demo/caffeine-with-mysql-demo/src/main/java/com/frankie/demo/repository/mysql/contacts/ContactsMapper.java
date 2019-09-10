package com.frankie.demo.repository.mysql.contacts;

import com.frankie.demo.domain.Consultant;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author: Yao Frankie
 * @date: 2019/9/10 15:27
 */
@Mapper
public interface ContactsMapper {

    @Insert("INSERT INTO consultant(contact_id, name) values(#{contactId}, #{name})")
    void insertConsultant(Consultant consultant);


//    @Select("SELECT contact_id as contactId, name FROM consultant where contact_id = #{contactId}")
    @Select("SELECT contact_id, name FROM consultant where contact_id = #{contactId}")
    Consultant getConsultantById(long contactId);
}
