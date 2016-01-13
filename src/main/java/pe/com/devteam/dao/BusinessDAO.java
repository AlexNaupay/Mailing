package pe.com.devteam.dao;

import java.util.List;
import pe.com.devteam.bean.Business;
import pe.com.devteam.bean.BusinessCriteria;

public interface BusinessDAO {
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table business
     *
     * @ibatorgenerated
     */
    int countByExample(BusinessCriteria example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table business
     *
     * @ibatorgenerated
     */
    int deleteByExample(BusinessCriteria example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table business
     *
     * @ibatorgenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table business
     *
     * @ibatorgenerated
     */
    void insert(Business record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table business
     *
     * @ibatorgenerated
     */
    void insertSelective(Business record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table business
     *
     * @ibatorgenerated
     */
    List<Business> selectByExample(BusinessCriteria example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table business
     *
     * @ibatorgenerated
     */
    Business selectByPrimaryKey(Integer id);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table business
     *
     * @ibatorgenerated
     */
    int updateByExampleSelective(Business record, BusinessCriteria example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table business
     *
     * @ibatorgenerated
     */
    int updateByExample(Business record, BusinessCriteria example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table business
     *
     * @ibatorgenerated
     */
    int updateByPrimaryKeySelective(Business record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table business
     *
     * @ibatorgenerated
     */
    int updateByPrimaryKey(Business record);
}