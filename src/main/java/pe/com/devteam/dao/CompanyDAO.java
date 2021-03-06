package pe.com.devteam.dao;

import java.util.List;
import pe.com.devteam.bean.Company;
import pe.com.devteam.bean.CompanyCriteria;

public interface CompanyDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table companies
	 * @ibatorgenerated
	 */
	int countByExample(CompanyCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table companies
	 * @ibatorgenerated
	 */
	int deleteByExample(CompanyCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table companies
	 * @ibatorgenerated
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table companies
	 * @ibatorgenerated
	 */
	void insert(Company record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table companies
	 * @ibatorgenerated
	 */
	void insertSelective(Company record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table companies
	 * @ibatorgenerated
	 */
	List<Company> selectByExample(CompanyCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table companies
	 * @ibatorgenerated
	 */
	Company selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table companies
	 * @ibatorgenerated
	 */
	int updateByExampleSelective(Company record, CompanyCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table companies
	 * @ibatorgenerated
	 */
	int updateByExample(Company record, CompanyCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table companies
	 * @ibatorgenerated
	 */
	int updateByPrimaryKeySelective(Company record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table companies
	 * @ibatorgenerated
	 */
	int updateByPrimaryKey(Company record);
}