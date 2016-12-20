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

package com.liferay.portal.tools.theme.builder.maven;

import com.liferay.portal.tools.theme.builder.ThemeBuilder;
import com.liferay.portal.tools.theme.builder.ThemeBuilderArgs;

import java.io.File;

import java.util.List;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.factory.ArtifactFactory;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.artifact.resolver.ArtifactResolver;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.descriptor.PluginDescriptor;

import org.codehaus.plexus.component.repository.ComponentDependency;

/**
 * Build a theme.
 *
 * @author Andrea Di Giorgi
 * @goal build-theme
 */
public class BuildThemeMojo extends AbstractMojo {

	@Override
	public void execute() throws MojoExecutionException {
		try {
			for (ComponentDependency dependency :
					pluginDescriptor.getDependencies()) {

				String artifactId = dependency.getArtifactId();

				if (artifactId.equals("com.liferay.frontend.theme.styled") &&
					(_themeBuilderArgs.getParentDir() == null)) {

					Artifact artifact = resolveArtifact(dependency);

					_themeBuilderArgs.setParentDir(artifact.getFile());

					_themeBuilderArgs.setParentName("_styled");
				}
				else if (artifactId.equals(
							"com.liferay.frontend.theme.unstyled") &&
						 (_themeBuilderArgs.getUnstyledDir() == null)) {

					Artifact artifact = resolveArtifact(dependency);

					_themeBuilderArgs.setUnstyledDir(artifact.getFile());
				}
			}

			ThemeBuilder themeBuilder = new ThemeBuilder(_themeBuilderArgs);

			themeBuilder.build();
		}
		catch (Exception ioe) {
			throw new MojoExecutionException(ioe.getMessage(), ioe);
		}
	}

	/**
	 * @parameter default-value="${maven.war.src}"
	 */
	public void setDiffsDir(File diffsDir) {
		_themeBuilderArgs.setDiffsDir(diffsDir);
	}

	/**
	 * @parameter default-value="${project.artifactId}"
	 */
	public void setName(String name) {
		_themeBuilderArgs.setName(name);
	}

	/**
	 * @parameter default-value="${project.build.directory}/${project.build.finalName}"
	 */
	public void setOutputDir(File outputDir) {
		_themeBuilderArgs.setOutputDir(outputDir);
	}

	/**
	 * @parameter
	 */
	public void setParentDir(File parentDir) {
		_themeBuilderArgs.setParentDir(parentDir);
	}

	/**
	 * @parameter
	 */
	public void setParentName(String parentName) {
		_themeBuilderArgs.setParentName(parentName);
	}

	/**
	 * @parameter default-value="ftl"
	 */
	public void setTemplateExtension(String templateExtension) {
		_themeBuilderArgs.setTemplateExtension(templateExtension);
	}

	/**
	 * @parameter
	 */
	public void setUnstyledDir(File unstyledDir) {
		_themeBuilderArgs.setUnstyledDir(unstyledDir);
	}

	protected Artifact resolveArtifact(ComponentDependency dependency)
		throws Exception {

		Artifact artifact = artifactFactory.createArtifact(
			dependency.getGroupId(), dependency.getArtifactId(),
			dependency.getVersion(), null, dependency.getType());

		artifactResolver.resolve(
			artifact, remoteArtifactRepositories, localArtifactRepository);

		return artifact;
	}

	/**
	 * @component
	 */
	protected ArtifactFactory artifactFactory;

	/**
	 * @component
	 */
	protected ArtifactResolver artifactResolver;

	/**
	 * @parameter expression="${localRepository}"
	 * @readonly
	 * @required
	 */
	protected ArtifactRepository localArtifactRepository;

	/**
	 * @parameter default-value="${plugin}"
	 * @readonly
	 */
	protected PluginDescriptor pluginDescriptor;

	/**
	 * @parameter expression="${project.remoteArtifactRepositories}"
	 * @readonly
	 * @required
	 */
	protected List remoteArtifactRepositories;

	private final ThemeBuilderArgs _themeBuilderArgs = new ThemeBuilderArgs();

}