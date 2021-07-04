package com.helicoptera.togerio.authorization.validation.project

import com.helicoptera.togerio.data.dto.project.Project
import com.helicoptera.togerio.validation.ValidationResult

class ProjectValidator {

    fun validateProject(project: Project): ValidationResult {
       return ValidationResult(true) //TODO add validation logic
    }
}