package data.model.task

import data.model.TaskStatus
import data.model.team.TeamMember

data class Task(
    val number: Int,
    val taskStatus: TaskStatus,
    val title: String,
    val descriptions: String,
    val timeCoast: Int,
    val subTasks: List<Task>,
    val createDate: String,
    val deadLine: String?,
    val developer: TeamMember,
    val observers: List<TeamMember>,
)
