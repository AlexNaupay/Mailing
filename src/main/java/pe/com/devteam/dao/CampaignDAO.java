package pe.com.devteam.dao;

import java.util.List;
import pe.com.devteam.bean.Campaign;
import pe.com.devteam.bean.CampaignCriteria;

public interface CampaignDAO {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table campaigns
	 * @ibatorgenerated
	 */
	int countByExample(CampaignCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table campaigns
	 * @ibatorgenerated
	 */
	int deleteByExample(CampaignCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table campaigns
	 * @ibatorgenerated
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table campaigns
	 * @ibatorgenerated
	 */
	void insert(Campaign record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table campaigns
	 * @ibatorgenerated
	 */
	void insertSelective(Campaign record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table campaigns
	 * @ibatorgenerated
	 */
	List<Campaign> selectByExampleWithBLOBs(CampaignCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table campaigns
	 * @ibatorgenerated
	 */
	List<Campaign> selectByExampleWithoutBLOBs(CampaignCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table campaigns
	 * @ibatorgenerated
	 */
	Campaign selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table campaigns
	 * @ibatorgenerated
	 */
	int updateByExampleSelective(Campaign record, CampaignCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table campaigns
	 * @ibatorgenerated
	 */
	int updateByExampleWithBLOBs(Campaign record, CampaignCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table campaigns
	 * @ibatorgenerated
	 */
	int updateByExampleWithoutBLOBs(Campaign record, CampaignCriteria example);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table campaigns
	 * @ibatorgenerated
	 */
	int updateByPrimaryKeySelective(Campaign record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table campaigns
	 * @ibatorgenerated
	 */
	int updateByPrimaryKeyWithBLOBs(Campaign record);

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table campaigns
	 * @ibatorgenerated
	 */
	int updateByPrimaryKeyWithoutBLOBs(Campaign record);
}