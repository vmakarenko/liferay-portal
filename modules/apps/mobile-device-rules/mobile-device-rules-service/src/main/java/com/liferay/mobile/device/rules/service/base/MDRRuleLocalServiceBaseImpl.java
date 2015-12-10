/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.mobile.device.rules.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.mobile.device.rules.model.MDRRule;
import com.liferay.mobile.device.rules.service.MDRRuleLocalService;
import com.liferay.mobile.device.rules.service.persistence.MDRRuleGroupFinder;
import com.liferay.mobile.device.rules.service.persistence.MDRRuleGroupPersistence;
import com.liferay.mobile.device.rules.service.persistence.MDRRulePersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.service.persistence.SystemEventPersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.exportimport.lar.ExportImportHelperUtil;
import com.liferay.portlet.exportimport.lar.ManifestSummary;
import com.liferay.portlet.exportimport.lar.PortletDataContext;
import com.liferay.portlet.exportimport.lar.StagedModelDataHandlerUtil;
import com.liferay.portlet.exportimport.lar.StagedModelType;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the m d r rule local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.mobile.device.rules.service.impl.MDRRuleLocalServiceImpl}.
 * </p>
 *
 * @author Edward C. Han
 * @see com.liferay.mobile.device.rules.service.impl.MDRRuleLocalServiceImpl
 * @see com.liferay.mobile.device.rules.service.MDRRuleLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class MDRRuleLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements MDRRuleLocalService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.mobile.device.rules.service.MDRRuleLocalServiceUtil} to access the m d r rule local service.
	 */

	/**
	 * Adds the m d r rule to the database. Also notifies the appropriate model listeners.
	 *
	 * @param mdrRule the m d r rule
	 * @return the m d r rule that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public MDRRule addMDRRule(MDRRule mdrRule) {
		mdrRule.setNew(true);

		return mdrRulePersistence.update(mdrRule);
	}

	/**
	 * Creates a new m d r rule with the primary key. Does not add the m d r rule to the database.
	 *
	 * @param ruleId the primary key for the new m d r rule
	 * @return the new m d r rule
	 */
	@Override
	public MDRRule createMDRRule(long ruleId) {
		return mdrRulePersistence.create(ruleId);
	}

	/**
	 * Deletes the m d r rule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ruleId the primary key of the m d r rule
	 * @return the m d r rule that was removed
	 * @throws PortalException if a m d r rule with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public MDRRule deleteMDRRule(long ruleId) throws PortalException {
		return mdrRulePersistence.remove(ruleId);
	}

	/**
	 * Deletes the m d r rule from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mdrRule the m d r rule
	 * @return the m d r rule that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public MDRRule deleteMDRRule(MDRRule mdrRule) {
		return mdrRulePersistence.remove(mdrRule);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(MDRRule.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return mdrRulePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.mobile.device.rules.model.impl.MDRRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return mdrRulePersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.mobile.device.rules.model.impl.MDRRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return mdrRulePersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return mdrRulePersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return mdrRulePersistence.countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public MDRRule fetchMDRRule(long ruleId) {
		return mdrRulePersistence.fetchByPrimaryKey(ruleId);
	}

	/**
	 * Returns the m d r rule matching the UUID and group.
	 *
	 * @param uuid the m d r rule's UUID
	 * @param groupId the primary key of the group
	 * @return the matching m d r rule, or <code>null</code> if a matching m d r rule could not be found
	 */
	@Override
	public MDRRule fetchMDRRuleByUuidAndGroupId(String uuid, long groupId) {
		return mdrRulePersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the m d r rule with the primary key.
	 *
	 * @param ruleId the primary key of the m d r rule
	 * @return the m d r rule
	 * @throws PortalException if a m d r rule with the primary key could not be found
	 */
	@Override
	public MDRRule getMDRRule(long ruleId) throws PortalException {
		return mdrRulePersistence.findByPrimaryKey(ruleId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(com.liferay.mobile.device.rules.service.MDRRuleLocalServiceUtil.getService());
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(MDRRule.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("ruleId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(com.liferay.mobile.device.rules.service.MDRRuleLocalServiceUtil.getService());
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(MDRRule.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("ruleId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(com.liferay.mobile.device.rules.service.MDRRuleLocalServiceUtil.getService());
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(MDRRule.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("ruleId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {
		final ExportActionableDynamicQuery exportActionableDynamicQuery = new ExportActionableDynamicQuery() {
				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary = portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(stagedModelType,
						modelAdditionCount);

					long modelDeletionCount = ExportImportHelperUtil.getModelDeletionCount(portletDataContext,
							stagedModelType);

					manifestSummary.addModelDeletionCount(stagedModelType,
						modelDeletionCount);

					return modelAdditionCount;
				}
			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(new ActionableDynamicQuery.AddCriteriaMethod() {
				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					portletDataContext.addDateRangeCriteria(dynamicQuery,
						"modifiedDate");
				}
			});

		exportActionableDynamicQuery.setCompanyId(portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setGroupId(portletDataContext.getScopeGroupId());

		exportActionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<MDRRule>() {
				@Override
				public void performAction(MDRRule mdrRule)
					throws PortalException {
					StagedModelDataHandlerUtil.exportStagedModel(portletDataContext,
						mdrRule);
				}
			});
		exportActionableDynamicQuery.setStagedModelType(new StagedModelType(
				PortalUtil.getClassNameId(MDRRule.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return mdrRuleLocalService.deleteMDRRule((MDRRule)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return mdrRulePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the m d r rules matching the UUID and company.
	 *
	 * @param uuid the UUID of the m d r rules
	 * @param companyId the primary key of the company
	 * @return the matching m d r rules, or an empty list if no matches were found
	 */
	@Override
	public List<MDRRule> getMDRRulesByUuidAndCompanyId(String uuid,
		long companyId) {
		return mdrRulePersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of m d r rules matching the UUID and company.
	 *
	 * @param uuid the UUID of the m d r rules
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of m d r rules
	 * @param end the upper bound of the range of m d r rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching m d r rules, or an empty list if no matches were found
	 */
	@Override
	public List<MDRRule> getMDRRulesByUuidAndCompanyId(String uuid,
		long companyId, int start, int end,
		OrderByComparator<MDRRule> orderByComparator) {
		return mdrRulePersistence.findByUuid_C(uuid, companyId, start, end,
			orderByComparator);
	}

	/**
	 * Returns the m d r rule matching the UUID and group.
	 *
	 * @param uuid the m d r rule's UUID
	 * @param groupId the primary key of the group
	 * @return the matching m d r rule
	 * @throws PortalException if a matching m d r rule could not be found
	 */
	@Override
	public MDRRule getMDRRuleByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {
		return mdrRulePersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the m d r rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.mobile.device.rules.model.impl.MDRRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of m d r rules
	 * @param end the upper bound of the range of m d r rules (not inclusive)
	 * @return the range of m d r rules
	 */
	@Override
	public List<MDRRule> getMDRRules(int start, int end) {
		return mdrRulePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of m d r rules.
	 *
	 * @return the number of m d r rules
	 */
	@Override
	public int getMDRRulesCount() {
		return mdrRulePersistence.countAll();
	}

	/**
	 * Updates the m d r rule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param mdrRule the m d r rule
	 * @return the m d r rule that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public MDRRule updateMDRRule(MDRRule mdrRule) {
		return mdrRulePersistence.update(mdrRule);
	}

	/**
	 * Returns the m d r rule local service.
	 *
	 * @return the m d r rule local service
	 */
	public MDRRuleLocalService getMDRRuleLocalService() {
		return mdrRuleLocalService;
	}

	/**
	 * Sets the m d r rule local service.
	 *
	 * @param mdrRuleLocalService the m d r rule local service
	 */
	public void setMDRRuleLocalService(MDRRuleLocalService mdrRuleLocalService) {
		this.mdrRuleLocalService = mdrRuleLocalService;
	}

	/**
	 * Returns the m d r rule persistence.
	 *
	 * @return the m d r rule persistence
	 */
	public MDRRulePersistence getMDRRulePersistence() {
		return mdrRulePersistence;
	}

	/**
	 * Sets the m d r rule persistence.
	 *
	 * @param mdrRulePersistence the m d r rule persistence
	 */
	public void setMDRRulePersistence(MDRRulePersistence mdrRulePersistence) {
		this.mdrRulePersistence = mdrRulePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the system event local service.
	 *
	 * @return the system event local service
	 */
	public com.liferay.portal.service.SystemEventLocalService getSystemEventLocalService() {
		return systemEventLocalService;
	}

	/**
	 * Sets the system event local service.
	 *
	 * @param systemEventLocalService the system event local service
	 */
	public void setSystemEventLocalService(
		com.liferay.portal.service.SystemEventLocalService systemEventLocalService) {
		this.systemEventLocalService = systemEventLocalService;
	}

	/**
	 * Returns the system event persistence.
	 *
	 * @return the system event persistence
	 */
	public SystemEventPersistence getSystemEventPersistence() {
		return systemEventPersistence;
	}

	/**
	 * Sets the system event persistence.
	 *
	 * @param systemEventPersistence the system event persistence
	 */
	public void setSystemEventPersistence(
		SystemEventPersistence systemEventPersistence) {
		this.systemEventPersistence = systemEventPersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Returns the m d r rule group local service.
	 *
	 * @return the m d r rule group local service
	 */
	public com.liferay.mobile.device.rules.service.MDRRuleGroupLocalService getMDRRuleGroupLocalService() {
		return mdrRuleGroupLocalService;
	}

	/**
	 * Sets the m d r rule group local service.
	 *
	 * @param mdrRuleGroupLocalService the m d r rule group local service
	 */
	public void setMDRRuleGroupLocalService(
		com.liferay.mobile.device.rules.service.MDRRuleGroupLocalService mdrRuleGroupLocalService) {
		this.mdrRuleGroupLocalService = mdrRuleGroupLocalService;
	}

	/**
	 * Returns the m d r rule group persistence.
	 *
	 * @return the m d r rule group persistence
	 */
	public MDRRuleGroupPersistence getMDRRuleGroupPersistence() {
		return mdrRuleGroupPersistence;
	}

	/**
	 * Sets the m d r rule group persistence.
	 *
	 * @param mdrRuleGroupPersistence the m d r rule group persistence
	 */
	public void setMDRRuleGroupPersistence(
		MDRRuleGroupPersistence mdrRuleGroupPersistence) {
		this.mdrRuleGroupPersistence = mdrRuleGroupPersistence;
	}

	/**
	 * Returns the m d r rule group finder.
	 *
	 * @return the m d r rule group finder
	 */
	public MDRRuleGroupFinder getMDRRuleGroupFinder() {
		return mdrRuleGroupFinder;
	}

	/**
	 * Sets the m d r rule group finder.
	 *
	 * @param mdrRuleGroupFinder the m d r rule group finder
	 */
	public void setMDRRuleGroupFinder(MDRRuleGroupFinder mdrRuleGroupFinder) {
		this.mdrRuleGroupFinder = mdrRuleGroupFinder;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("com.liferay.mobile.device.rules.model.MDRRule",
			mdrRuleLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.liferay.mobile.device.rules.model.MDRRule");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return MDRRuleLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return MDRRule.class;
	}

	protected String getModelClassName() {
		return MDRRule.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = mdrRulePersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.mobile.device.rules.service.MDRRuleLocalService.class)
	protected MDRRuleLocalService mdrRuleLocalService;
	@BeanReference(type = MDRRulePersistence.class)
	protected MDRRulePersistence mdrRulePersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.SystemEventLocalService.class)
	protected com.liferay.portal.service.SystemEventLocalService systemEventLocalService;
	@BeanReference(type = SystemEventPersistence.class)
	protected SystemEventPersistence systemEventPersistence;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = com.liferay.mobile.device.rules.service.MDRRuleGroupLocalService.class)
	protected com.liferay.mobile.device.rules.service.MDRRuleGroupLocalService mdrRuleGroupLocalService;
	@BeanReference(type = MDRRuleGroupPersistence.class)
	protected MDRRuleGroupPersistence mdrRuleGroupPersistence;
	@BeanReference(type = MDRRuleGroupFinder.class)
	protected MDRRuleGroupFinder mdrRuleGroupFinder;
	@BeanReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}