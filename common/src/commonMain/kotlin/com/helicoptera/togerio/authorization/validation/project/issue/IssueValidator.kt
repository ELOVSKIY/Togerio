package com.helicoptera.togerio.authorization.validation.project.issue

import com.helicoptera.togerio.data.dto.project.issue.IssueEntity
import com.helicoptera.togerio.validation.ValidationResult

class IssueValidator {

    fun validateIssue(issue: IssueEntity): ValidationResult {
       return ValidationResult(true) //TODO add validation logic
    }
}