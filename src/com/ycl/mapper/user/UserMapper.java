package com.ycl.mapper.user;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Component;

import com.ycl.bean.manager.user.TUser;

/**
 * 用户mapper
 * @author Administrator
 *
 */
@Component
@Mapper
public interface UserMapper {

    /**
     * 
     * @param loginId
     * @param password
     * @return
     */
    @Select("select c_id,c_name,c_password,c_login_id,n_valid,"
            + "c_create_user,d_create_date,c_update_user,d_update_date "
            + "from t_user where c_login_id = #{loginId} and c_password = #{password}")
    @ResultMap("com.ycl.mapper.user.UserMapper.userMap")
    public List<TUser> getLoginUser(@Param("loginId") String loginId,
            @Param("password") String password);

    /**
     * 获取所有用户
     * @return
     */
    @Select("select c_id,c_name,c_password,c_login_id,c_salt,n_state,n_valid,"
            + "c_create_user,d_create_date,c_update_user,d_update_date "
            + "from t_user ")
    @ResultMap("com.ycl.mapper.user.UserMapper.userMap")
    public List<TUser> getAllUser();

    /**
     * 根据条件查找用户
     * @param user
     * @return
     */
    @SelectProvider(type = UserDynaSqlProvider.class, method = "getUserByUserBean")
    @ResultMap("com.ycl.mapper.user.UserMapper.userMap")
    public List<TUser> getUserByUserBean(TUser user);

    //    public PageInfo<TUser> getUserByCondition(String cLoginId, String cName,
    //            String nState, String nValid);

    /**
     * 新增用户
     * @param user
     * @return
     * @throws Exception
     */
    //    @Insert(" insert into TUser (cId,cName,cPassword,cLoginId,cSalt,nState,nValid,cCreateUser,dCreateDate,cUpdateUser,dUpdateDate) "
    //            + "values(#{cId},#{cName},#{cPassword},#{cLoginId},#{cSalt},#{nState},#{nValid},#{cCreateUser},#{dCreateDate},#{cUpdateUser},#{dUpdateDate})")
    //    @Options(useGeneratedKeys = true, keyProperty = "c_id")
    @Insert(" insert into t_user (c_id,c_name,c_password,c_login_id,c_salt,n_state,n_valid,c_create_user,d_create_date,c_update_user,d_update_date) "
            + "values(#{cId},#{cName},#{cPassword},#{cLoginId},#{cSalt},#{nState},#{nValid},#{cCreateUser},#{dCreateDate},#{cUpdateUser},#{dUpdateDate})")
    public int insert(TUser user) throws Exception;

    @UpdateProvider(type = UserDynaSqlProvider.class, method = "updateUserSql")
    int update(TUser user) throws Exception;
}
