package com.helicoptera.togerio.user

interface ProjectManager {

    fun createProject(name: String, code: String, description: String)

    fun changeProject(projectId: Int, name: String, code: String, description: String)

    fun deleteProject(projectIfd: Int)

    fun inviteToProject(projectId: Int, userId: Int)

    fun getProjectMembers(projectId: Int) : List<ProjectMember>

}