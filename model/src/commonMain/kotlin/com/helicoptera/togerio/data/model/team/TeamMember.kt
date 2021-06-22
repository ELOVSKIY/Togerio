package com.helicoptera.togerio.data.model.team

data class TeamMember(
    val user: String,
    val coast: Int,
    val since: String, //TODO(helicoptera) change to DateTime,
    val roles: List<TeamMemberRole>
)