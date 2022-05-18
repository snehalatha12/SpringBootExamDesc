package com.examDesc.Vo;

import com.examDesc.Model.ExamDesc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseTemplateVo {
private Trainee trainee;
private ExamDesc examdesc;
}
