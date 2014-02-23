/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.registry.impl;

import com.liferay.registry.ServiceTrackerCustomizer;

/**
 * @author Raymond Augé
 */
public class ServiceTrackerCustomizerAdapter<S, T>
		implements org.osgi.util.tracker.ServiceTrackerCustomizer<S, T> {

	public ServiceTrackerCustomizerAdapter(
		ServiceTrackerCustomizer<S, T> serviceTrackerCustomizer) {

		_serviceTrackerCustomizer = serviceTrackerCustomizer;
	}

	@Override
	public T addingService(
		org.osgi.framework.ServiceReference<S> serviceReference) {

		return _serviceTrackerCustomizer.addingService(
			new ServiceReferenceWrapper<S>(serviceReference));
	}

	@Override
	public void modifiedService(
		org.osgi.framework.ServiceReference<S> serviceReference, T service) {

		_serviceTrackerCustomizer.modifiedService(
			new ServiceReferenceWrapper<S>(serviceReference), service);
	}

	@Override
	public void removedService(
		org.osgi.framework.ServiceReference<S> serviceReference, T service) {

		_serviceTrackerCustomizer.removedService(
			new ServiceReferenceWrapper<S>(serviceReference), service);
	}

	private ServiceTrackerCustomizer<S, T> _serviceTrackerCustomizer;

}