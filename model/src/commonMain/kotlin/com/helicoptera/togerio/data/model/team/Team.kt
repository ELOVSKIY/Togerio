package com.helicoptera.togerio.data.model.team

import com.helicoptera.togerio.data.model.project.Project

data class Team(
    val name: String,
    val members: List<TeamMember>,
    val projects: List<Project>
)