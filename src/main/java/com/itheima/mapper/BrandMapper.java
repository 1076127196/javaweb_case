package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();


    void add(Brand brand);
    void update(Brand brand);
    void delete(Integer id);
    void deleteByIds(Integer[] ids);
    List<Brand> selectByPage(@Param("begin") int begin, @Param("size") int size);

    int selectTotalCount();

    List<Brand> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("brand") Brand brand);
    int selectTotalCountByCondition(Brand brand);





}
