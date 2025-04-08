package com.example.data.mapper

import com.example.data.model.SchoolDetailModel
import com.example.data.util.EntityMapper
import com.example.domain.model.SchoolDetails
import javax.inject.Inject

class SchoolDetailsMapper
@Inject
constructor() : EntityMapper<SchoolDetailModel, SchoolDetails> {
    override fun mapFromEntity(entity: SchoolDetailModel): SchoolDetails {
        return SchoolDetails(
            schoolId = entity.schoolId,
            schoolName = entity.schoolName,
            numOfSatTestTakers = entity.numOfSatTestTakers,
            satCriticalReadingAvgScore = entity.satCriticalReadingAvgScore,
            satMathAvgScore = entity.satMathAvgScore,
            satWritingAvgScore = entity.satWritingAvgScore
        )
    }

    override fun mapToEntity(domainModel: SchoolDetails): SchoolDetailModel {
        return SchoolDetailModel(
            schoolId = domainModel.schoolId,
            schoolName = domainModel.schoolName,
            numOfSatTestTakers = domainModel.numOfSatTestTakers,
            satCriticalReadingAvgScore = domainModel.satCriticalReadingAvgScore,
            satMathAvgScore = domainModel.satMathAvgScore,
            satWritingAvgScore = domainModel.satWritingAvgScore
        )
    }

    fun mapFromEntityList(entities: List<SchoolDetailModel>): List<SchoolDetails> {
        return entities.map { mapFromEntity(it) }
    }

    fun mapToEntityList(entities: List<SchoolDetails>): List<SchoolDetailModel> {
        return entities.map { mapToEntity(it) }
    }

}
