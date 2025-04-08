package com.example.data.mapper

import com.example.data.model.SchoolListModel
import com.example.domain.model.SchoolList
import com.example.data.util.EntityMapper
import javax.inject.Inject

class SchoolListMapper
@Inject
constructor() : EntityMapper<SchoolListModel, SchoolList> {
    override fun mapFromEntity(entity: SchoolListModel): SchoolList {
        return SchoolList(
            schoolId = entity.schoolId,
            schoolName = entity.schoolName
        )
    }

    override fun mapToEntity(domainModel: SchoolList): SchoolListModel {
        return SchoolListModel(
            schoolId = domainModel.schoolId,
            schoolName = domainModel.schoolName
        )
    }

    fun mapFromEntityList(entities: List<SchoolListModel>): List<SchoolList> {
        return entities.map { mapFromEntity(it) }
    }

    fun mapToEntityList(entities: List<SchoolList>): List<SchoolListModel> {
        return entities.map { mapToEntity(it) }
    }

}
