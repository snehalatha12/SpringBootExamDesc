package com.Trainee.MS.Vo;
import com.Trainee.MS.Model.Trainee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseTemplateVo {
private Trainer trainer;
private Trainee trainee;
}
