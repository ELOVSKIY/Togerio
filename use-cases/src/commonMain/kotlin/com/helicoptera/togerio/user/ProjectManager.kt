package com.helicoptera.togerio.user

import com.helicoptera.data.model.project.ProjectMember

interface ProjectManager {

    fun createProject(name: String, code: String, description: String)

    fun changeProject(projectId: Int, name: String, code: String, description: String)

    fun deleteProject(projectIfd: Int)

    fun inviteToProject(projectId: Int, userId: Int)

    fun getProjectMembers(projectId: Int) : List<ProjectMember>

}