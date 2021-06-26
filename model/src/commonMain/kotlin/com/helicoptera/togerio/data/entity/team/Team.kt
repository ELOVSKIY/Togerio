package com.helicoptera.togerio.data.entity.team

import com.helicoptera.togerio.data.entity.project.Project

data class Team(
    val name: String,
    val members: List<TeamMember>,
    val projects: List<Project>
)