/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.liferay.portlet.journal.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;
import com.liferay.portlet.journal.model.JournalArticleResource;
import com.liferay.portlet.journal.model.JournalArticleResourceModel;

import java.io.Serializable;

import java.sql.Types;

/**
 * The base model implementation for the JournalArticleResource service. Represents a row in the &quot;JournalArticleResource&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portlet.journal.model.JournalArticleResourceModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link JournalArticleResourceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JournalArticleResourceImpl
 * @see com.liferay.portlet.journal.model.JournalArticleResource
 * @see com.liferay.portlet.journal.model.JournalArticleResourceModel
 * @generated
 */
public class JournalArticleResourceModelImpl extends BaseModelImpl<JournalArticleResource>
	implements JournalArticleResourceModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a journal article resource model instance should use the {@link com.liferay.portlet.journal.model.JournalArticleResource} interface instead.
	 */
	public static final String TABLE_NAME = "JournalArticleResource";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "resourcePrimKey", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "articleId", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table JournalArticleResource (uuid_ VARCHAR(75) null,resourcePrimKey LONG not null primary key,groupId LONG,articleId VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table JournalArticleResource";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portlet.journal.model.JournalArticleResource"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portlet.journal.model.JournalArticleResource"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.portlet.journal.model.JournalArticleResource"),
			true);
	public static long ARTICLEID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long UUID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portlet.journal.model.JournalArticleResource"));

	public JournalArticleResourceModelImpl() {
	}

	public long getPrimaryKey() {
		return _resourcePrimKey;
	}

	public void setPrimaryKey(long primaryKey) {
		setResourcePrimKey(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_resourcePrimKey);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return JournalArticleResource.class;
	}

	public String getModelClassName() {
		return JournalArticleResource.class.getName();
	}

	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	public long getResourcePrimKey() {
		return _resourcePrimKey;
	}

	public void setResourcePrimKey(long resourcePrimKey) {
		_resourcePrimKey = resourcePrimKey;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	public String getArticleId() {
		if (_articleId == null) {
			return StringPool.BLANK;
		}
		else {
			return _articleId;
		}
	}

	public void setArticleId(String articleId) {
		_columnBitmask |= ARTICLEID_COLUMN_BITMASK;

		if (_originalArticleId == null) {
			_originalArticleId = _articleId;
		}

		_articleId = articleId;
	}

	public String getOriginalArticleId() {
		return GetterUtil.getString(_originalArticleId);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public JournalArticleResource toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (JournalArticleResource)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
					JournalArticleResource.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		JournalArticleResourceImpl journalArticleResourceImpl = new JournalArticleResourceImpl();

		journalArticleResourceImpl.setUuid(getUuid());
		journalArticleResourceImpl.setResourcePrimKey(getResourcePrimKey());
		journalArticleResourceImpl.setGroupId(getGroupId());
		journalArticleResourceImpl.setArticleId(getArticleId());

		journalArticleResourceImpl.resetOriginalValues();

		return journalArticleResourceImpl;
	}

	public int compareTo(JournalArticleResource journalArticleResource) {
		long primaryKey = journalArticleResource.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		JournalArticleResource journalArticleResource = null;

		try {
			journalArticleResource = (JournalArticleResource)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = journalArticleResource.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		JournalArticleResourceModelImpl journalArticleResourceModelImpl = this;

		journalArticleResourceModelImpl._originalUuid = journalArticleResourceModelImpl._uuid;

		journalArticleResourceModelImpl._originalGroupId = journalArticleResourceModelImpl._groupId;

		journalArticleResourceModelImpl._setOriginalGroupId = false;

		journalArticleResourceModelImpl._originalArticleId = journalArticleResourceModelImpl._articleId;

		journalArticleResourceModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<JournalArticleResource> toCacheModel() {
		JournalArticleResourceCacheModel journalArticleResourceCacheModel = new JournalArticleResourceCacheModel();

		journalArticleResourceCacheModel.uuid = getUuid();

		String uuid = journalArticleResourceCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			journalArticleResourceCacheModel.uuid = null;
		}

		journalArticleResourceCacheModel.resourcePrimKey = getResourcePrimKey();

		journalArticleResourceCacheModel.groupId = getGroupId();

		journalArticleResourceCacheModel.articleId = getArticleId();

		String articleId = journalArticleResourceCacheModel.articleId;

		if ((articleId != null) && (articleId.length() == 0)) {
			journalArticleResourceCacheModel.articleId = null;
		}

		return journalArticleResourceCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", resourcePrimKey=");
		sb.append(getResourcePrimKey());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", articleId=");
		sb.append(getArticleId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portlet.journal.model.JournalArticleResource");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resourcePrimKey</column-name><column-value><![CDATA[");
		sb.append(getResourcePrimKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>articleId</column-name><column-value><![CDATA[");
		sb.append(getArticleId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = JournalArticleResource.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			JournalArticleResource.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _resourcePrimKey;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private String _articleId;
	private String _originalArticleId;
	private transient ExpandoBridge _expandoBridge;
	private long _columnBitmask;
	private JournalArticleResource _escapedModelProxy;
}