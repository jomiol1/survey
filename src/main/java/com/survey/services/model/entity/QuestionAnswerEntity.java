package com.survey.services.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


/**
*
* @author jose m oliveros
*/
@Entity
@Data
@Table(
       name = "question_answer")
public class QuestionAnswerEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY)
    private Long id;
    
    @JoinColumn(
            name = "question_id",
            referencedColumnName = "id")
    @ManyToOne(
            fetch = FetchType.LAZY)
    private QuestionEntity questionId;
    
    @JoinColumn(
            name = "answer_id",
            referencedColumnName = "id")
    @ManyToOne(
            fetch = FetchType.LAZY)
    private AnswerEntity answerId;

}
